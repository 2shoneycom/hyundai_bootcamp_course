package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis.project.model.IProductDAO;
import com.spring_boot_mybatis.project.vo.ProductVO;

@Service
public class ProductService implements IProductService{
	//dao 객체 주입(인터페이스 객체 주입)
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;
	
	//상품번호 중복 확인
	@Override
	public String prdNoCheck(String prdNo) {
		String no = dao.prdNoCheck(prdNo);
		
		String result = "avaliable";
		
		if(no != null) //상품번호가 존재
			result="no_avaliable";
		return result;
	}


	
	@Override
	public ArrayList<ProductVO> listAllProduct() {
		// dao의 관련 메소드 호출
		return dao.listAllProduct();
	}

	@Override
	public void insertProduct(ProductVO prdVo) {
		dao.insertProduct(prdVo);		
	}

	@Override
	public void updateProduct(ProductVO prdVo) {
		dao.updateProduct(prdVo);
		
	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);
		
	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {
		return dao.detailViewProduct(prdNo);
	}

}
