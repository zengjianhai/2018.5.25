package com.briup.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/*
 * asyncSupported表示是否支持异步
 * */
@WebServlet(urlPatterns={"/second.do"},asyncSupported=true,
		initParams={@WebInitParam(name="name",value="my bride is miner")}
		)
public class SecondServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/png");
		OutputStream out = resp.getOutputStream();
		InputStream is = this.getClass().getResourceAsStream("b.png");
		byte[] bs = new byte[1024];
		int len = is.read(bs);
		while (len!=-1) {
			out.write(bs,0,len);
			len = is.read(bs);
		}
		out.flush();
		out.close();
		is.close();
	}

}
