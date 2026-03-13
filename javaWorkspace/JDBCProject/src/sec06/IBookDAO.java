package sec06;

import java.util.ArrayList;

public interface IBookDAO {
	// 도서 등록
	public void insertBook(BookDTO dto);
	
	// 전체 도서 조회
	public ArrayList<BookDTO> getAllBook();
	
	// 도서 정보 수정
	public void updateBook(BookDTO dto);
	
	// 도서 정보 삭제
	public void deleteBook(String bookNo);
	
}
