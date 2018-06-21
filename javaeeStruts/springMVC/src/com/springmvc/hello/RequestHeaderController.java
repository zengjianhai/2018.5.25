package com.springmvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("RequestHeader")
@Controller
public class RequestHeaderController {

	// ����ͷ��Ҫ����Upgrade-Insecure-Requests=1
	@RequestMapping(value = "test1", headers = "Upgrade-Insecure-Requests=1")
	public String test_1() {
		return "ant_test";
	}

	@RequestMapping(value = "test2", headers = "Accept=text/html")
	public String test_2() {
		return "ant_test";
	}

	// consumes��Ӧ����request-header�е�Content-Type
	@RequestMapping(value = "test3", consumes = "text/html")
	public String test_3() {
		return "ant_test";
	}

	// produces��Ӧ����request-header�е�Accept
	@RequestMapping(value = "test4", produces = "text/html")
	public String test_4() {
		return "ant_test";
	}
}
