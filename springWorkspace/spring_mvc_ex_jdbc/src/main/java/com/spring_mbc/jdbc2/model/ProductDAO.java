package com.spring_mbc.jdbc2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_mbc.jdbc2.dto.ProductDTO;

@Repository
public class ProductDAO {
	private DataSource dataFactory;

	@Autowired
	public ProductDAO(DataSource dataSource) {
		try {
			this.dataFactory = dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProductDTO> productSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<ProductDTO> prdList = new ArrayList<ProductDTO>();

		try {
			con = dataFactory.getConnection();

			String sql = "SELECT * FROM prd";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int prdNo = rs.getInt("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				String prdMaker = rs.getString("prdMaker");
				String prdColo = rs.getString("prdColo");
				int ctgNo = rs.getInt("ctgNo");
				
				ProductDTO dto = new ProductDTO();
				dto.setPrdNo(prdNo);
				dto.setPrdName(prdName);
				dto.setPrdPrice(prdPrice);
				dto.setPrdMaker(prdMaker);
				dto.setPrdColo(prdColo);
				dto.setCtgNo(ctgNo);
				
				prdList.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prdList;
	}
}
