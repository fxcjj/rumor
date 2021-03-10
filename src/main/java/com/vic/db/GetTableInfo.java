package com.vic.db;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 罗利华
 * date: 2021/3/10 13:53
 */
public class GetTableInfo {
    /**
     * 这里是MySQL连接方法
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PASSWORD = "Cet@dQ7h5F";
    private static final String USERNAME = "watcher";
    private static final String URL = "jdbc:mysql://10.50.21.241:4000/security_watch_dev" + "?useUnicode=true&characterEncoding=UTF-8";

    private static final String entityDir = "D:\\github\\rumor\\src\\main\\java\\com\\vic\\db\\entity";
    // 指定类所在包名
    private static String packageName = "com.vic.db.entity";

    private static final String SQL = "SELECT * FROM ";// 数据库操作

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("can not load jdbc driver");
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("get connection failure");
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("close connection failure");
            }
        }
    }
    /**
     * 获取数据库下的所有表名
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables(null, null, null, new String[] { "TABLE" });
            while(rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("getTableNames failure");
        } finally {
            try {
                rs.close();
                closeConnection(conn);
            } catch (SQLException e) {
                System.out.println("close ResultSet failure");
            }
        }
        return tableNames;
    }

    /**
     * 获取表中所有字段名称
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnNames(String tableName) throws Exception {
        List<String> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;

        File directory = new File(entityDir + "\\" + camel(tableName, "_", true) + ".java");
        FileWriter fw = new FileWriter(directory);
        PrintWriter pw = new PrintWriter(fw);

        pw.write("package " + packageName + ";\r\n");
        pw.write("\r\n");

        pw.write("import java.util.*;\r\n\n");

        pw.write("/**\r\n");
        pw.write(" * " + getCommentByTableName(tableName) + "\r\n");
        pw.write(" * @author luolilua\r\n");
        pw.write(" * @date " + LocalDateTime.now() + "\r\n");
        pw.write(" */");
        pw.write("\r\npublic class " + camel(tableName, "_", true) + " extends BaseEntity {\r\n");

        try {
            pStemt = conn.prepareStatement(tableSql);
            // 结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            // 表的字段备注列表
            List<String> columnComments = getColumnComments(tableName);
            // 表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                // 这里备注信息要一致
                createProperty(pw, sqlType2JavaType(rsmd.getColumnTypeName(i + 1)), rsmd.getColumnName(i + 1), columnComments.get(i));
            }

            if (directory.exists()) {
            } else {
                directory.createNewFile();
            }

            pw.write("}\r\n");

            pw.flush();
            pw.close();

        } catch (SQLException e) {
            System.out.println("getColumnNames failure");
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    System.out.println("getColumnNames close pstem and connection failure");
                }
            }
        }
        return columnNames;
    }


    // 判断属性类型
    public static String sqlType2JavaType(String sqlType) {
        if(sqlType.equalsIgnoreCase("bit")){
            return "boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "short";
        }else if(sqlType.equalsIgnoreCase("int") || "INT UNSIGNED".equalsIgnoreCase(sqlType)){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("bigint") || "BIGINT UNSIGNED".equalsIgnoreCase(sqlType)){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "Float";
        } else if(sqlType.equalsIgnoreCase("double")){
            return "Double";
        } else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")){
            return "Double";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime") || "TIMESTAMP".equalsIgnoreCase(sqlType)){
            return "Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blod";
        }
        return null;
    }

    /**
     * 生成属性
     */
    public static void createProperty(PrintWriter pw, String javaType, String colName, String remark) {
        pw.write("\t/**\r\n");
        pw.write("\t * " + remark + "\r\n");
        pw.write("\t */\r\n");
        pw.write("\t@Column(name = \"" + colName + "\")\r\n");
        pw.write("\tprivate " + javaType + " " + camel(colName, "_", false) + ";\r\n\r\n");
    }

    /**
     * 驼峰名称
     * @param str
     * @param delimiter
     * @param upperFirstWord
     * @return
     */
    private static String camel(String str, String delimiter, boolean upperFirstWord) {
        String[] split = str.split(delimiter);
        if(split.length == 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split.length; i++) {
            if(i == 0) {
                if(!upperFirstWord) {
                    sb.append(split[i]);
                } else {
                    sb.append(upperFirstWord(split[i]));
                }
            } else {
                sb.append(upperFirstWord(split[i]));
            }
        }
        return sb.toString();
    }

    private static String upperFirstWord(String str) {
        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
            ch[0] = (char)(ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 表注释
     * @param tableName
     * @return
     * @throws Exception
     */
    public static String getCommentByTableName(String tableName) throws Exception {
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName);
        if (rs != null && rs.next()) {
            String createDDL = rs.getString(2);
            String comment = parse(createDDL);
            rs.close();
            stmt.close();
            return comment;
        }
        return null;
    }

    /**
     * 返回注释信息
     * @param all
     * @return
     */
    public static String parse(String all) {
        String comment;
        int index = all.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = all.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        return comment;
    }

    /**
     * 获取表中所有字段类型
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnTypes.add(rsmd.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            System.out.println("getColumnTypes failure");
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    System.out.println("getColumnTypes close pstem and connection failure");
                }
            }
        }
        return columnTypes;
    }

    /**
     * 获取表中字段的所有注释
     * @param tableName
     * @return
     */
    public static List<String> getColumnComments(String tableName) {
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt;
        String tableSql = SQL + tableName;
        List<String> columnComments = new ArrayList<>();//列名注释集合
        ResultSet rs = null;
        try {
            pStemt = conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                columnComments.add(rs.getString("Comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    System.out.println("getColumnComments close ResultSet and connection failure");
                }
            }
        }
        return columnComments;
    }


    public static void main(String[] args) throws Exception {
        String t = "oa_branch";
        getColumnNames(t);


    }

}
