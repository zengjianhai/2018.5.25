package com.creeper.baidu;

import java.net.URLConnection;

public interface ConnImpl {
	/**
	 * 获取网络连接
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public URLConnection getConn(String url) throws Exception ;
}
