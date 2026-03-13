package sec06;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {

	// 기본 도서 정보 입력
	public static BookDTO getbookInfo(Scanner sc) {
		BookDTO dto = null;

		try {
			// 도서 데이터 입력
			System.out.println("도서 정보 등록");
			System.out.print("도서 번호 입력 : ");
			String bookNo = sc.nextLine();
			
			System.out.print("도서 제목 입력 : ");
			String bookName = sc.nextLine();

			System.out.print("도서 저자 입력 : ");
			String bookAuthor = sc.nextLine();

			System.out.print("도서 가격 입력 : ");
			int bookPrice = sc.nextInt(); sc.nextLine();

			System.out.print("도서 날짜 입력 : ");
			String bookDate = sc.nextLine();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fm.parse(bookDate); // String -> date 타입 변경 메소드

			System.out.print("도서 재고 입력 : ");
			int bookStock = sc.nextInt(); sc.nextLine();
			
			System.out.print("도서 출판사 번호 입력 : ");
			String pubNo = sc.nextLine();

			dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, date, bookStock, pubNo);
			
		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
			return null;
		}

		return dto;
	}

	// update용 입력 처리
	public static BookDTO getBookInfo(Scanner sc, String bookNo) {
		BookDTO dto = null;

		try {
			// 학생 데이터 입력
			System.out.println("도서 정보 수정");

			System.out.print("도서 제목 입력 : ");
			String bookName = sc.nextLine();

			System.out.print("도서 저자 입력 : ");
			String bookAuthor = sc.nextLine();

			System.out.print("도서 가격 입력 : ");
			int bookPrice = sc.nextInt(); sc.nextLine();

			System.out.print("도서 날짜 입력 : ");
			String bookDate = sc.nextLine();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fm.parse(bookDate); // String -> date 타입 변경 메소드

			System.out.print("도서 재고 입력 : ");
			int bookStock = sc.nextInt(); sc.nextLine();
			
			System.out.print("도서 출판사 번호 입력 : ");
			String pubNo = sc.nextLine();

			dto = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, date, bookStock, pubNo);
		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
			return null;
		}

		return dto;
	}

	// 도서 정보 출력
	public static void writeBookInfo(ArrayList<BookDTO> bookList) {
		// 제목 출력
		System.out.println("----- 전체 도서 정보 조회 ------");
		System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %13s %5s\n", "도서 번호", "도서 제목", "저자", "가격", "출판일", "재고", "출판사");

		for (BookDTO dto : bookList) {
			// 정보 추출
			String bookNo = dto.getBookNo();
			String bookName = dto.getBookName();
			String bookAuthor = dto.getBookAuthor();
			int bookPrice = dto.getBookPrice();
			Date bookDate = dto.getBookDate();
			int bookStock = dto.getBookStock();
			String pubNo = dto.getPubNo();

			// 출력
			System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %13s %5s\n", bookNo, bookName, bookAuthor, bookPrice,
					bookDate, bookStock, pubNo);
		}
	}
}
