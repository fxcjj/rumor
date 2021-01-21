package com.vic.encrypt.rsa;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
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
public class RSAUtils {

    public static void main(String[] args) {
        //1. 生成公钥和私钥
        Map<String, String> keyMap = makeKeyPair();

        //2. 公钥加密、私钥解密
        // 加密字符串
        String message = "我是你爸爸";

        String publicKey = keyMap.get(PUBLIC_KEY);
        String privateKey = keyMap.get(PRIVATE_KEY);

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

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;


    /**
     * 构造公钥
     * @param publicKey
     * @return
     */
    public static PublicKey buildPublicKey(String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            byte[] encodedKey = Base64.decodeBase64(publicKey);
            return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 构造私钥
     * @param privateKey
     * @return
     */
    public static PrivateKey buildPrivateKey(String privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            byte[] encodedKey = Base64.decodeBase64(privateKey);
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 随机生成密钥对
     */
    public static Map<String, String> makeKeyPair() {
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
            Map<String, String> keyPairMap = new HashMap<>();
            keyPairMap.put(PUBLIC_KEY, publicKeyString); // 公钥
            keyPairMap.put(PRIVATE_KEY, privateKeyString); // 私钥
            return keyPairMap;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     * @param str 要加密的字符串
     * @param publicKey 编码后的公钥
     * @return
     */
    public static String encrypt(String str, String publicKey) {
        try {
            PublicKey pubKey = buildPublicKey(publicKey);
            // RSA加密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);

            byte[] data = str.getBytes(DEFAULT_CHARSET);
            int inputLength = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            while (inputLength - offset > 0) {
                if (inputLength - offset > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offset, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offset, inputLength - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return Base64.encodeBase64String(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解密
     * @param encryptStr 加密字符串
     * @param privateKey 编码后的私钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptStr, String privateKey) {
        try {
            // 解码加密后的字符串
            byte[] data = Base64.decodeBase64(encryptStr.getBytes(DEFAULT_CHARSET));
            PrivateKey priKey = buildPrivateKey(privateKey);
            //RSA解密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            int inputLength = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            byte[] tmp;
            while (inputLength - offset > 0) {
                if (inputLength - offset > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offset, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offset, inputLength - offset);
                }
//            out.write(cache, 0, cache.length);
                out.write(cache);
                i++;
                offset = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            String outStr = new String(decryptedData);
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
            PrivateKey priKey = buildPrivateKey(privateKey);
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
            PublicKey pubKey = buildPublicKey(publicKey);

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
