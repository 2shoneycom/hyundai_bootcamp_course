package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;

import com.spring_boot_jpa_product.project.dto.ProductDTO;

// DTO <-> Entity 변환
public interface IProductService {
	// 데이터 교환 : DTO
	// 컨트롤러 -> DTO -> Entity -> DataHandle 서비스 -> DAO -> DB
	// 컨트롤러 <- DTO <- Entity <- DataHandle 서비스 <- DAO <- DB
	
	ArrayList<ProductDTO> listAllProduct(); // 전체 상품 조회

	void insertProduct(ProductDTO prdDto); // 상품 정보 등록

	void updateProduct(ProductDTO prdDto); // 상품 정보 수정

	void deleteProduct(String prdNo); // 상품 정보 삭제

	ProductDTO detailViewProduct(String prdNo);// 상세 상품 조회

	String prdNoCheck(String prdNo); // 상품번호 중복 확인
}
