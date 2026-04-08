package com.spring_mvc.mybatisEx.model;

import java.util.ArrayList;

import com.spring_mvc.mybatisEx.vo.BookVO;

public interface IBookDAO {
	// 전체 도서 조회
	public ArrayList<BookVO> listAllBook();

	// 도서 정보 등록
	public void insertBook(BookVO bookVo);

	// 도서 정보 수정
	public void updateBook(BookVO bookVo);

	// 도서 정보 삭제
	public void deleteBook(String bookVo);

	// 도서 상세 정보 조회
	public BookVO detailViewBook(String bookVo);
}
