package com.briup.http;

/**
 * 规定编码格式
 * 
 * @author xunfeng
 *
 */
public enum CharseName {
	U("utf-8"), G("GBK"), I("ISO-8859-1"), V(1);
	private String charseName;
	private int value = 0;

	public int getValue() {
		return value;
	}

	public String getCharseName() {
		return charseName;
	}

	private CharseName(String charseName) {
		this.charseName = charseName;
	}

	private CharseName(int value) {
		this.value = value;
	}
}
