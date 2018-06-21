package com.creeper.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test {
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();

		// 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
		PostMethod postMethod = new PostMethod("https://login.51job.com/login.php?lang=c&url=big5.51job.com");
		postMethod.setRequestHeader("Referer", "http://i.51job.com/userset/my_51job.php");
		postMethod.setRequestHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
		postMethod.setRequestHeader("Cookie", "guid=14992367431329980087;");
		NameValuePair[] data = {new NameValuePair("loginname", "15079594318"),
				new NameValuePair("password", "2014zengxun")};
        postMethod.setRequestBody(data);
		httpClient.executeMethod(postMethod);
		
		String html = postMethod.getResponseBodyAsString();
		System.out.println(new String(html.getBytes("iso8859-1"),"gbk")); 
	}
}
