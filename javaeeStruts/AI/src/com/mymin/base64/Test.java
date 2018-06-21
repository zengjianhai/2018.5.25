package com.mymin.base64;

import java.io.IOException;

public class Test {
	public static final String DATA = "star";

	public static void main(String[] args) throws IOException{
		String base64Result = Base64.encryBase64(DATA.getBytes());
		System.out.println(DATA+" >>>base64¼ÓÃÜ>>> "+base64Result);
		String base64String = Base64.decryBase64(base64Result);
		System.out.println(base64Result+" >>>base64½âÂë>>> "+base64String);
	}
}
