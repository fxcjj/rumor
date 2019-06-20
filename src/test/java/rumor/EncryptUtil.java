package rumor;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {
	public static void main(String[] args) {
//		System.out.println(EncryptCreateUtil.encrypt("13585881126")); //AL0e5DNLiBFuKiBkMlvi5w==
//		System.out.println(EncryptCreateUtil.encrypt("13585881126")); //AL0e5DNLiBFuKiBkMlvi5w==
//		System.out.println(EncryptCreateUtil.encrypt("15618698970")); //AL0e5DNLiBFuKiBkMlvi5w==
		System.out.println(EncryptCreateUtil.dencrypt("Lt5o4bSzeUXefAl647kE+A==")); //sgjsnJaXFmXE3N3nQ2seEA==
		
		
	}
}


class EncryptCreateUtil {

	//加密算法类型
	public String encryptType; 
		
	//AES加解密的秘钥
	public static String aesKey;
	
	public String getEncryptType() {
		return encryptType;
	}

	public void setEncryptType(String encryptType) {
		this.encryptType = encryptType;
	}
	
	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	static {
		EncryptCreateUtil en = new EncryptCreateUtil();
		en.setAesKey("zJJ$c5md3$yuuhWW");
		en.setEncryptType("AES");
	}
	/**
	 * 加密
	 * @param input 明文
	 * @param key 秘钥
	 * @return
	 */
	public static String encrypt(String input) {
		if(null == input){
			return null;
		}
		
		byte[] crypted = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(aesKey.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(input.getBytes());
			
			return new String(Base64.encodeBase64(crypted));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 解密
	 * @param input 密文
	 * @param key 秘钥
	 * @return
	 */
	public static String dencrypt(String input) {
		if(null == input){
			return null;
		}
					
		byte[] crypted = null;
		try {
			byte[] inputArray = input.getBytes();
			byte[] aesArray = Base64.decodeBase64(inputArray);
			
			SecretKeySpec skey = new SecretKeySpec(aesKey.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			crypted = cipher.doFinal(aesArray);
			
			return new String(crypted);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	
}