package com.spring_mvc.mybatisEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatisEx.service.BookService;
import com.spring_mvc.mybatisEx.vo.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService service;

	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		model.addAttribute("bookList", service.listAllBook());
		return "book/bookListView";
	}
	
	@RequestMapping("/book/newBookForm")
	public String viewBookForm() {
		return "book/newBookForm";
	}
	
	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO vo) {
		service.insertBook(vo);
		return "redirect:book/bookListView";
	}
	
	@RequestMapping("/book/detailViewBook/{book.bookNo}")
	public String viewDetailBook(@PathVariable String bookNo, Model model) {
		model.addAttribute("book", service.detailViewBook(bookNo));
		return "book/bookDetailView";
	}
	
	
}
