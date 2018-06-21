package com.creeper.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientTestGet {
	public static void main(String[] args) {
		String url = "http://jwc.ecjtu.jx.cn/mis_o/main.php";

		// 1.使用默认的配置的httpclient
		CloseableHttpClient client = HttpClients.createDefault();
		// 2.使用get方法
		HttpGet httpGet = new HttpGet(url);
		
		//addHeader和setHeader都行
		//增加请求头，伪装访问客户端，加快访问速度
		httpGet.addHeader("Accept", "text/html"); 
		httpGet.addHeader("Accept-Language", "en-US,en");  
		httpGet.addHeader("Cookie", "PHPSESSID=phi41gnvet1luaeu56acorjk70");
		
		
		InputStream inputStream = null;
		CloseableHttpResponse response = null;

		try {
			// 3.执行请求，获取响应
			response = client.execute(httpGet);
			//获取头部信息
			/*HeaderIterator iter = response.headerIterator();
			while (iter.hasNext()) {
				Header header = iter.nextHeader();
				System.out.println(header.getName() + " : "
						+ header.getValue());
			}*/
			// 看请求是否成功，这儿打印的是http状态码
			System.out.println(response.getStatusLine().getStatusCode());
			// 4.获取响应的实体内容，就是我们所要抓取得网页内容
			HttpEntity entity = response.getEntity();
			// 5.将其打印到控制台上面
			// 方法一：使用EntityUtils
			/*if (entity != null) {
				System.out.println(EntityUtils.toString(entity, "gbk"));
			}
			EntityUtils.consume(entity);
			 */
			// 方法二 :使用inputStream

			if (entity != null) {
				inputStream = entity.getContent();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			}

		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
