package com.mymin.base64;

import java.io.IOException;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class Base64 {
	public static String encryBase64(byte[] data) {
		return new BASE64Encoder().encode(data);
	}
	public static String decryBase64(String data) throws IOException{
		byte[] bs = new BASE64Decoder().decodeBuffer(data);
		return new String(bs);
	}
}
