package sec03;

import java.sql.Connection;
import java.sql.Statement;

import sec05.DBConnect;

public class CRUDTest {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		DBConnect dbCon = new DBConnect();
		
		try {
			con = dbCon.getConnection();
			stmt = con.createStatement();
			
			// INSERT 구문
			String sql = "INSERT INTO book VALUES('100', '자바', '김바로', 10000, '2021-03-01', 5, '2')";

			// INSERT 등의 쿼리는 데이터 삽입 후 실행 종료 (executeQuery 실행 불가)
			// INSERT / UPDATE / DELETE 질의 -> executeUpdate()
			int tmpResult = stmt.executeUpdate(sql);
			
			if (tmpResult == 1) {
				System.out.print("인서트 성공");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
