package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	public ProductDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ProductVO> listProducts() {
		List<ProductVO> productList = new ArrayList<ProductVO>();

		try {
			conn = dataFactory.getConnection();
			String sql = "SELECT * FROM product";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String prdNo = rs.getString("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				int prdStock = rs.getInt("prdStock");
				Date prdDate = rs.getDate("prdDate");
				String prdCompany = rs.getString("prdCompany");

				ProductVO vo = new ProductVO(prdNo, prdName, prdPrice, prdStock, prdDate, prdCompany);

				productList.add(vo);
			}

		} catch (Exception e) {
			System.out.println("상품 정보 조회 실패");
			e.printStackTrace();
		}

		return productList;
	}

	public void addProduct(ProductVO p) {
		try {
			conn = dataFactory.getConnection();
			String prdNo = p.getPrdNo();
			String prdName = p.getPrdName();
			int prdPrice = p.getPrdPrice();
			int prdStock = p.getPrdStock();
			Date prdDate = p.getPrdDate();
			String prdCompany = p.getPrdCompany();

			String query = "INSERT INTO product (prdNo, prdName, prdPrice, prdStock, prdDate, prdCompany VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, prdNo);
			pstmt.setString(2, prdName);
			pstmt.setInt(3, prdPrice);
			pstmt.setInt(4, prdStock);
			pstmt.setDate(5, new java.sql.Date(prdDate.getTime()));
			pstmt.setString(6, prdCompany);

			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductVO findProduct(String _prdNo) {
		ProductVO prdInfo = null;
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM product WHERE prdNo=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _prdNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String prdNo = rs.getString("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				int prdStock = rs.getInt("prdStock");
				Date prdDate = rs.getDate("prdDate");
				String prdCompany = rs.getString("prdCompany");

				prdInfo = new ProductVO(prdNo, prdName, prdPrice, prdStock, prdDate, prdCompany);
			}
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return prdInfo;
	}

	public void modProduct(ProductVO productVO) {
		String prdNo = productVO.getPrdNo();
		String prdName = productVO.getPrdName();
		int prdPrice = productVO.getPrdPrice();
		int prdStock = productVO.getPrdStock();
		Date prdDate = productVO.getPrdDate();
		String prdCompany = productVO.getPrdCompany();

		try {
			String query = "UPDATE product SET prdName=?, prdPrice=?, prdStock=?, prdDate=?, prdCompany=? WHERE prdNo=?";
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, prdName);
			pstmt.setInt(2, prdPrice);
			pstmt.setInt(3, prdStock);
			pstmt.setDate(4, new java.sql.Date(prdDate.getTime()));
			pstmt.setString(5, prdCompany);
			pstmt.setString(6, prdNo);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {

		}
	}

	public void delProduct(String _no) {
		try {
			String query = "DELETE FROM product WHERE prdNo=?";
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _no);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
