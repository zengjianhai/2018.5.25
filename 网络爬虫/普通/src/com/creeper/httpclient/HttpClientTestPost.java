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

		// 1.ʹ��Ĭ�ϵ����õ�httpclient
		CloseableHttpClient client = HttpClients.createDefault();

		// 2.ʹ��post����
		HttpPost httpPost = new HttpPost(url);

		
		// ����form����ֵ
		List<NameValuePair> form = new ArrayList<NameValuePair>();
		// ���һ��ֵ
		form.add(new BasicNameValuePair("StuID", "20142110011028"));
		// �ѱ�ת����entity
		UrlEncodedFormEntity enti = new UrlEncodedFormEntity(form, "UTF-8");
		// ���õ�¼������
		httpPost.setEntity(enti);

		// ����cookieֵ
		httpPost.setHeader("Cookie", "PHPSESSID=phi41gnvet1luaeu56acorjk70");
		InputStream inputStream = null;
		CloseableHttpResponse response = null;

		try {
			// 3.ִ�����󣬻�ȡ��Ӧ
			response = client.execute(httpPost);

			// �������Ƿ�ɹ��������ӡ����http״̬��
			System.out.println(response.getStatusLine().getStatusCode());
			// 4.��ȡ��Ӧ��ʵ�����ݣ�����������Ҫץȡ����ҳ����
			HttpEntity entity = response.getEntity();

			// 5.�����ӡ������̨����
			// ����һ��ʹ��EntityUtils
			/*
			 * if (entity != null) {
			 * System.out.println(EntityUtils.toString(entity, "gbk")); }
			 * EntityUtils.consume(entity);
			 */
			// ������ :ʹ��inputStream

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
