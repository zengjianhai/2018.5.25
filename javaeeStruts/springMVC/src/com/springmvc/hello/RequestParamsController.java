package com.springmvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 对请求的参数映射
 * 
 * @author xunfeng
 *
 */
@RequestMapping("RequestParam")
@Controller
public class RequestParamsController {

	// 请求参数里面必须要有指定的参数名
	/*
	 * @RequestMapping(params = { "userName", "passWd" }) public String test() {
	 * return "ant_test"; }
	 */

	// 请求参数不能有指定的参数名
	@RequestMapping(params = "!group")
	public String test_1() {
		return "ant_test";
	}

	// 请求参数里面必须要有userName=min
	@RequestMapping(params = "userName=min")
	public String test_2() {
		return "ant_test";
	}

	// 请求参数里面必须要有userName不等于min
	@RequestMapping(params = "userName=!min")
	public String test_3() {
		return "ant_test";
	}
}
