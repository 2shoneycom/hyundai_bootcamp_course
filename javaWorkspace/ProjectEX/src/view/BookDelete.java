package view;

import java.util.Scanner;

import controller.BookController;

public class BookDelete {
	BookController controller = BookController.getInstance();
	
	public void delete(Scanner sc) {
		System.out.println("\n*************************");
		System.out.println("도서정보 삭제");
		System.out.println("***************************");
		
		BookList bls = new BookList();
		bls.getAllBook();
		
		System.out.print("삭제할 도서번호 입력 : ");		
		String bookNo = sc.nextLine();
		
		controller.delete(bookNo);
	}
}
