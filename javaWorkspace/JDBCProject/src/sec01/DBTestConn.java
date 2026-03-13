package sec01;

import java.sql.Connection;	// dbms와 session을 연결하고 관리하는 객체
import java.sql.DriverManager; // dbms와 통신 담당

public class DBTestConn {

	public static void main(String[] args) {
		// 접속(Connection) 객체 선언
		Connection con = null;
		
		// DB연결은 외부 자원을 사용하는 것
		// 예외 처리 필요
		try {
			// 1. JDBC 드라이버 로드 (자동 로드 → 생략 가능)
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection 객체 생성 - DB 위치(URL), 계정명, 비밀번호
			// DriverManger를 통해 접속 시도 DriverManager.getConnection(url, user, pwd);
			String url = "jdbc:oracle:thin:@localhost:29889:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd); // DB 연결이 성공되면 Connection 객체 반환
			
			if (con != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
		}
		catch (Exception e) {
			e.printStackTrace(); // 오류 발생할 때까지의 과정을 추적하여 출력
		}
	}

}
