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

		// 1.ʹ��Ĭ�ϵ����õ�httpclient
		CloseableHttpClient client = HttpClients.createDefault();
		// 2.ʹ��get����
		HttpGet httpGet = new HttpGet(url);
		
		//addHeader��setHeader����
		//��������ͷ��αװ���ʿͻ��ˣ��ӿ�����ٶ�
		httpGet.addHeader("Accept", "text/html"); 
		httpGet.addHeader("Accept-Language", "en-US,en");  
		httpGet.addHeader("Cookie", "PHPSESSID=phi41gnvet1luaeu56acorjk70");
		
		
		InputStream inputStream = null;
		CloseableHttpResponse response = null;

		try {
			// 3.ִ�����󣬻�ȡ��Ӧ
			response = client.execute(httpGet);
			//��ȡͷ����Ϣ
			/*HeaderIterator iter = response.headerIterator();
			while (iter.hasNext()) {
				Header header = iter.nextHeader();
				System.out.println(header.getName() + " : "
						+ header.getValue());
			}*/
			// �������Ƿ�ɹ��������ӡ����http״̬��
			System.out.println(response.getStatusLine().getStatusCode());
			// 4.��ȡ��Ӧ��ʵ�����ݣ�����������Ҫץȡ����ҳ����
			HttpEntity entity = response.getEntity();
			// 5.�����ӡ������̨����
			// ����һ��ʹ��EntityUtils
			/*if (entity != null) {
				System.out.println(EntityUtils.toString(entity, "gbk"));
			}
			EntityUtils.consume(entity);
			 */
			// ������ :ʹ��inputStream

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
