package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {

	// 요청 처리 메소드
	@RequestMapping("/newView")
	public String newView() {
		// view 정보 반환
		return "newView";
	}
}
