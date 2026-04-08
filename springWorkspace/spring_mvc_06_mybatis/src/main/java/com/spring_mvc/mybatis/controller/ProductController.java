package com.spring_mvc.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_mvc.mybatis.service.ProductService;
import com.spring_mvc.mybatis.vo.ProductVO;

@Controller
public class ProductController {
	// 컨트롤러 <-> 서비스 <-> DAO
	@Autowired
	ProductService service;
	
	// 시작 페이지
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	// 전체 상품 조회
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		model.addAttribute("prdList", service.listAllProduct());
		return "product/productListView";
	}
	
	// 상품 등록 폼 요청
	@RequestMapping("/product/newProductForm")
	public String viewProductForm() {
		return "product/newProductForm";
	}
	
	// 상품 등록 요청 - 파라미터 - vo 필드에 저장해서 메소드 주입 (common 객체 사용)
	// 파라미터명과 필드명이 동일하게 매핑되는 경우에만 파라미터값 필드에 저장
	// 파라미터 common 객체를 service에게 전달
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductVO vo) {
		service.insertProduct(vo); // 호출해서 실행 오류가 없으면 insert 완료되었다는 의미
		
		// 상품정보가 제대로 등록되었는 지 확인을 위한 재요청을 클라이언트에게 redirect 응답
		return "redirect:/product/listAllProduct";
	}
	
	// 상품 상세 정보 조회 : 파라미터 (path variable)
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		model.addAttribute("prd", service.detailViewProduct(prdNo));
		return "product/productDetailView";
	}
	
	// 상품 정보 수정 폼 요청
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String viewUpdateForm(@PathVariable String prdNo, Model model) {
		model.addAttribute("prd", service.detailViewProduct(prdNo));
		return "product/updateProductForm";
	}
	
	// 상품 정보 수정
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductVO prd) {
		service.updateProduct(prd);
		return "redirect:/product/listAllProduct";
	}
	
	// 상품 정보 삭제
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		service.deleteProduct(prdNo);
		return "redirect:/product/listAllProduct";
	}
	
	// 상품 번호 중복 확인
	@ResponseBody
	@RequestMapping("/product/prdNoCheck")
	public String prdNodCheck(@RequestParam("prdNo") String prdNo) {
		String res = service.prdNoCheck(prdNo);
		
		return res;
	}
}
