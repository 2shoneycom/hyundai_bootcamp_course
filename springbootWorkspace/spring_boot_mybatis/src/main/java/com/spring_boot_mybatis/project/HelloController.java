package com.spring_boot_mybatis.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	//@RequestMapping("/") //명확한 요청 method로 변경
	//@ResponseBody
	@GetMapping("/image")
	public String index(Model model) {
		return "image";
	}
	
	@GetMapping("/hello")
	public String home(Model model) {
		System.out.println("Hello Boot!!");
		model.addAttribute("message", "안녕 하세요");
		return "home";
	}
}
