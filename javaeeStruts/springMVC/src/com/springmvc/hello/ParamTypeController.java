package com.springmvc.hello;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map.Entry;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.bean.User;

/**
 * 测试Controller中的方法参数，都可以写那些类型
 * 
 * @author xunfeng
 */
@RequestMapping("ParamType")
@Controller
public class ParamTypeController {

	@RequestMapping("test1")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request=" + request);
		System.out.println("response=" + response);
		return "ant_test";
	}

	@RequestMapping("test2")
	public void test2(InputStream ins, OutputStream out) throws IOException {
		out.write("sb".getBytes());
		out.flush();
		System.out.println("ins=" + ins);
		System.out.println("out=" + out);
	}

	@RequestMapping("test3")
	public String test3(User user) {
		System.out.println("user=" + user);
		return "user";
	}

	@RequestMapping("test4")
	public String test4(HttpEntity<String> entity) {
		HttpHeaders headers = entity.getHeaders();
		Set<Entry<String, List<String>>> set = headers.entrySet();
		for (Entry<String, List<String>> entry : set) {
			String kString = entry.getKey();
			List<String> list = entry.getValue();
			System.out.print(kString + ": ");
			for (String string : list) {
				System.out.println(string);
			}
		}
		return "ant_test";
	}

	@RequestMapping("test5")
	public String test5(User user1, HttpServletRequest request) {
		System.out.println("user1="+user1);
		request.setAttribute("name", user1.getName());
		return "result";
	}
	
	@RequestMapping("test6")
	public String test6() {
		return "user2";
	}
}
