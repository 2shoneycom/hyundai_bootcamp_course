package ex2;

import java.sql.Connection;
import java.sql.DriverManager;

public class bookJDBConn {
	public Connection getConnection() {
		Connection con = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:29889:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd);
			
			if (con != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패"); 
			}
			return con;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
