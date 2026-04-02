package com.spring_mvc.third;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	@RequestMapping("/bookInfoView1")
	public String bookInfo1(Model model) {
		model.addAttribute("title", "스프링 프레임워크");
		model.addAttribute("price", 20000);
		return "bookInfo1";
	}
}
