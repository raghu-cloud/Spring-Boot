package com.main.hi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

	@RequestMapping("/hello")
	public String hi() {
		return "Hi";
	}

}
