package com.spring_mvc.mybatisEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatisEx.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;

	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/book/listAllBook")
	public String handleListAllBook(Model model) {
		model.addAttribute("bookList", service.listAllBook());
		return "book/bookListView";
	}
}
