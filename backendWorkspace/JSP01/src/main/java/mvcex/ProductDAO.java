package mvcex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ProductDAO {
	DBConnect dbCon = new DBConnect();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<ProductDTO> prdList = new ArrayList<ProductDTO>();
	
	public ArrayList<ProductDTO> selectProduct() {
		try {
			con = dbCon.getCon();
			String sql = "SELECT * FROM product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String prdNo = rs.getString("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				int prdStock = rs.getInt("prdStock");
				Date prdDate = rs.getDate("prdDate");
				String prdCompany = rs.getString("prdCompany");
				
				ProductDTO dto = new ProductDTO(prdNo, prdName, prdPrice, prdStock, prdDate, prdCompany);
				
				prdList.add(dto);
			}
		} catch(Exception e) {
			System.out.println("상품 정보 조회 실패");
			e.printStackTrace();
		}
		
		return prdList;
	}
}
