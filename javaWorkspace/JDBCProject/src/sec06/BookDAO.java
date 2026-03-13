package sec06;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO implements IBookDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BookDAO() {
		con = DBConnect.getConnection();
	}

	@Override
	public void insertBook(BookDTO dto) {
		// 도서 등록
		String sql = "INSERT INTO book VALUES(?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBookNo());
			pstmt.setString(2, dto.getBookName());
			pstmt.setString(3, dto.getBookAuthor());
			pstmt.setInt(4, dto.getBookPrice());
			pstmt.setDate(5, new java.sql.Date(dto.getBookDate().getTime()));
			pstmt.setInt(6, dto.getBookStock());
			pstmt.setString(7, dto.getPubNo());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("도서 등록 성공!");
			}
			
		} catch (Exception e) {
			System.out.println("도서 등록 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public ArrayList<BookDTO> getAllBook() {
		// 전체 도서 조회
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		
		String sql = "SELECT * FROM book ORDER BY bookNo";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String bookNo = rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice = rs.getInt(4);
				Date bookDate = rs.getDate(5);
				int bookStock = rs.getInt(6);
				String pubNo = rs.getString(7);
				
				bookList.add(new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo));
			}
			
		} catch (Exception e) {
			System.out.println("전체 도서 조회 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}

		return bookList;
	}

	@Override
	public void updateBook(BookDTO dto) {
		// 도서 정보 수정
		String sql = "UPDATE book "
				+ "SET bookName=?, bookAuthor=?, bookPrice=?, "
				+ "bookDate=?, bookStock=?, pubNo=? "
				+ "WHERE bookNo=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBookName());
			pstmt.setString(2, dto.getBookAuthor());
			pstmt.setInt(3, dto.getBookPrice());
			pstmt.setDate(4, new java.sql.Date(dto.getBookDate().getTime()));
			pstmt.setInt(5, dto.getBookStock());
			pstmt.setString(6, dto.getPubNo());
			pstmt.setString(7, dto.getBookNo());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("도서 정보(" + dto.getPubNo() + ") 수정 성공!");
			}
			else {
				System.out.println("도서 정보(" + dto.getPubNo() + ") 수정 실패!");
			}
			
		} catch (Exception e) {
			System.out.println("도서 정보 수정 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public void deleteBook(String bookNo) {
		// 도서 정보 삭제
		String sql = "DELETE FROM book WHERE bookNo=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("도서 정보(" + bookNo + ") 삭제 성공!");
			}
			else {
				System.out.println("도서 정보(" + bookNo + ") 삭제 실패!");
			}

		} catch (Exception e) {
			System.out.println("도서 정보 삭제 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}

	}

}
