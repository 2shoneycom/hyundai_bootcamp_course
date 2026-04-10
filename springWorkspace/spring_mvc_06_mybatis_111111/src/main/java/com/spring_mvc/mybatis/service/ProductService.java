package com.spring_mvc.mybatis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatis.model.IProductDAO;
import com.spring_mvc.mybatis.vo.ProductVO;

@Service
public class ProductService implements IProductService {
	// DAO 관련 메소드 호출
	
	@Autowired // (인터페이스 객체 주입)
	@Qualifier("IProductDAO")
	IProductDAO dao;
	
	// 상품 번호 중복 확인
	@Override
	public String prdNoCheck(String prdNo) {
		String no = dao.prdNoCheck(prdNo);
		
		String result = "avaliable";
		
		if (no != null) { // 상품번호가 존재
			result = "no_avaliable";
		} 
		
		return result;
	}
	
	// 전체 상품 조회
	@Override
	public ArrayList<ProductVO> listAllProduct() {
		return dao.listAllProduct();
	}

	// 상품 정보 등록
	@Override
	public void insertProduct(ProductVO prdVo) {
		dao.insertProduct(prdVo);
		
	}

	// 상품 정보 변경
	@Override
	public void updateProduct(ProductVO prdVo) {
		dao.updateProduct(prdVo);
	}

	// 상품 정보 삭제
	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);
	}

	// 상세 상품 조회
	@Override
	public ProductVO detailViewProduct(String prdNo) {
		return dao.detailViewProduct(prdNo);
	}
	
}
