package com.vic.encrypt.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64测试
 * @author Victor
 * date: 2019/6/20 16:36
 */
public class Base64Test {

    public static void main(String[] args) throws Exception {
//        test1();
        test2();
//        test3();

        String header = "{\n" +
                "  \"alg\": \"HS256\",\n" +
                "  \"typ\": \"JWT\"\n" +
                "}";
//        byte[] bytes = Base64.encodeBase64URLSafe(header.getBytes());
//        System.out.println(new String(bytes));

//        System.out.println(new String(Base64.decodeBase64("ewogICJhbGciOiAiSFMyNTYiLAogICJ0eXAiOiAiSldUIgp9")));




    }

    /**
     * JDK 8的方式，首选！
     * @throws Exception
     */
    private static void test3() throws Exception {

        final java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        final java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
        //解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }

    /**
     * Apache commons codec方式
     * @throws Exception
     */
    private static void test2() throws Exception {
        Base64 base64 = new Base64();
        String text = "i am your dady";
        byte[] textByte = text.getBytes("UTF-8");

        //编码
        String encodedText = base64.encodeToString(textByte);
//        String encodedText = new String(Base64.encodeBase64(textByte));

        System.out.println(encodedText);

        //解码
//        String decodeText = new String(base64.decode(encodedText), "UTF-8");
        String decodeText = new String(Base64.decodeBase64(encodedText.getBytes()));
        System.out.println(decodeText);
    }

    /**
     * 使用sun.misc.BASE64Encoder，效率慢，不建议使用
     * @throws Exception
     */
    private static void test1() throws Exception {
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);
        //解码
        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
    }

}
