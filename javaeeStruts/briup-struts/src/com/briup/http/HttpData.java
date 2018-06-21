package com.briup.http;

import java.io.InputStreamReader;

public class HttpData implements IHttpData{

	//得到字符串
	@Override
	public StringBuffer getHtmlData(String str,InputStreamReader isr) throws Exception {
		java.io.BufferedReader br = new java.io.BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		String tempbf;
		while ((tempbf = br.readLine()) != null) {
			sb.append(tempbf+str);
			sb.append("\r\n");
		}
		return sb;
	}

}
