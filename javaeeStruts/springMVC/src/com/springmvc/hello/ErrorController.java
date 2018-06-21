package com.springmvc.hello;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//�쳣ͳһ����
@RequestMapping("Error")
@Controller
public class ErrorController {

	@RequestMapping("test1")
	public String test1() throws IOException {
		int a = 1;
		if (a > 0) {
			throw new IOException("������,������!");
		}
		return "error";
	}
	
	@RequestMapping("test2")
	public String test2()throws Exception{
		int a = 1;
		if(a==1){
			throw new SQLException("SQL�쳣����");
		}
		return "test";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("test3")
	public String test3()throws Exception{
		int a = 1/0;
		return "test";
	}
}
