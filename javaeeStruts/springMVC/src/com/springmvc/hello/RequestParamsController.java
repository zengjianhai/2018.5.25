package com.springmvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ������Ĳ���ӳ��
 * 
 * @author xunfeng
 *
 */
@RequestMapping("RequestParam")
@Controller
public class RequestParamsController {

	// ��������������Ҫ��ָ���Ĳ�����
	/*
	 * @RequestMapping(params = { "userName", "passWd" }) public String test() {
	 * return "ant_test"; }
	 */

	// �������������ָ���Ĳ�����
	@RequestMapping(params = "!group")
	public String test_1() {
		return "ant_test";
	}

	// ��������������Ҫ��userName=min
	@RequestMapping(params = "userName=min")
	public String test_2() {
		return "ant_test";
	}

	// ��������������Ҫ��userName������min
	@RequestMapping(params = "userName=!min")
	public String test_3() {
		return "ant_test";
	}
}
