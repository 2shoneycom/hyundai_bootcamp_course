package sec03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sec05.DBConnect;

public class CRUDTestInput {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		DBConnect dbCon = new DBConnect();
		
		String sql = null;
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;
		
		try {
			con = dbCon.getConnection();
			stmt = con.createStatement();
			
			bookNo = "99";
			bookTitle = "자바";
			bookAuthor = "김바로";
			bookPrice = 10000;
			bookDate = "2021-03-01";
			bookStock = 5;
			pubNo = "2";
			
			// 쿼리구성이 복잡함
			// sql = "INSERT INTO book VALUES('" + bookNo + "', '" + bookTitle + "', '" + bookAuthor + "', " + bookPrice + ", '" + bookDate + "'," + bookStock + ", '" + pubNo + "')";
			// int tmpResult = stmt.executeUpdate(sql); // 사용할 때마다 전처리 해야함
			
			// PreparedStatement 객체
			// Statement 인터페이스의 하위 인터페이스
			// 변수 바인딩 진행 (? : 바인딩 문자 -> placeholder)
			// 처음 한 번 전처리 후 다음 사용시에는 전처리 하지 않음 -> 처리속도가 빠름
			sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql); // PreparedStatement 객체 반환
			
			// 데이터 바인딩
			pstmt.setString(1, bookNo);
			pstmt.setString(2, bookTitle);
			pstmt.setString(3, bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);
			
			int tmpResult = pstmt.executeUpdate();
			
			if (tmpResult == 1) {
				System.out.print("INSERT 성공");
			}
			
			sql = "SELECT * FROM book";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				// 현재 rs 참조하는 레코드의 각 컬럼의 값을 반환받아서 변수에 저장
				bookNo = rs.getString(1);
				bookTitle = rs.getString(2);
				bookAuthor = rs.getString(3);
				bookPrice = rs.getInt(4);
				Date bookDate1 = rs.getDate(5);
				bookStock = rs.getInt(6);
				pubNo = rs.getString(7);
						
				System.out.format("%-10s\t %-20s\t %-10s %6d %13s \t%3d %10s\n", bookNo,bookTitle, bookAuthor, bookPrice,bookDate1, bookStock, pubNo);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
