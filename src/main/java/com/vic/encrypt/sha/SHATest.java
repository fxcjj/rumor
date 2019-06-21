package com.vic.encrypt.sha;

import java.security.MessageDigest;

/**
 * sha加密算法
 *
 * https://www.cnblogs.com/foreverzxb/p/5349261.html
 *
 * @author Victor
 * date: 2019/6/21 10:56
 */
public class SHATest {

    public static void main(String[] args) throws Exception {
        String str = "qwertyuiopdfa";
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + encode(str));
        System.out.println("SHA后length：" + encode(str).length());
    }

    /**
     * sha加密，生成40位sha码
     * @param str
     * @return
     * @throws Exception
     */
    public static String encode(String str) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        byte[] byteArray = str.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
