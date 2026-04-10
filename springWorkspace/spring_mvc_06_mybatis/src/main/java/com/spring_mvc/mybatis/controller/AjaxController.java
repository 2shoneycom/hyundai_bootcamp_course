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
	public String loginCheck(@RequestParam("id") String id,
							 @RequestParam("pw") String pw) {
		
		String result = "";
		if(id.equals("abcd") && pw.equals("1234"))
			result = "success";
		else
			result = "fail";
		
		return result; //반한되는 result가 view 정보로 사용되지 않고 클라이언트에게 직접 result 변수 값을 전송		
	}
}
