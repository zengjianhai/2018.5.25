package com.springmvc.hello;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * controller中的数据绑定
 * 
 * @author xunfeng
 *
 */
@RequestMapping("DataBingding")
@Controller
public class DataBingdingController {

	// userName要和表单的对应或url中的属性相同，就不用指定@RequestParam中为name
	@RequestMapping("test1")
	public String name(@RequestParam("name") String userName, HttpServletRequest request) {
		System.out.println("userName" + userName);
		request.setAttribute("name", userName);
		return "result";
	}

	// 专门用于获取cookie值
	@RequestMapping("test2")
	public String name1(@CookieValue(value = "JSESSIONID", required = false) String session) {
		System.out.println("session:" + session);
		return "ant_test";
	}

	@RequestMapping("test3")
	public String name2(@CookieValue(value = "JSESSIONID", required = false) Cookie cookie) {
		System.out.println("cookie:" + cookie);
		return "ant_test";
	}
	
	//获取请求头中的值
	@RequestMapping("test4")
	public String name3(@RequestHeader(value = "User-Agent") String header,@RequestHeader(value = "Accept") String[] accpet) {
		System.out.println("User-Agent:" + header);
		System.out.println("accpet:" + Arrays.toString(accpet));
		return "ant_test";
	}
}
