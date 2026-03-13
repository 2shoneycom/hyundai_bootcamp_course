package sec03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import sec05.DBConnect;

public class CRUDTestInput2 {

	public static void main(String[] args) {
		// 필요 참조변수 선언 및 생성
		Scanner sc = new Scanner(System.in);
		DBConnect dbCon = new DBConnect();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = null;
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;

		try {
			con = dbCon.getConnection();
			sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql); 

			// 사용자로부터 데이터 입력
			System.out.print("도서번호 입력: ");
			bookNo = sc.nextLine();
			
			System.out.print("도서제목 입력: ");
			bookTitle = sc.nextLine();
			
			System.out.print("도서저자 입력: ");
			bookAuthor = sc.nextLine();
			
			System.out.print("도서가격 입력: ");
			bookPrice = Integer.parseInt(sc.nextLine()); // 사용자가 enter를 넣었을 때 enter 바로 앞 입력까지만 처리 ('\n'이 다음 입력에 껴들어감)

			System.out.print("입고날짜 입력: ");
			bookDate = sc.nextLine();

			System.out.print("도서재고 입력: ");
			bookStock = Integer.parseInt(sc.nextLine());
			
			System.out.print("출판사 번호 입력: ");
			pubNo = sc.nextLine();
			
			// pstmt 객체 sql에 데이터 바인딩
			pstmt.setString(1, bookNo);
			pstmt.setString(2, bookTitle);
			pstmt.setString(3, bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);

			// 질의 전달 및 실행
			int tmpResult = pstmt.executeUpdate();
			if (tmpResult == 1) {
				System.out.print("도서 정보 등록 성공");
			}

			// 등록된 값 확인
			sql = "SELECT * FROM book";
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				// 현재 rs 참조하는 레코드의 각 컬럼의 값을 반환받아서 변수에 저장
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				Date bookDate1 = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);

				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo, bookTitle, bookAuthor,
						bookPrice, bookDate1, bookStock, pubNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
