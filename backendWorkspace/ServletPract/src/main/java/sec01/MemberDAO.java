package sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {
	public boolean memberInsert(MemberVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnect.instance.getConnection();
			
			String query = "INSERT INTO member2 VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(5, vo.getEmail());
			pstmt.setDate(4, new java.sql.Date(vo.getMemJoinDate().getTime()));
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				return true;
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public MemberVO memberSearch(String id, String pwd) {
		MemberVO resultVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnect.instance.getConnection();
			
			String query = "SELECT * FROM member2 WHERE memID=? AND memPWD=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String memid = rs.getString("memId");
				String mempwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				String email = rs.getString("memEmail");
				Date joinDate = rs.getDate("memJoinDate");
				
				resultVO = new MemberVO(memid, mempwd, name, email, joinDate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultVO;
	}
	
	public ArrayList<MemberVO> memberSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			con = DBConnect.instance.getConnection();
			
			String query = "SELECT * FROM member2";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("memId");
				String pwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				String email = rs.getString("memEmail");
				Date joinDate = rs.getDate("memJoinDate");
				
				MemberVO vo = new MemberVO(id, pwd, name, email, joinDate);
				memList.add(vo);
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
		
		return memList;
	}
}
