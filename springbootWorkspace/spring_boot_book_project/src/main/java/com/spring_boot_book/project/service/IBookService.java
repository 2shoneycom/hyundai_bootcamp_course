package com.spring_boot_book.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_book.project.vo.BookVO;


public interface IBookService {

	// 전체 도서 조회
	public ArrayList<BookVO> listAllBook();

	// 도서 정보 등록
	public void insertBook(BookVO vo);

	// 도서 정보 수정
	public void updateBook(BookVO vo);

	// 도서 정보 삭제
	public void deleteBook(String bookNo);

	// 도서 상품 정보 조회
	public BookVO detailViewBook(String bookNo);

	// 도서 번호 중복 체크
	public String bookNoCheck(String bookNo);

	// 상품 검색
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> map);
}
