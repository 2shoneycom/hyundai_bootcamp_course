package com.spring_mvc.mybatisEx.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatisEx.model.IBookDAO;
import com.spring_mvc.mybatisEx.vo.BookVO;

@Service
public class BookService implements IBookService {
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;

	@Override
	public ArrayList<BookVO> listAllBook() {
		return dao.listAllBook();
	}
	
	@Override
	public void insertBook(BookVO bookVo) {
		dao.insertBook(bookVo);		
	}

	@Override
	public void updateBook(BookVO bookVo) {
		dao.updateBook(bookVo);		
	}

	@Override
	public void deleteBook(String bookVo) {
		dao.deleteBook(bookVo);		
	}

	@Override
	public BookVO detailViewBook(String bookVo) {
		return dao.detailViewBook(bookVo);
	}

}
