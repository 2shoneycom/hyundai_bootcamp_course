package com.spring_mvc.mybatis.service;

import java.util.ArrayList;

import com.spring_mvc.mybatis.vo.ProductVO;

public interface IProductService {
	// 전체 상품 조회
	ArrayList<ProductVO> listAllProduct(); 	
	
	// 상품 정보 등록
	void insertProduct(ProductVO prdVo); 	

	// 상품 정보 변경
	void updateProduct(ProductVO prdVo); 	
	
	// 상품 정보 삭제
	void deleteProduct(String prdNo);
	
	// 상세 상품 조회
	ProductVO detailViewProduct(String prdNo); 
}
