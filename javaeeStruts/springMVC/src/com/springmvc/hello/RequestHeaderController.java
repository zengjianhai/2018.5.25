package com.springmvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("RequestHeader")
@Controller
public class RequestHeaderController {

	// 请求头部要等于Upgrade-Insecure-Requests=1
	@RequestMapping(value = "test1", headers = "Upgrade-Insecure-Requests=1")
	public String test_1() {
		return "ant_test";
	}

	@RequestMapping(value = "test2", headers = "Accept=text/html")
	public String test_2() {
		return "ant_test";
	}

	// consumes对应的是request-header中的Content-Type
	@RequestMapping(value = "test3", consumes = "text/html")
	public String test_3() {
		return "ant_test";
	}

	// produces对应的是request-header中的Accept
	@RequestMapping(value = "test4", produces = "text/html")
	public String test_4() {
		return "ant_test";
	}
}
