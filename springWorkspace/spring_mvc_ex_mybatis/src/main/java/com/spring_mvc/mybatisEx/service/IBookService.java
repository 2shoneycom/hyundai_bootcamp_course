package com.spring_mvc.mybatisEx.service;

import java.util.ArrayList;

import com.spring_mvc.mybatisEx.vo.BookVO;

public interface IBookService {
	// 전체 도서 조회
	public ArrayList<BookVO> listAllBook();
}
