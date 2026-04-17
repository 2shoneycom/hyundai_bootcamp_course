package com.spring_boot_jpa_product.project.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

public interface IProductDAO {
	ArrayList<ProductEntity> listAllProduct(); // 전체 상품 조회

	void insertProduct(ProductEntity entity); // 상품 정보 등록

	void updateProduct(ProductEntity entity); // 상품 정보 수정

	void deleteProduct(String prdNo); // 상품 정보 삭제

	Optional<ProductEntity> detailViewProduct(String prdNo);// 상세 상품 조회

	String prdNoCheck(String prdNo); // 상품번호 중복 확인
}
