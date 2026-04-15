package com.spring_boot.projectEx.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot.projectEx.dto.CartDTO;

public interface ICartDAO {
	// 새로운 상품 장바구니에 추가
	void insertCart(CartDTO dto);

	// 동일 회원의 동일 상품 존재 여부 확인
	int checkPrdInCart(HashMap<String, Object> map);

	// 동일 상품이 존재하면 수량 변경
	void updateQtyInCart(CartDTO dto);

	// 장바구니 목록
	ArrayList<CartDTO> cartList(String memId);

	// 장바구니 삭제
	void deleteCart(String cartNo);

	// cart 수량 수정
	void updateCart(HashMap<String, Integer> map);
}
