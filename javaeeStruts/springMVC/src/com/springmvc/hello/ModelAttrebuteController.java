package com.springmvc.hello;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.bean.User;

@RequestMapping("Model")
@Controller
public class ModelAttrebuteController {
	// 八种基本类型和String类型，在页面拿不到值，除此之外的其他都作为表单对象，可以拿到，比如User
	@RequestMapping("test1")
	public String name(String name) {
		System.out.println("name=" + name);
		return "model";
	}

	// test2?name=tom
	@RequestMapping("test2")
	public String name2(@ModelAttribute("name") String name) {
		System.out.println("name=" + name);
		return "model";
	}

	//当上面的name=cityList，会把下面这个方法的值放入value中
	@ModelAttribute("cityList")
	public List<String> name3(String cityList) {
		System.out.println("cityList=" + cityList);
		return Arrays.asList("北京", "上海");
	}

	@RequestMapping("test4")
	public String name4(@ModelAttribute("user") User user) {
		System.out.println("user=" + user);
		return "model";
	}
}
