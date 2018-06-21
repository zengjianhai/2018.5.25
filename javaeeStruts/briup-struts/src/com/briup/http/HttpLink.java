package com.briup.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

/**
 * java网络爬取html，以字符形式存入文件中
 * 
 * @author xunfeng
 *
 */
public class HttpLink implements IHttpLink {
	private StringBuilder sb;

	public HttpLink() {
		sb = new StringBuilder();
	}

	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	/**
	 * CharseName规定输入输出的编码格式
	 */
	@Override
	public void IONet(URL url, String fileUrl, CharseName charsetName) throws Exception {
		BufferedReader bReader = new BufferedReader(
				new InputStreamReader(url.openStream(), charsetName.getCharseName()));
		FileOutputStream fos = new FileOutputStream(fileUrl);
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(fos, charsetName.getCharseName()));
		PrintWriter pw = new PrintWriter(bWriter);
		String mString = null;
		while ((mString = bReader.readLine()) != null) {
			sb.append(mString + "\n");
			pw.println(mString);
		}
		bWriter.flush();
		pw.flush();
		if (bReader != null)
			bReader.close();
		if (bWriter != null)
			bWriter.close();
	}
}
