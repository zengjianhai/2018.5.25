package com.briup.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpGetStudentId {
	HttpClient httpClient;
	List<String> lists;
	FileOutputStream fos;
	BufferedWriter bWriter;
	PrintWriter pw;
	HttpData httpData;
	public HttpGetStudentId(String fileUrl) throws Exception {
		httpData = new HttpData();
		httpClient = new HttpClient();
		fos = new FileOutputStream(fileUrl);
		bWriter = new BufferedWriter(new OutputStreamWriter(fos, "GBK"));
		pw = new PrintWriter(bWriter);
	}

	public void getData() throws Exception {
		lists = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("F:/java网络爬虫/华东交大数据/class_id.txt");
		BufferedReader bReader = new BufferedReader(new InputStreamReader(fis, "GBK"));
		String mString = null;
		while ((mString = bReader.readLine()) != null) {
			lists.add(mString.split("\\|")[4]);
			// System.out.println(mString.split("\\|")[4]);
		}
		bReader.close();
		for (String string : lists) {
			getStudentId(string);
		}
	}

	public void getStudentId(String classId) throws Exception {
		GetMethod method = new GetMethod("http://jwc.ecjtu.jx.cn:8080/jwcmis/stuquery.jsp?banji=" + classId);
		method.setRequestHeader("Accept-Encoding", "gzip, deflate, sdch");
		method.setRequestHeader("Referer", "http://jwc.ecjtu.jx.cn:8080/jwcmis/stuquery.jsp?");
		method.setRequestHeader("Connection", "keep-alive");
		method.setRequestHeader("Cookie",
				"JSESSIONID=6BC3ECFE6568AB0F8A7EB40C59E795DA; _gscu_113121050=80150913moy4rj10; PHPSESSID=vo10ruporkicdf8plpgrscs8l7");
		method.setRequestHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
		try {
			/* 获得信息载体 */
			int state = httpClient.executeMethod(method);
			if (state == 200) {
				InputStream is = method.getResponseBodyAsStream();
				InputStreamReader isr = new InputStreamReader(is, "GBK"); // 设置读取流的编码格式，自定义编码
//				java.io.BufferedReader br = new java.io.BufferedReader(isr);
//				StringBuffer sb = new StringBuffer();
//				String tempbf;
//				while ((tempbf = br.readLine()) != null) {
//					sb.append(tempbf);
//					sb.append("\r\n");
//				}
				StringBuffer sb = httpData.getHtmlData("", isr);
				isr.close();
				Document ecjtu = Jsoup.parse(sb.toString());
				System.out.println(ecjtu.html());
				Elements tbodys = ecjtu.select("tbody");
				for (Element trs : tbodys) {
					Elements tr = trs.select("tr");
					for (Element td : tr) {
						if(td.select("td[height$=16]").text().equals("")){}else{
						System.out.println(td.select("td[height$=16]").text());
						ioStream(td.select("td[height$=16]").text());}
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
	}
	public void ioStream(String data) throws Exception {
		pw.println(data);
		bWriter.flush();
		pw.flush();
	}
}
