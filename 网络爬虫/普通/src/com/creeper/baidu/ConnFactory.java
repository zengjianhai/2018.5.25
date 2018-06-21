package com.creeper.baidu;

import java.net.URL;
import java.net.URLConnection;

public class ConnFactory implements ConnImpl {
	@Override
	public URLConnection getConn(String url) throws Exception {
		//����url
		URL realUrl = new URL(url);
		//��һ���������ӣ�url.openConnection()����һ��URLConnection
		URLConnection connection = realUrl.openConnection();
		//����
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
