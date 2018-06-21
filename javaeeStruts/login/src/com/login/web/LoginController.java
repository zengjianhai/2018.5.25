package com.login.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.bean.User;
import com.login.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/index.html")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, User user) throws SQLException {
		int flag = userService.hasUser(user.getName(), user.getPasswd());
		boolean logo = false;
		if(flag>0){
			logo = true;
		}
		if (!logo) {
			return new ModelAndView("login","error","用户名或密码错误");
		} else {
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
}
