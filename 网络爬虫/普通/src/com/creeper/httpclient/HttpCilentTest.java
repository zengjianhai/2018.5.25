package com.creeper.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpCilentTest {
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient httpClient=new HttpClient();
		//����һ��Get����������
		GetMethod getMethod=new GetMethod("http://jwc.ecjtu.jx.cn/mis_o/query.php");
		getMethod.setRequestHeader("Cookie", "_gscu_113121050=80150913moy4rj10; PHPSESSID=phi41gnvet1luaeu56acorjk70");
        NameValuePair[] data = {new NameValuePair("StuID", "20142110011028") };
		getMethod.setQueryString(data);
		//ִ������
		httpClient.executeMethod(getMethod);
		//������ҳ��Ϣ
		String html=getMethod.getResponseBodyAsString();
//		InputStream is = getMethod.getResponseBodyAsStream();
//		byte[] bs=new byte[1024];
//		int len=0;
//		while((len = is.read(bs))!=-1){
//			System.out.println(new String(bs));
//		}
		//ת��
		html=new String(html.getBytes("iso8859-1"),"gbk");
		System.out.println(html);
	}
}
