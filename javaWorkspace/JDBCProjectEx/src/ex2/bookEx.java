package ex2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class bookEx {
	public static void main(String[] args) {
		// 필요 참조변수 선언 및 생성
		Scanner sc = new Scanner(System.in);
		bookJDBConn dbCon = new bookJDBConn();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		String bookNo, bookTitle, bookAuthor, bookDate, pubNo;
		int bookPrice, bookStock;
		
		try {
			con = dbCon.getConnection(); // DB 연결\
			
			int userMenu = 0;
			while (userMenu != 5) {
				System.out.println("메뉴 선택 [1. 총 도서 권수 출력 / 2. 특정 연도 이후 발행된 도서 출력 / 3. 저자명으로 도서 검색 / 4. 특정 가격이상 도서 검색 / 5. 종료]");
				userMenu = sc.nextInt();
				
				switch(userMenu) {
				case 1:
					sql = "SELECT COUNT(bookNo) FROM book";
					pstmt = con.prepareStatement(sql); 
					rs = pstmt.executeQuery();
					if (rs.next()) { // 커서를 첫 줄로 이동
                        System.out.println("총 도서 권수: " + rs.getInt(1) + "권");
                    }
					break;
					
				case 2:
					System.out.print("연도를 입력해주세요");
					String year = sc.next();
					sql = "SELECT * FROM book WHERE bookDate >= ?";
					pstmt = con.prepareStatement(sql); 
					pstmt.setString(1, year + "-01-01");
					rs = pstmt.executeQuery();
					while (rs.next()) {
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
					break;
					
				case 3:
					System.out.print("저자를 입력해주세요");
					String author = sc.next();
					sql = "SELECT * FROM book WHERE bookAuthor LIKE ?";
					pstmt = con.prepareStatement(sql); 
					pstmt.setString(1, '%' + author + '%');
					rs = pstmt.executeQuery();
					while (rs.next()) {
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
					break;
					
				case 4:
					System.out.print("가격을 입력해주세요");
					int price = sc.nextInt();
					sql = "SELECT * FROM book WHERE bookPrice >= ?";
					pstmt = con.prepareStatement(sql); 
					pstmt.setInt(1, price);
					rs = pstmt.executeQuery();
					while (rs.next()) {
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
					break;
					
				case 5:
					break;
				default:
					System.out.println("잘못된 번호를 입력하였습니다");
				}
				
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
