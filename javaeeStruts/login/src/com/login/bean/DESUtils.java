package com.login.bean;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class DESUtils {
	//加密的密钥
	private static Key key;
	private static String KEY = "miner";
	static {
		try {
			//密钥生成器
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			//初始化
			generator.init(new SecureRandom(KEY.getBytes()));
			//生成密钥
			key = generator.generateKey();
			generator = null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String getEncrypt(String target) {
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			byte[] bs= target.getBytes("utf-8");
			//指定的加密算法
			Cipher cipher = Cipher.getInstance("DES");
			//加密形式
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encrypts = cipher.doFinal(bs);
			return encoder.encode(encrypts);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getDecrypt(String target){
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] bs= decoder.decodeBuffer(target);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decrypts = cipher.doFinal(bs);
			return new String(decrypts, "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
