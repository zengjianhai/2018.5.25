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
	// ���ֻ������ͺ�String���ͣ���ҳ���ò���ֵ������֮�����������Ϊ�����󣬿����õ�������User
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

	//�������name=cityList������������������ֵ����value��
	@ModelAttribute("cityList")
	public List<String> name3(String cityList) {
		System.out.println("cityList=" + cityList);
		return Arrays.asList("����", "�Ϻ�");
	}

	@RequestMapping("test4")
	public String name4(@ModelAttribute("user") User user) {
		System.out.println("user=" + user);
		return "model";
	}
}
