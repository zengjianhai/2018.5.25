package com.briup.http;

import java.io.BufferedWriter;
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

public class HttpGetClassId {
	HttpClient httpClient;
	static List<EcjtuClassId> lists;
	static List<EcjtuClassId> datas;
	boolean first = true;
	FileOutputStream fos;
	BufferedWriter bWriter;
	PrintWriter pw;
	HttpData httpData;
	public HttpGetClassId(String fileUrl) throws Exception {
		httpData = new HttpData();
		httpClient = new HttpClient();
		lists = new ArrayList<EcjtuClassId>();
		datas = new ArrayList<EcjtuClassId>();
		fos = new FileOutputStream(fileUrl);
		bWriter = new BufferedWriter(new OutputStreamWriter(fos, "GBK"));
		pw = new PrintWriter(bWriter);
	}

	public void getData() throws Exception {
		getClassId(null, "2014");
		for (EcjtuClassId ecjtuClassId : lists) {
			for (int i = 2012; i <= 2016; i++) {
				getClassId(ecjtuClassId, String.valueOf(i));
			}
		}
		for (EcjtuClassId ecjtuClassId2 : datas) {
			System.out.println(ecjtuClassId2);
			ioStream(ecjtuClassId2);
		}
	}

	public void getClassId(EcjtuClassId key, String year) throws Exception {
		String url = null;
		if (key == null) {
			System.err.println("===================");
			url = "http://jwc.ecjtu.jx.cn:8080/jwcmis/stuquery.jsp";
		} else {
			url = "http://jwc.ecjtu.jx.cn:8080/jwcmis/stuquery.jsp?depart=" + key.getSoftWareId() + "&nianji=" + year;
		}
		GetMethod method = new GetMethod(url);
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
//				System.out.println(ecjtu.html());
				if (first) {
					Elements selects = ecjtu.select("select[name$=depart]");
					for (Element select : selects) {
						Elements departs = select.select("option");
						for (Element depart : departs) {
							lists.add(new EcjtuClassId(depart.attr("value"), depart.ownText()));
							System.out.println(depart.attr("value") + ":" + depart.ownText());
						}
					}
					first = false;
				}
				Elements classes = ecjtu.select("select[name$=banji]");
				for (Element cl : classes) {
					Elements clIds = cl.select("option");
					for (Element clId : clIds) {
						if (!"0".equals(clId.attr("value").substring(0, 1))) {
							if (key != null) {
								datas.add(new EcjtuClassId(key.getSoftWareId(), key.getSoftWare(), year,
										clId.ownText(), clId.attr("value")));
							}
							System.out.println(clId.attr("value") + ":" + clId.ownText());
						}
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
	}
	public void ioStream(EcjtuClassId data) throws Exception{
		pw.println(data);
		bWriter.flush();
		pw.flush();
	}
}
