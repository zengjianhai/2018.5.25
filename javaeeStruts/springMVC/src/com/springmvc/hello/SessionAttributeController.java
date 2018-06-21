package com.springmvc.hello;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springmvc.bean.User;

@SessionAttributes({ "user" })
@RequestMapping("Session")
@Controller
public class SessionAttributeController {

	@RequestMapping("test1")
	public String test1(User user) {
		System.out.println("user=" + user);
		return "model";
	}

	@RequestMapping("test2")
	public String test2(@ModelAttribute("user") User user, Map<String, Object> map) {
		System.out.println("user=" + user);
		for (String key : map.keySet()) {
			System.out.println(key + "=" + map.get(key));
		}
		return "model";
	}

	@RequestMapping("test3")
	public String test3(HttpSession session) {
		System.out.println("session=" + session.getAttribute("user"));
		Enumeration<String> enums = session.getAttributeNames();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement();
			System.err.println("key=" + key);
		}
		return "model";
	}

	@RequestMapping("test4")
	public String test4(@ModelAttribute("user") User user, Map<String, Object> map) {
		User sUser = (User) map.get("user");
		System.out.println(sUser == user);
		return "model";
	}
	
	@RequestMapping("test5")
	public String test5(SessionStatus status) {
		status.setComplete();
		return "model";
	}
}
