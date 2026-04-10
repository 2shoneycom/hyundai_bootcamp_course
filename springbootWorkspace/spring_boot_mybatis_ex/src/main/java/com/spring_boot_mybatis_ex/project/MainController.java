package com.spring_boot_mybatis_ex.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String viewHello() {
		return "hello";
	}
}
