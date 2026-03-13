package model;

import java.util.Vector;

public interface IBooksaleDAO { 
	public boolean insert(BooksaleDTO dto) throws Exception;			// 도서 구매
	public Vector<BooksaleDTO> getAllBooksale() throws Exception;	// 구매 내역 조회
	public boolean update(BooksaleDTO dto) throws Exception;			// 구매 내역 수정
	public boolean delete(BooksaleDTO dto) throws Exception;			// 구매 내역 삭제 (구매 취소 등)
}
