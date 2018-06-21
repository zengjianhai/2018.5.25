package com.creeper.baidu;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLConnection;

public class Factory {
	public static String getReaderHtml(String url, String charsetName, ConnFactory connFactory) {
		String result = "";
		BufferedReader in = null;
		try {
			URLConnection connection = ConnFactory.connection(url, connFactory);
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charsetName));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void saveToFile(String url, String charsetName, String fileUrl, ConnFactory connFactory) {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			URLConnection connection = ConnFactory.connection(url, connFactory);
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charsetName));
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileUrl), charsetName));
			String line;
			while ((line = in.readLine()) != null) {
				out.write(line);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
