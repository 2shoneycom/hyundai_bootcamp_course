package sec04;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection getConnection() { // 메소드 호출되면 DB 연결 진행하고 연결된 객체 반환
		Connection con = null;

		try {
			String url = "jdbc:oracle:thin:@localhost:29889:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";

			con = DriverManager.getConnection(url, user, pwd); // DB 연결이 성공되면 Connection 객체 반환

			if (con != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
			return con;	// DBMS에 연결된 connection 객체 리턴
			
		} catch (Exception e) {
			e.printStackTrace();
			return null; // 연결 실패 시 오류 출력 후 null 리턴
		}
	}
}