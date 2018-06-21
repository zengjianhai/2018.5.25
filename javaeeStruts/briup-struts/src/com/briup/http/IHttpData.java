package com.briup.http;

import java.io.InputStreamReader;

public interface IHttpData {
	/**
	 * 输入一个InputStreamReader流，把网页传递来的流转换为stringBuffer
	 * @param str
	 * @param isr
	 * @return
	 * @throws Exception
	 */
	public StringBuffer getHtmlData(String str,InputStreamReader isr) throws Exception;
}
