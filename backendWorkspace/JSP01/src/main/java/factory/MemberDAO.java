package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	// DBConnect dbCon = new DBConnect();
	private DataSource dataFactory;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
	
	// 객체 생성될 때 con 객체 할당
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			this.dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> selectMember() {
		try {
			// con = dbCon.getCon();
			con = dataFactory.getConnection(); // DBCP가 공유하는 connection 객체를 할당받게 됨
			String sql = "SELECT * FROM member2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String memId = rs.getString("memId");
				String memPwd = rs.getString("memPwd");
				String memName = rs.getString("memName");
				String memEmail = rs.getString("memEmail");
				Date memJoinDate = rs.getDate("memJoinDate");
				
				MemberDTO dto = new MemberDTO(memId, memPwd, memName, memEmail, memJoinDate); 
				
				memList.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("회원 정보 조회 실패");
			e.printStackTrace();
		}
		
		return memList;
	}
	
}
