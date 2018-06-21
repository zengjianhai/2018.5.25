package com.briup.webservice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 本地服务器，通过浏览器接收数据
 * @author xunfeng
 *
 */
public class WebService {

	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket server = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream out = null;
		BufferedOutputStream bos = null;
		try {
			server = new ServerSocket(8989);
			System.out.println("等待连接");
			socket = server.accept();
			System.out.println("连接成功");
			fis = new FileInputStream(new File("src/b.png"));
			bis = new BufferedInputStream(fis);
			out = socket.getOutputStream();
			bos = new BufferedOutputStream(out);
			byte[] bs = new byte[1024];
			int value = 0;
			while ((value = bis.read(bs))!=-1) {
				bos.write(bs, 0, value);
			}
			bos.flush();
			bos.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
