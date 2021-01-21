package com.vic.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 文件工具类
 * @author Victor
 * date: 2019/8/3 10:35
 */
public class FileUtils {

    public static void main(String[] args) throws InterruptedException {
//        String imageUrl = "http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2019-05-05/30_01.png";
//        System.out.println(getBase64StrFromUrl(imageUrl));

//        testDeleteFile();
    }

    private static void testDeleteFile() {

        File file = FileUtils.getFileByUrl("http://waterelephant.oss-cn-shanghai.aliyuncs.com/upload/backend/2019-11-28/34_03.jpg", "jpg");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        if(file.exists()) {
            file.delete();
//            file.deleteOnExit();
        }

    }


    public static String fileToBase64(String path) {
        String base64 = null;
        InputStream in = null;
        try {
            File file = new File(path);
            in = new FileInputStream(file);
            byte[] bytes=new byte[(int)file.length()];
            in.read(bytes);
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64;
    }

    /**
     * 通过url获取文件
     * 注意：本地会产生临时文件
     * @param fileUrl 文件路径
     * @param suffix 文件后缀
     * @return
     */
    public static File getFileByUrl(String fileUrl, String suffix) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedOutputStream stream = null;
        InputStream inputStream = null;
        File file = null;
        try {
            URL url = new URL(fileUrl);
            // 打开链接
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            // 设置为get请求方式
            conn.setRequestMethod("GET");
            // 设置连接超时时间为5秒
            conn.setConnectTimeout(5 * 1000);
            // 通过输入流获取图片数据
            inputStream = conn.getInputStream();

            byte[] buffer = new byte[1024];

            int len = 0;

            while((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }

            file = File.createTempFile("pattern", "." + suffix, new File("d:\\var"));

            System.out.println("临时文件创建成功: " + file.getCanonicalPath());

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            stream = new BufferedOutputStream(fileOutputStream);

            stream.write(outputStream.toByteArray());

        } catch (Exception e) {
            System.out.println("获取服务图片异常:" + e);
        } finally {
            try {
                if(inputStream != null)
                    inputStream.close();
                if(stream != null)
                    stream.close();
                if(outputStream != null)
                    outputStream.close();
            } catch (Exception e) {
                System.out.println("关闭流异常:" + e);
            }
        }
        return file;
    }

    /**
     * 通过URL获取base64
     * @param imgUrl
     * @return
     */
    public static String getBase64StrFromUrl(String imgUrl) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        InputStream inputStream = null;
        try {
            // 创建URL
            URL url = new URL(imgUrl);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            inputStream = conn.getInputStream();
            // 将内容读取内存中
            int len = 0;
            while ((len = inputStream.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 关闭流
            inputStream.close();
        } catch (IOException e) {
            System.out.println("通过URL获取base64异常:" + e);
        } finally {
            try {
                if(inputStream != null)
                    inputStream.close();
                if(data != null)
                    data.close();
            } catch (Exception e) {
                System.out.println("关闭流异常:" + e);
            }
        }
        // 对字节数组Base64编码
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        String base64Str = encoder.encodeToString(data.toByteArray());
        return base64Str;
    }

}
