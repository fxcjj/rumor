package com.vic.md5;

import org.springframework.util.DigestUtils;

/**
 * MD5工具类
 * 使用的是Spring的工具类
 * @author 罗利华
 * date: 2019/6/20 19:45
 */
public class MD5Utils1 {

    /**
     * 混淆字符串
     */
    private static final String salt = "#@#$^&*()**!%%***&&&&@@@";

    public static void main(String[] args) {
        String str = "2342";
        String encodeStr = md5(str, salt);
        System.out.println(encodeStr);
        System.out.println(verify(str, salt, encodeStr));

    }

    /**
     * md5加密方法
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str, String salt) {
        String base = str + "/" + salt;
        String encodeStr = DigestUtils.md5DigestAsHex(base.getBytes());
        return encodeStr;
    }

    /**
     * md5验证方法
     * @param str 明文
     * @param salt 混淆字符串
     * @param md5 md5加密后的字符串
     * @return
     */
    public static boolean verify(String str, String salt, String md5) {
        // 加密后的字符串
        String md5Text = md5(str, salt);
        if(md5Text.equalsIgnoreCase(md5)) {
            // 验证通过
            return true;
        }
        return false;
    }


}
