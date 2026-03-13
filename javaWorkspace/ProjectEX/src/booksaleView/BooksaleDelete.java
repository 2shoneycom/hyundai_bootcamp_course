package booksaleView;

import java.util.Scanner;

import controller.BooksaleController;

public class BooksaleDelete {
	BooksaleController controller = BooksaleController.getInstance();

	public void delete(Scanner sc) {
		System.out.println("\n*************************");
		System.out.println("도서 구매 내역 삭제");
		System.out.println("***************************");

		BooksaleList bsls = new BooksaleList();
		bsls.getAllBooksale();

		System.out.print("삭제할 구매 번호 입력 : ");
		String bsNo = sc.nextLine();

		controller.delete(bsNo);
	}
}
