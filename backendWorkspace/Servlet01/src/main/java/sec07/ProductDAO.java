package sec07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	public ArrayList<ProductVO2> productSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductVO2> prdList = new ArrayList<ProductVO2>();
		
		try {
			con = DBConnect.instance.getConnection();
			
			String query = "SELECT * FROM product";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("prdNo");
				String name = rs.getString("prdName");
				int price = rs.getInt("prdPrice");
				String company = rs.getString("prdCompany");
				
				ProductVO2 vo = new ProductVO2(no, name, price, company);
				prdList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return prdList;
	}
}
