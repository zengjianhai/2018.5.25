package com.creeper.baidu;

import java.net.URLConnection;

public interface ConnImpl {
	/**
	 * ��ȡ��������
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public URLConnection getConn(String url) throws Exception ;
}
