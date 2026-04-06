package com.spring_mbc.jdbc2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mbc.jdbc2.dto.ProductDTO;
import com.spring_mbc.jdbc2.model.ProductDAO;

@Controller
public class ProductController {
	@Autowired
	ProductDAO prdDao;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/product/productSelect")
	public String memberSelect(Model model) {
		// 회원 검색 로직 처리 요청
		ArrayList<ProductDTO> prdList = prdDao.productSelect();

		// model 객체 구성
		model.addAttribute("prdList", prdList); 
		
		return "product/productSelectRes";
	}
}
