package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import util.DBConnect;

public class BookDAO implements IBookDAO {

	@Override
	public boolean insert(BookDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO book VALUES(?,?,?,?,?,?,?)";

		con = DBConnect.getConnection();
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, dto.getBookNo());
		pstmt.setString(2, dto.getBookName());
		pstmt.setString(3, dto.getBookAuthor());
		pstmt.setInt(4, dto.getBookPrice());
		pstmt.setString(5, dto.getBookDate());
		pstmt.setInt(6, dto.getBookStock());
		pstmt.setString(7, dto.getPubNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(con, pstmt);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(BookDTO dto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBConnect.getConnection();
		String sql = "update book set bookName=?, bookAuthor=?,"
				+ "bookPrice=?,bookDate=?, bookStock=?, pubNo=? where bookNo=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getBookName());
		pstmt.setString(2, dto.getBookAuthor());
		pstmt.setInt(3, dto.getBookPrice());
		pstmt.setString(4, dto.getBookDate());
		pstmt.setInt(5, dto.getBookStock());
		pstmt.setString(6, dto.getPubNo());
		pstmt.setString(7, dto.getBookNo());

		int result = pstmt.executeUpdate();

		DBConnect.close(con, pstmt);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(BookDTO dto) throws Exception {
		Connection con = DBConnect.getConnection();
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM book WHERE bookNo=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getBookNo());
		
		int result = pstmt.executeUpdate();
		
		DBConnect.close(con, pstmt);
		
		if (result > 0) {
			return true;
		}
		else {
			return false;	
		}		
	}

	@Override
	public Vector<BookDTO> getAllBook() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<BookDTO> dataSet = null;

		String sql = "select * from book order by bookNo";

		con = DBConnect.getConnection();
		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();

		dataSet = new Vector<BookDTO>();

		while (rs.next()) {
			dataSet.add(new BookDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getDate(5).toString(), rs.getInt(6), rs.getString(7)));
		}
		DBConnect.close(con, pstmt, rs);
		return dataSet;
	}

}
