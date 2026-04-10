package com.spring_mvc.mybatis.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.mybatis.vo.ProductVO;

public interface IProductDAO {
	ArrayList<ProductVO> listAllProduct();    //전체 상품 조회
	void insertProduct(ProductVO prdVo);      //상품 정보 등록
	void updateProduct(ProductVO prdVo);      //상품 정보 수정
	void deleteProduct(String prdNo);         //상품 정보 삭제
	ProductVO detailViewProduct(String prdNo);//상세 상품 조회
	String prdNoCheck(String prdNo);          //상품 번호 중복확인
	ArrayList<ProductVO> productSearch(HashMap<String, Object> map); //상품 검색
}
