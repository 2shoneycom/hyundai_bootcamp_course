package com.spring_mvc.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@RequestMapping("/loginForm")
	public String viewLogin() {
		
		return "ajax/login";
	}
	
	@ResponseBody
	@RequestMapping("/login") 
	public String loginCheck(@RequestParam("user_id") String id,
							 @RequestParam("user_pw") String pw) {
		String result="";
		
		if (id.equals("abcd") && pw.equals("1234")) {
			result = "success";
		} else {
			result = "fail";
		}
		
		return result;
	}
}
