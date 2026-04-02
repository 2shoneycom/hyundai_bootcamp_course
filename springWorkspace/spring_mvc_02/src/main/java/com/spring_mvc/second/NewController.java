package com.spring_mvc.second;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String newView(java.util.Locale locale, org.springframework.ui.Model model) {
		
		java.util.Date date = new java.util.Date();
	    java.text.DateFormat dateFormat = java.text.DateFormat.getDateTimeInstance(java.text.DateFormat.LONG, java.text.DateFormat.LONG, locale);
	    
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate);
	    
		return "index";
	}
}
