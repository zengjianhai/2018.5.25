package com.runner.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.runner.common.bean.Memberinfo;
import com.runner.common.exception.MemberServiceException;
import com.runner.service.impl.IMemberInfoImpl;

@Controller
public class RegisterController {
	@Autowired
	private IMemberInfoImpl impl;

	@RequestMapping(value = "/register.do")
	public String loginPage() {
		return "register";
	}

	@RequestMapping(value = "/login.do")
	public String loginCheck(Memberinfo memberinfo) throws SQLException {
		try {
			impl.registerMemberinfo(memberinfo);
		} catch (MemberServiceException e) {
			e.printStackTrace();
		}
		return "login";
	}
}
