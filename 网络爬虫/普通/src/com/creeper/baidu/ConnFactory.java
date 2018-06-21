package com.creeper.baidu;

import java.net.URL;
import java.net.URLConnection;

public class ConnFactory implements ConnImpl {
	@Override
	public URLConnection getConn(String url) throws Exception {
		//创建url
		URL realUrl = new URL(url);
		//打开一个网络连接，url.openConnection()返回一个URLConnection
		URLConnection connection = realUrl.openConnection();
		//连接
		connection.connect();
		return connection;
	}

	public static URLConnection connection(String url,ConnFactory connFactory) throws Exception {
		if (connFactory == null) {
			connFactory = new ConnFactory();
		}
		return connFactory.getConn(url);
	}
}
