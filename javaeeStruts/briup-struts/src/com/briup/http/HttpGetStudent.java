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
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpGetStudent {
	static int page = 1;
	HttpClient httpClient;
	FileOutputStream fos;
	BufferedWriter bWriter;
	PrintWriter pw;
	FileInputStream fis;
	BufferedReader bReader;
	List<String> lists;
	HttpData httpData;

	public HttpGetStudent(String fileUrl) throws Exception {
		httpData = new HttpData();
		httpClient = new HttpClient();
		fos = new FileOutputStream(fileUrl);
		bWriter = new BufferedWriter(new OutputStreamWriter(fos, "GBK"));
		pw = new PrintWriter(bWriter);
	}

	public void getData() throws Exception {

		lists = new ArrayList<String>();
		fis = new FileInputStream("F:/java网络爬虫/华东交大数据/student_id_three.txt");
		bReader = new BufferedReader(new InputStreamReader(fis, "GBK"));
		String mString = null;
		while ((mString = bReader.readLine()) != null) {
			lists.add(mString.split(" ")[3]);
		}
		bReader.close();
		for (String string : lists) {
			for (int i = 0; i < page; i++) {
				init(i, string);
			}
		}
	}

	/**
	 * 
	 * HttpClient爬虫 把网页获取的gzip压缩网页解压成想要的格式
	 * 
	 * @throws Exception
	 */
	public void init(int count, String stuId) throws Exception {
		GetMethod method = new GetMethod(
				"http://jwc.ecjtu.jx.cn/mis_o/query.php?job=see&start=" + count + "&StuID=" + stuId);
		method.setRequestHeader("Accept-Encoding", "gzip, deflate");
		method.setRequestHeader("Referer", "http://jwc.ecjtu.jx.cn/mis_o/main.php");
		method.setRequestHeader("Connection", "keep-alive");
		method.setRequestHeader("Cookie", "_gscu_113121050=80150913moy4rj10; PHPSESSID=lluetb2f0rjasvqkrvas9ev5r4");
		method.setRequestHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
		try {
			/* 获得信息载体 */
			int state = httpClient.executeMethod(method);
			if (state == 200) {
				InputStream is = method.getResponseBodyAsStream();
				GZIPInputStream gzin = new GZIPInputStream(is);
				InputStreamReader isr = new InputStreamReader(gzin, "GBK"); // 设置读取流的编码格式，自定义编码
				// java.io.BufferedReader br = new java.io.BufferedReader(isr);
				// StringBuffer sb = new StringBuffer();
				// String tempbf;
				// while ((tempbf = br.readLine()) != null) {
				// sb.append(tempbf + "|");
				// sb.append("\r\n");
				// }
				StringBuffer sb = httpData.getHtmlData("", isr);
				isr.close();
				gzin.close();
				Document document2 = Jsoup.parse(sb.toString());
				// 得到页面数
				if (count == 0) {
					Elements font = document2.getElementsByTag("font");
					page = Integer.valueOf(font.get(2).text());
					if (page == 0)
						page = 1;
				}
				Elements tables = document2.select("table[border$=1]");
				for (Element table : tables) {
					Elements tbodys = table.select("tbody");
					for (Element tbody : tbodys) {
						Elements trs = tbody.select("tr");
						for (Element tr : trs) {
							// System.err.println(tr.text());
							ioStream(tr.text());
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

	public void ioStream(String data) throws Exception {
		pw.println(data);
		bWriter.flush();
		pw.flush();
	}
}
