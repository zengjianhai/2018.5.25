package com.briup.http;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HttpTest {
	static int page = 1;
	static int x = 9, y = 8, z = 10;

	public static void main(String[] args) throws Exception {
		// HttpLink hl = new HttpLink();
		// URL url = new URL("http://jwc.ecjtu.jx.cn/mis_o/login.htm");
		// hl.IONet(url, "F:/hao.txt", CharseName.G);
		// System.out.println(hl.getSb());

		// DocumentDao dao = new DocumentDao();
		// dao.getValue("F:/java网络爬虫/hao.360.cn爬取得文件/hao.txt");
		// HttpGetStudent getStudent = new
		// HttpGetStudent("F:/java网络爬虫/华东交大数据/student_three.txt");
		// getStudent.getData();
		// HttpGetClassId id = new
		// HttpGetClassId("F:/java网络爬虫/华东交大数据/class_id.txt");
		// id.getData();
		// HttpGetStudentId studentId = new
		// HttpGetStudentId("F:/java网络爬虫/华东交大数据/student_id.txt");
		// studentId.getData();
		
		HttpTest test = new HttpTest();
		test.client();
	}

	public void test() throws Exception {
		String loginUrl = "http://jwc.ecjtu.jx.cn/mis_o/main.php";
		Connection con = Jsoup.connect(loginUrl).validateTLSCertificates(false).ignoreContentType(true)
				.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.header("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4")
				.header("Accept-Encoding", "gzip, deflate, sdch")
				.header("Referer", "http://jwc.ecjtu.jx.cn/mis_o/login.php").header("Upgrade-Insecure-Requests", "1")
				.header("Content-Type", "text/html").header("Connection", "keep-alive")
				.header("Cache-Control", "max-age=0")
				.header("Cookie", "_gscu_113121050=80150913moy4rj10; PHPSESSID=lluetb2f0rjasvqkrvas9ev5r4")
				.method(Method.GET).followRedirects(false);
		Response rs = con.execute();
		Document document = Jsoup.parse(rs.body());
		System.err.println(con.get() + "=========");
		List<Element> et = document.select("form");// 获取form表单，可以通过查看页面源码代码得知
		// 获取，cooking和表单属性，下面map存放post时的数据
		Map<String, String> datas = new HashMap<>();
		for (Element e : et.get(0).getAllElements()) {
			if (e.attr("name").equals("StuID")) {
				e.attr("value", "20142110011028");// 设置用户名
			}

			if (e.attr("name").equals("Name")) {
				e.attr("value", ""); // 设置用户密码
			}
			if (e.attr("name").equals("Course")) {
				e.attr("value", "");// 设置用户名
			}

			if (e.attr("name").equals("Term")) {
				e.attr("value", ""); // 设置用户密码
			}
			if (e.attr("name").equals("ClassID")) {
				e.attr("value", "");// 设置用户名
			}

			if (e.attr("name").length() > 0) {// 排除空值表单属性
				datas.put(e.attr("name"), e.attr("value"));
			}
		}
		Connection login = Jsoup.connect("http://jwc.ecjtu.jx.cn/mis_o/query.php?job=see&start=1")
				.validateTLSCertificates(false).ignoreContentType(true)
				.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.header("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4")
				.header("Accept-Encoding", "gzip, deflate").header("Referer", "http://jwc.ecjtu.jx.cn/mis_o/main.php")
				.header("Upgrade-Insecure-Requests", "1").header("Content-Type", "application/x-www-form-urlencoded")
				.header("Connection", "keep-alive").header("Cache-Control", "max-age=0")
				.header("Origin", "http://jwc.ecjtu.jx.cn").header("Host", "jwc.ecjtu.jx.cn")
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36")
				.header("Cookie", "_gscu_113121050=80150913moy4rj10; PHPSESSID=lluetb2f0rjasvqkrvas9ev5r4")
				.method(Method.POST).cookie("PHPSESSID", "lluetb2f0rjasvqkrvas9ev5r4")
				.cookie("_gscu_113121050", "80150913moy4rj10").data(datas);
		Response loginRes = login.execute();
		Document document2 = Jsoup.parse(loginRes.body(), "GBK");
		System.out.println(document2.html());
	}

	public void client() throws Exception {
		String url = "http://jwc.ecjtu.jx.cn/mis_o/query.php";
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		// 填入各个表单域的值,这里是华东交大成绩查询的表单域
		NameValuePair[] data1 = { new NameValuePair("StuID", "20142110011028"), new NameValuePair("Name", "") };
		postMethod.setRequestHeader("Accept-Encoding", "gzip, deflate");
		postMethod.setRequestHeader("Referer", "http://jwc.ecjtu.jx.cn/mis_o/main.php");
		postMethod.setRequestHeader("Connection", "keep-alive");
		postMethod.setRequestHeader("Cookie", "_gscu_113121050=80150913moy4rj10; PHPSESSID=lluetb2f0rjasvqkrvas9ev5r4");
		postMethod.setRequestHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data1);
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
		httpClient.executeMethod(postMethod);

		int statusCode = httpClient.executeMethod(postMethod);
		System.err.println(statusCode);
		//得到网页响应流
		InputStream is = postMethod.getResponseBodyAsStream();
		//解析gzip压缩流
		GZIPInputStream gzin = new GZIPInputStream(is);
		InputStreamReader isr = new InputStreamReader(gzin, "GBK"); // 设置读取流的编码格式，自定义编码
		//把isr流转换为string
		HttpData httpData = new HttpData();
		StringBuffer sb = httpData.getHtmlData("", isr);
		isr.close();
		gzin.close();
		Document document2 = Jsoup.parse(sb.toString());
		System.out.println(document2.html());
	}
}
