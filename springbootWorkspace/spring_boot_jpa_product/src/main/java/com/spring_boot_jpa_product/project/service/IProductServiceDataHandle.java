package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;
import java.util.Optional;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

public interface IProductServiceDataHandle {
	// 데이터 교환 : Entity
	
	ArrayList<ProductEntity> listAllProduct(); // 전체 상품 조회 - null이 반환되지 않음

	void insertProduct(ProductEntity entity); // 상품 정보 등록

	void updateProduct(ProductEntity entity); // 상품 정보 수정

	void deleteProduct(String prdNo); // 상품 정보 삭제

	Optional<ProductEntity> detailViewProduct(String prdNo); // 상세 상품 조회 (entity 반환되야 하는데 null 반환가능성이 있음 -> Optional 사용) )

	String prdNoCheck(String prdNo); // 상품번호 중복 확인
	
	// jpa에서 1개 entity 
}
