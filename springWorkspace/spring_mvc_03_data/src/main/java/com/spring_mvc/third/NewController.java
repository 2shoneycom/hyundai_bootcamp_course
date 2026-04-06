package com.spring_mvc.third;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/showInfo")
	public String showInfo(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 30);
		return "showInfo"; // 
	}
	
	@RequestMapping("/showInfo2")
	public ModelAndView showInfoMV(ModelAndView mv) {
		
		mv.addObject("name", "이몽룡");
		mv.addObject("address", "서울");
		
		mv.setViewName("showInfoMV");
		
		return mv;
	}
}
