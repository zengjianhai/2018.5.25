package com.briup.http;

import java.net.URL;

public interface IHttpLink {
	/**
	 * 进行网络数据流的读入和存入文件
	 * charsetName 编码格式
	 * @param url 网络地址
	 * @param fileUrl 要存入的文件路径
	 * @throws Exception
	 */
	public void IONet(URL url, String fileUrl, CharseName charsetName) throws Exception;
}
