package com.vic.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 罗利华
 *
 * https://blog.csdn.net/qq_30683329/article/details/80879058
 * https://www.cnblogs.com/hihtml5/p/6064999.html
 * https://blog.csdn.net/nicewuranran/article/details/51901147
 * date: 2019/6/20 19:08
 */
public class MD5Test {

    public static void main(String[] args) throws Exception {
        String str = "123";

//        System.out.println(test1(str));
//        System.out.println(test2(str));
        System.out.println(test3(str));

    }

    /**
     * 使用commons-lang3
     * @param str
     * @return
     * @throws Exception
     */
    private static String test3(String str) throws Exception {
        return null;
    }
    /**
     * 使用到了BigInteger
     * @param str
     * @return
     * @throws Exception
     */
    private static String test2(String str) throws Exception {
        // 生成一个MD5加密计算摘要
        MessageDigest md = MessageDigest.getInstance("MD5");

        // 计算md5函数
        md.update(str.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8位字符串。
        // 因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
        return new BigInteger(1, md.digest()).toString(16);
    }

    /**
     * 自定义byteArrayToHex方法
     * @param str
     * @return
     * @throws Exception
     */
    private static String test1(String str) throws Exception {
        String result = md5(str);
        return result;
    }

    private static String md5(String str) throws Exception {
        // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
        MessageDigest md = MessageDigest.getInstance("MD5");

        // 输入的字符串转换成字节数组
        byte[] byteArray = str.getBytes("UTF-8");

        md.update(byteArray);

        // 转换并返回结果，也是字节数组，包含16个元素
        byte[] resultByteArray = md.digest();
        System.out.println(resultByteArray.length);

        // 字符数组转换成字符串返回
        return byteArrayToHex(resultByteArray);
    }

    //下面这个函数用于将字节数组换成成16进制的字符串

    public static String byteArrayToHex(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };

        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray =new char[byteArray.length * 2];

        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;

        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }

        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }
}
