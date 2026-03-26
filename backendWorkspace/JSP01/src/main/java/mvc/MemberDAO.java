package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {
	DBConnect dbCon = new DBConnect();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
	
	public ArrayList<MemberDTO> selectMember() {
		try {
			con = dbCon.getCon();
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
