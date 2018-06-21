package com.springmvc.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.bean.User;

@Controller
public class Hello {
	@RequestMapping(value = "/index.html")
	public String getView(ModelMap model) {
		model.addAttribute("message", "hello");
		return "hello";
	}

	@RequestMapping(value = "/page/{name}/{age}", method = RequestMethod.GET)
	public String getName(ModelMap model, @PathVariable("name") String name, @PathVariable("age") int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "name";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(ModelMap model, @RequestParam("name") String name, @RequestParam int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		User user = new User();
		user.setName(name);
		user.setAge(age);
		model.addAttribute("user", user);
		return "result";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(ModelMap model,HttpServletRequest request) {
		System.out.println("---------进入user---------");
		User user = new User();
		user.setName("miner");
		user.setAge(19);
		model.addAttribute("user", user);
		request.getSession().setAttribute("user", user);
		return "user";
	}
	
	@RequestMapping("/index")
	public void index(){
		System.err.println("----test----");
	}
	
	@RequestMapping("/hello2")
	public ModelAndView name() {
		ModelAndView mv = new ModelAndView("hello2","name","miner");
		return mv;
	}
	/**
	 * ant风格
	 * @return
	 */
	@RequestMapping("users/*")
	public String test(){
		return "ant_test";
	}
	@RequestMapping("users/**")
	public String test_(){
		return "ant_test";
	}
	@RequestMapping("users/**/test/{id}")
	public String test_1(@PathVariable int id){
		System.out.println("id="+id);
		return "ant_test";
	}
	
	/**
	 * 正则表达式风格
	 */
	@RequestMapping("users/{categoryCode:\\d+}-{pageNumber:\\d+}")
	public String test1_1(@PathVariable int categoryCode,@PathVariable int pageNumber){
		System.out.println("pageNumber"+pageNumber);
		return "ant_test";
	}
	
	
	
}
