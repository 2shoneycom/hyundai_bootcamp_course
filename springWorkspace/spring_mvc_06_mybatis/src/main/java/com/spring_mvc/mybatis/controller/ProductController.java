package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_mvc.mybatis.service.ProductService;
import com.spring_mvc.mybatis.vo.ProductVO;

@Controller
public class ProductController {
	//컨트롤러 <-> 서비스 <-> DAO
	//DI 설정
	@Autowired
	ProductService service;
	
	//시작페이지
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	//전체 상품 조회
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		ArrayList<ProductVO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);
		return "product/productListView";
	}
	
	//상품 등록 폼 요청
	@RequestMapping("/product/newProductForm")
	public String viewProductForm() {
		return "product/newProductForm";
	}
	
	//상품 등록 요청 - 파라미터 - vo 필드에 저장해서 메소드 주입 (common 객체 사용)
	//파라미터명과 필드명이 동일하게 매핑되는 경우에만 파라미터값 필드에 저장
	//파라미터 common 객체를 service에게 전달
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductVO vo) {
		service.insertProduct(vo); //호출해서 실행 오류가 없으면 insert 완료되었다는 의미
		//상품정보가 제대로 등록되었는 확인을 위한 재요청을 클라이언트에게 redirect 응답
		return "redirect:/product/listAllProduct";
		
	}
	
	//상품 상세 정보 조회 : 파라미터(path variable)
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		ProductVO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd", prd);
		
		return "product/productDetailView";
	}

	//상품 정보 수정 폼 요청
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String viewUpdateForm(@PathVariable String prdNo, Model model ) {
		ProductVO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd",prd);
		
		return "product/updateProductForm";
	}

	//상품 정보 수정 요청 - 파라미터로 전달된 값들을 객체 필드의 이름과 매핑해서 값을 필드에 주입한 객체가 전달
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductVO prd) {
		service.updateProduct(prd);
		return "redirect:/product/listAllProduct";
		
	}
	
	//상품 정보 삭제
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		service.deleteProduct(prdNo);
		return "redirect:/product/listAllProduct";
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	//상품번호 중복 확인 - 비동기 요청에 대한 응답
	@ResponseBody
	@RequestMapping("/product/prdNoCheck")
	public String prdNoCheck(@RequestParam("prdNo") String prdNo) {

		String res = service.prdNoCheck(prdNo);		
		return res; //응답객체의 body로 구성됨->클라이언트에게 직접 전달
	}
	
	@ResponseBody
	@RequestMapping("/product/prdNoCheck1/{prdNo}")
	public String prdNoCheck1(@PathVariable String prdNo) {

		String res = service.prdNoCheck(prdNo);		
		return res; //응답객체의 body로 구성됨->클라이언트에게 직접 전달
	}
	
	@ResponseBody
	@RequestMapping("/product/prdNoCheck2/{prdNo}")
	public String prdNoCheck2(@PathVariable String prdNo) {

		String res = service.prdNoCheck(prdNo);		
		return res; //응답객체의 body로 구성됨->클라이언트에게 직접 전달
	}	
	
	//클라이언트 비동기 요청시 요청 body에 data가 포함되어 있음 : @RequestBody 사용
	@ResponseBody
	@RequestMapping("/product/prdNoCheck3")
	public String prdNoCheck3( @RequestBody String prdNo) {

		String res = service.prdNoCheck(prdNo);		
		return res; //응답객체의 body로 구성됨->클라이언트에게 직접 전달
	}
	
	@ResponseBody
	@RequestMapping("/product/prdNoCheck4/{prdNo}")
	public String prdNoCheck4(@PathVariable String prdNo) {

		String res = service.prdNoCheck(prdNo);		
		return res; //응답객체의 body로 구성됨->클라이언트에게 직접 전달
	}
	
	@ResponseBody
	@RequestMapping("/product/prdNoCheck5")
	public String prdNoCheck5( @RequestBody HashMap<String, String> map) {
		System.out.println(map.get("prdNo"));
		String prdNo = map.get("prdNo");
		String res = service.prdNoCheck(prdNo);		
		return res; //응답객체의 body로 구성됨->클라이언트에게 직접 전달
	}	
	
	/////////////////////////상품 검색////////////////////////////////
	
	// 상품 검색 폼 열기 요청 처리1
	@RequestMapping("/product/productSearchForm1")
	public String viewSearchForm1() {
		return "product/productSearchForm1";
	}
	
	// 상품 검색 폼 열기 요청 처리2
	@RequestMapping("/product/productSearchForm2")
	public String viewSearchForm2() {
		return "product/productSearchForm2";
	}
	
	// 상품 검색 폼 열기 요청 처리3
	@RequestMapping("/product/productSearchForm3")
	public String viewSearchForm3() {
		return "product/productSearchForm3";
	}	
	
	//////////////////////////////////////////////////////////////////
	// 상품 검색 : 방법 1 (responsebody 데이터로 반환)
	// ArrayList<ProductVO>타입의 객체가 반환
	@ResponseBody
	@RequestMapping("/product/productSearch1")
	public ArrayList<ProductVO> productSearch1(@RequestParam HashMap<String, Object> param, Model model) { 
		ArrayList<ProductVO> prdList = service.productSearch(param);
		//model.addAttribute("prdList", prdList); 
		return prdList; //ArrayList 객체 자체 반환은 불가 -> json 형태로 변환(jackson-databind) 후 반환
	}
	
	// 상품 검색 : 방법 2 (view 반환)
	// ArrayList<ProductVO>타입의 객체가 반환
	@RequestMapping("/product/productSearch2")
	public String productSearch2(@RequestParam HashMap<String, Object> param, Model model) { 
		ArrayList<ProductVO> prdList = service.productSearch(param);
		model.addAttribute("prdList", prdList);
		return "product/productSearchResultView"; 
	}	

}






















