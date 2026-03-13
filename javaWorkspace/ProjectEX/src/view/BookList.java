package view;

import java.util.Vector;

import controller.BookController;
import model.BookDTO;

public class BookList {
	BookController controller = BookController.getInstance();
	
	// 컨트롤러에게 레코드 요청해서 받아오고 출력
	public void getAllBook() {
		controller.getAllBook();
	}
	
	// 전달된 데이터 출력
	public static void showAllBook(Vector<BookDTO> dataSet) {
		System.out.println("\n*******************************");
		System.out.println("도서 정보 조회");
		System.out.println("*********************************");
		
		System.out.println("도서번호\t 도서명\t\t  저자\t\t 가격\t\t 발행일\t\t 재고 \t출판사번호");
		System.out.println("--------------------------------------------");
		
		for (BookDTO dto : dataSet) {
			System.out.println(dto);
		}
	}
}
