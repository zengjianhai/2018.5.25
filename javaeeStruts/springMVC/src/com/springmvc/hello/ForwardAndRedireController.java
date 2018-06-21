package com.springmvc.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("ForwardAndRedire")
@Controller
public class ForwardAndRedireController {

	@RequestMapping("test1")
	public String test1() {
		System.out.println("----test1----");
		return "forwardAndRedire";
	}
	
	@RequestMapping("test2")
	public String test2() {
		System.out.println("----test2----");
		return "forward:/ForwardAndRedire/test3";
	}
	
	@RequestMapping("test3")
	public String test3() {
		System.out.println("----test3----");
		return "forwardAndRedire";
	}
	
	@RequestMapping("test4")
	public String test4() {
		System.out.println("----test4----");
		return "redirect:/ForwardAndRedire/test5";
	}
	
	@RequestMapping("test5")
	public String test5() {
		System.out.println("----test5----");
		return "forwardAndRedire";
	}
	
	@RequestMapping("test6")
	public void test6(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----test6----");
		String path = "/WEB-INF/jsp/forwardAndRedire.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
}
