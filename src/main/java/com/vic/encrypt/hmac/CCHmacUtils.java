package com.vic.encrypt.hmac;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.nio.charset.Charset;

/**
 * hmac加密
 * 使用apache commons codec
 * @author Victor
 *
 * https://www.jianshu.com/p/18d65e43d1f5
 *
 * date: 2019/6/21 16:52
 */
public class CCHmacUtils {

    // 获取 HmacMD5 Key
    public static byte[] getHmacMd5Key() {
        return getHmacKey("HmacMD5");
    }

    // 获取 HmacSHA256
    public static byte[] getHmacSha256Key() {
        return getHmacKey("HmacSHA256");
    }

    // 获取 HmacSHA512
    public static byte[] getHmacSha512Key() {
        return getHmacKey("HmacSHA512");
    }

    // 获取 HMAC Key
    public static byte[] getHmacKey(String type) {
        try {
            // 1、创建密钥生成器
            KeyGenerator keyGenerator = KeyGenerator.getInstance(type);
            // 2、产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 3、获取密钥
            byte[] key = secretKey.getEncoded();
            return key;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // HMAC MD5 加密
    public static String encryptHmacMD5(byte[] data, byte[] key) {
        Mac mac = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_MD5, key);
        return Hex.encodeHexString(mac.doFinal(data));
    }

    // HMAC SHA256 加密
    public static String encryptHmacSHA256(byte[] data, byte[] key) {
        Mac mac = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, key);
        return Hex.encodeHexString(mac.doFinal(data));
    }

    // HMAC SHA521 加密
    public static String encryptHmacSHA512(byte[] data, byte[] key) {
        Mac mac = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_512, key);
        return Hex.encodeHexString(mac.doFinal(data));
    }

    public static void main(String[] args) {
        byte[] data = "我的天呐".getBytes(Charset.forName("UTF-8"));
        // MD5
        byte[] hmacMd5KeyBytes = getHmacMd5Key();
        String hexHmacMd5Key = Hex.encodeHexString(hmacMd5KeyBytes);
        System.out.println("HMAC Md5 密钥:" + hexHmacMd5Key);
        String hmacMd5Encrypt = encryptHmacMD5(data, hmacMd5KeyBytes);
        System.out.println("HMAC Md5 加密:" + hmacMd5Encrypt);
        // SHA256
        byte[] hmacSha256KeyBytes = getHmacSha256Key();
        String hexHmacSha256Key = Hex.encodeHexString(hmacSha256KeyBytes);
        System.out.println("HMAC SHA256 密钥:" + hexHmacSha256Key);
        String hmacSha256Encrypt = encryptHmacSHA256(data, hmacSha256KeyBytes);
        System.out.println("HMAC SHA256 加密:" + hmacSha256Encrypt);
        // SHA512
        byte[] hmacSha512KeyBytes = getHmacSha512Key();
        String hexHmacSha512Key = Hex.encodeHexString(hmacSha512KeyBytes);
        System.out.println("HMAC SHA512 密钥:" + hexHmacSha512Key);
        String hmacSha512Encrypt = encryptHmacSHA512(data, hmacSha512KeyBytes);
        System.out.println("HMAC SHA512 加密:" + hmacSha512Encrypt);
    }
}