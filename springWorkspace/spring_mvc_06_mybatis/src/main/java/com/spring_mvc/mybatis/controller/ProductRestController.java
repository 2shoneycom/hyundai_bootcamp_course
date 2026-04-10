package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatis.service.ProductService;
import com.spring_mvc.mybatis.vo.ProductVO;

//@RestController로 등록된 클래스의 모든 메소드는 @ReseponseBody 추가한것과 동일함
//RestAPI 구성
@RestController
public class ProductRestController {

	@Autowired
	ProductService service;	

	//RestAPI 의 메소드로 처리
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductVO> productSearch3(@RequestParam HashMap<String, Object> param, Model model) { 
		ArrayList<ProductVO> prdList = service.productSearch(param);
		//model.addAttribute("prdList", prdList); 
		return prdList; 
	}	
}
