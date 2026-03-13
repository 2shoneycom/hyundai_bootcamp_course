package ex1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrdouctMain {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		PrdJDBConn prdDB = new PrdJDBConn();

		try {
			con = prdDB.getConnection();	// DB 연결 시도
			stmt = con.createStatement();	// statement 객체 생성
			String sql = "SELECT * FROM prd ORDER BY prdNo";
			
			rs = stmt.executeQuery(sql); // sql 실행 및 결과 반환
			
			while (rs.next()) {
				String prdNo = rs.getString(1);
				String prdName = rs.getString(2);
				int prdPrice = rs.getInt(3);
				String prdMaker = rs.getString(4);
				String prdColor = rs.getString(5);
				int ctgNo = rs.getInt(6);
				
				System.out.println(prdNo + "\t\t" + prdName + "\t\t" + prdPrice + "\t\t" + prdMaker + "\t\t" + prdColor + "\t\t" + ctgNo);
			}
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
