package com.springmvc.hello;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.bean.User2;

@RequestMapping("Valid")
@Controller
public class ValidController {

	@RequestMapping(value="add",method=RequestMethod.GET)
	public String test1(Model model){
		if(!model.containsAttribute("user2")){
			model.addAttribute("user2", new User2());
		}
		return "login";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String test2(@Valid User2 user2,BindingResult bindingResult){
		System.out.println(user2);
		//�����֤�������д�����Ϣ,��������bindingResult������
		if(bindingResult.hasErrors()){
			List<ObjectError> errorList = bindingResult.getAllErrors();             
			for(ObjectError error : errorList){                 
				System.out.println(error.getDefaultMessage());             
			}
			//��֤��ͨ��������validҳ��,��Ϊҳ��������ʾ����ı�ǩ
			return "login";
		}
		
		//û�д���������testҳ��
		return "test";
	}
}
