package com.vic.encrypt.rsa;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA
 * 1. 公钥加密、私钥解密
 * 2. 私钥签名、公钥验签
 *
 * https://blog.csdn.net/qy20115549/article/details/83105736
 * https://blog.csdn.net/a1017680279/article/details/79061412
 * https://blog.csdn.net/kzcming/article/details/80109943
 * @author Victor
 * date: 2019/6/26 19:07
 */
public class RSAEncrypt {

    /**
     * 默认字符集
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 密钥长度
     */
    public static final int KEY_LENGTH = 1024;

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "MD5WithRSA";

    /**
     * 获取公钥的key
     */
    public static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的key
     */
    public static final String PRIVATE_KEY = "RSAPrivateKey";

    private static Map<Integer, String> keyMap = new HashMap<>();

    public static void main(String[] args) {
        //1. 生成公钥和私钥
        genKeyPair();

        //2. 公钥加密、私钥解密
        // 加密字符串
        String message = "我是你爸爸";

        String publicKey = keyMap.get(0);
        String privateKey = keyMap.get(1);

        System.out.println("随机生成的公钥为: " + publicKey);
        System.out.println("随机生成的私钥为: " + privateKey);
        String encryptStr = encrypt(message, publicKey);
        System.out.println(message + "\t加密后的字符串为: " + encryptStr);

        String decryptStr = decrypt(encryptStr, privateKey);
        System.out.println("还原后的字符串为: " + decryptStr);

        //3. 私钥签名、公钥验签
        String sign = sign(message, privateKey);
        System.out.println("生成的签名: " + sign);

        boolean verify = verify(message, sign, publicKey);
        System.out.println("验签结果: " + verify);

    }

    /**
     * 随机生成密钥对
     */
    public static void genKeyPair() {
        try {
            // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);

            // 初始化密钥对生成器，密钥大小为96-1024位
            keyPairGenerator.initialize(KEY_LENGTH, new SecureRandom());

            // 生成一个密钥对，保存在keyPair对象中
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // 得到私钥
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            // 得到私钥
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            // 将私钥base64编码
            String privateKeyString = new String(Base64.encodeBase64(privateKey.getEncoded()));

            // 将公钥base64编码
            String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));

            // 将公钥和私钥保存到map
            keyMap.put(0, publicKeyString); //0表示公钥
            keyMap.put(1, privateKeyString); //0表示私钥
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密
     * @param str 要加密的字符串
     * @param publicKey 编码后的公钥
     * @return
     */
    public static String encrypt(String str, String publicKey) {
        try {
            // 将publicKey base64解码
            byte[] decoded = Base64.decodeBase64(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
            // RSA加密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解密
     *
     * @param encryptStr 加密字符串
     * @param privateKey 编码后的私钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptStr, String privateKey) {
        try {
            // 解码加密后的字符串
            byte[] inputByte = Base64.decodeBase64(encryptStr.getBytes(DEFAULT_CHARSET));
            // 解码加密后的私钥
            byte[] decoded = Base64.decodeBase64(privateKey);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            String outStr = new String(cipher.doFinal(inputByte));
            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 生成签名
     * @param str 需要生成签名的字符串
     * @param privateKey 私钥
     * @return
     */
    public static String sign(String str, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey priKey = keyFactory.generatePrivate(priPKCS8);

            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(str.getBytes(DEFAULT_CHARSET));

            byte[] signed = signature.sign();
            return Base64.encodeBase64String(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验证签名
     * @param str 需要验证的字符串
     * @param sign 签名
     * @param publicKey 公钥
     * @return
     */
    public static boolean verify(String str, String sign, String publicKey) {
        try {
            //str不能明文，要base64加密传输
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            byte[] encodedKey = Base64.decodeBase64(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(str.getBytes(DEFAULT_CHARSET));
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
