package com.spring_mvc.mybatisEx.model;

import java.util.ArrayList;

import com.spring_mvc.mybatisEx.vo.BookVO;

public interface IBookDAO {
	// 전체 도서 조회
	public ArrayList<BookVO> listAllBook();
}
