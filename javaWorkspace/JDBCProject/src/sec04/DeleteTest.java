package sec04;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteTest {
	public static void main(String[] args) {
		DBConnect dbCon = new DBConnect();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		String sql = null;
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;

		try {
			con = dbCon.getConnection();
			sql = "DELETE book WHERE bookNo=?";
			pstmt = con.prepareStatement(sql);
			
			System.out.print("삭제할 도서번호 입력: ");
			bookNo = sc.nextLine();
			
			// pstmt 객체 sql에 데이터 바인딩
			pstmt.setString(1, bookNo);

			// 질의 전달 및 실행
			pstmt.executeUpdate();
			System.out.println("도서정보 삭제 성공");

			// 등록된 값 확인
			sql = "SELECT * FROM book where bookNo=?";
			PreparedStatement pstmtSel = con.prepareStatement(sql);
			pstmtSel.setString(1, bookNo);
			rs = pstmtSel.executeQuery();

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
			rs.close();
			pstmt.close();
			con.close(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
