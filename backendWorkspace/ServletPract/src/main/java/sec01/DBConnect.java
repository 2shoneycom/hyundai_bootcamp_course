package sec01;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static DBConnect instance = new DBConnect();
	
	private DBConnect() {}
	
	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:29889:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";

			con = DriverManager.getConnection(url, user, pwd);

			if (con != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}

		return con;
	}
}
