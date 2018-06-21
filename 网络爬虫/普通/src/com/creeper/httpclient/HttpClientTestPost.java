package com.creeper.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientTestPost {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://jwc.ecjtu.jx.cn/mis_o/query.php";

		// 1.使用默认的配置的httpclient
		CloseableHttpClient client = HttpClients.createDefault();

		// 2.使用post方法
		HttpPost httpPost = new HttpPost(url);

		
		// 设置form表单的值
		List<NameValuePair> form = new ArrayList<NameValuePair>();
		// 添加一个值
		form.add(new BasicNameValuePair("StuID", "20142110011028"));
		// 把表单转换成entity
		UrlEncodedFormEntity enti = new UrlEncodedFormEntity(form, "UTF-8");
		// 设置登录的数据
		httpPost.setEntity(enti);

		// 设置cookie值
		httpPost.setHeader("Cookie", "PHPSESSID=phi41gnvet1luaeu56acorjk70");
		InputStream inputStream = null;
		CloseableHttpResponse response = null;

		try {
			// 3.执行请求，获取响应
			response = client.execute(httpPost);

			// 看请求是否成功，这儿打印的是http状态码
			System.out.println(response.getStatusLine().getStatusCode());
			// 4.获取响应的实体内容，就是我们所要抓取得网页内容
			HttpEntity entity = response.getEntity();

			// 5.将其打印到控制台上面
			// 方法一：使用EntityUtils
			/*
			 * if (entity != null) {
			 * System.out.println(EntityUtils.toString(entity, "gbk")); }
			 * EntityUtils.consume(entity);
			 */
			// 方法二 :使用inputStream

			if (entity != null) {
				inputStream = entity.getContent();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			}

		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
