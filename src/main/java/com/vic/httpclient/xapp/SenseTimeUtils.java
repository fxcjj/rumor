package com.vic.httpclient.xapp;

import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;

/**
 * 商汤科技-接口签名
 * @author Luyuan
 *
 */
public class SenseTimeUtils {
	
	private static final String HASH_ALGORITHM = "HmacSHA256";
	
    static String timestamp = Long.toString(System.currentTimeMillis());
    
    static String nonce = RandomStringUtils.randomAlphanumeric(16);

	public static String getAuthorization(String api_key, String api_secret) throws SignatureException{

        String genOriString = genOriString(api_key);
        String encryptedString = genEncryptString(genOriString, api_secret);

        String HeaderParam = "key=" + api_key 
                     +",timestamp=" + timestamp 
                     +",nonce=" + nonce 
                     +",signature=" + encryptedString;
        return HeaderParam;
    }
	
	private static String genOriString(String api_key){

        ArrayList<String> beforesort = new ArrayList<String>();
        beforesort.add(api_key);
        beforesort.add(timestamp);
        beforesort.add(nonce);

        Collections.sort(beforesort, new Comparator<Object>() {
        	public int compare(Object o1, Object o2) {  
                try{  
                    String s1 = new String(o1.toString().getBytes("GB2312"), "ISO-8859-1");  
                    String s2 = new String(o2.toString().getBytes("GB2312"), "ISO-8859-1");   
                    return s1.compareTo(s2);  
                 }catch (Exception e){
                     e.printStackTrace();  
                 }  
                 return 0;  
            } 
		});  
        
        StringBuffer aftersort = new StringBuffer();
        for (int i = 0; i < beforesort.size(); i++) {  
            aftersort.append(beforesort.get(i));
        }  

        String OriString = aftersort.toString();
        return OriString;
    }

    private static String genEncryptString(String genOriString, String api_secret)throws SignatureException {
        try{
            Key sk = new SecretKeySpec(api_secret.getBytes(), HASH_ALGORITHM);
            Mac mac = Mac.getInstance(sk.getAlgorithm());
            mac.init(sk);
            final byte[] hmac = mac.doFinal(genOriString.getBytes());
            StringBuilder sb = new StringBuilder(hmac.length * 2);  

                @SuppressWarnings("resource")
                Formatter formatter = new Formatter(sb);  
                for (byte b : hmac) {  
                    formatter.format("%02x", b);  
                }  
            String EncryptedString = sb.toString();
            return EncryptedString;
        }catch (NoSuchAlgorithmException e1){
            throw new SignatureException("error building signature, no such algorithm in device "+ HASH_ALGORITHM);
        }catch (InvalidKeyException e){
            throw new SignatureException("error building signature, invalid key " + HASH_ALGORITHM);
        }
    }
}
