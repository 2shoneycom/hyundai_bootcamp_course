package controller;

import java.util.Vector;

import model.BookDAO;
import model.BookDTO;
import model.IBookDAO;
import view.BookList;
import view.ResultView;

public class BookController {
	// 싱글톤: 단 하나의 객체만 생성
	private static BookController instance;
	IBookDAO dao = new BookDAO();

	private BookController() {
	}

	public static BookController getInstance() {
		if (instance == null) {
			instance = new BookController();
		}
		return instance;
	}

	// View로부터 dto 전달받아서 dao 통해서 db에 저장한 후에 결과에 따라 메시지 출력을 위한 view 호출
	// dao에서 던져지는 예외를 반드시 처리해야 함 (일반적으로 예외는 컨트롤러가 처리)
	public void insert(BookDTO newDto) { // 객체 인스턴스가 있어야 사용가능 메소드
		try {
			BookDTO dto = new BookDTO();

			dto.setBookNo(newDto.getBookNo());
			dto.setBookName(newDto.getBookName());
			dto.setBookAuthor(newDto.getBookAuthor());
			dto.setBookPrice(newDto.getBookPrice());
			dto.setBookDate(newDto.getBookDate());
			dto.setBookStock(newDto.getBookStock());
			dto.setPubNo(newDto.getPubNo());

			if (dao.insert(dto)) {
				ResultView.succMsg("도서 정보가 등록되었습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도저정보 등록 오류");
		}
	}

	public void getAllBook() {
		try {
			Vector<BookDTO> dataSet = dao.getAllBook();

			if (dataSet.size() > 0) {
				BookList.showAllBook(dataSet);
			} else {
				ResultView.succMsg("검색 결과가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 조회중 오류 발생");
		}
	}

	public void update(BookDTO newDto) {
		try {
			BookDTO dto = new BookDTO();

			dto.setBookNo(newDto.getBookNo());
			dto.setBookName(newDto.getBookName());
			dto.setBookAuthor(newDto.getBookAuthor());
			dto.setBookPrice(newDto.getBookPrice());
			dto.setBookDate(newDto.getBookDate());
			dto.setBookStock(newDto.getBookStock());
			dto.setPubNo(newDto.getPubNo());
			
			if (dao.update(dto)) {
				ResultView.succMsg("도서 정보를 수정하였습니다. 도서정보 조회에서 확인하세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 수정 오류");
		}
	}
	
	public void delete(String bookNo) {
		try {
			BookDTO dto = new BookDTO();
			
			dto.setBookNo(bookNo);
			
			if (dao.delete(dto)) {
				ResultView.succMsg("도서 (" + bookNo + ") 삭제 성공");
			} else {
				ResultView.succMsg("도서 (" + bookNo + ")가 존재하지 않습니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 삭제 중 오류 발생");
		}
	}
}
