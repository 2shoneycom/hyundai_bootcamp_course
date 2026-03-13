package sec06;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDAO implements IClientDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ClientDAO() {
		con = DBConnect.getConnection();
	}

	@Override
	public void insertClient(ClientDTO dto) {
		// 회원 등록
		String sql = "INSERT INTO client VALUES(?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getClientNo());
			pstmt.setString(2, dto.getClientName());
			pstmt.setString(3, dto.getClientPhone());
			pstmt.setString(4, dto.getClientAddress());
			pstmt.setDate(5, new java.sql.Date(dto.getClientBirth().getTime()));
			pstmt.setString(6, dto.getClientHobby());
			pstmt.setString(7, dto.getClientGender());
			pstmt.setString(8, dto.getClientPassword());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("회원 등록 성공!");
			}
			
		} catch (Exception e) {
			System.out.println("회원 등록 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public ArrayList<ClientDTO> getAllClient() {
		// 전체 회원 조회
		ArrayList<ClientDTO> clientList = null;
		
		String sql = "SELECT * FROM client ORDER BY clientNo";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String clientNo = rs.getString(1);
				String clientName = rs.getString(2);
				String clientPhone = rs.getString(3);
				String clientAddress = rs.getString(4);
				Date clientBirth = rs.getDate(5);
				String clientHobby = rs.getString(6);
				String clientGender = rs.getString(7);
				String clientPassword = rs.getString(8);
				
				clientList.add(new ClientDTO(clientNo, clientName, clientPhone, clientAddress, clientBirth, clientHobby, clientGender, clientPassword));
			}
			
		} catch (Exception e) {
			System.out.println("전체 회원 조회 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}

		return clientList;
	}

	@Override
	public void updateClient(ClientDTO dto) {
		// 회원 정보 수정
		String sql = "UPDATE client "
				+ "SET clientName=?, clientPhone=?, clientAddress=?, clientBirth=?, "
				+ "clientHobby=?, clientGender=?, clientPassword=? "
				+ "WHERE clientNo=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getClientName());
			pstmt.setString(2, dto.getClientPhone());
			pstmt.setString(3, dto.getClientAddress());
			pstmt.setDate(4, new java.sql.Date(dto.getClientBirth().getTime()));
			pstmt.setString(5, dto.getClientHobby());
			pstmt.setString(6, dto.getClientGender());
			pstmt.setString(7, dto.getClientPassword());
			pstmt.setString(8, dto.getClientNo());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("회원 정보(" + dto.getClientNo() + ") 수정 성공!");
			}
			else {
				System.out.println("회원 정보(" + dto.getClientNo() + ") 수정 실패!");
			}
			
		} catch (Exception e) {
			System.out.println("회원 정보 수정 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public void deleteClient(String clientNo) {
		// 회원 정보 삭제
		String sql = "DELETE FROM client WHERE clientNo=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clientNo);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("회원 정보(" + clientNo + ") 삭제 성공!");
			}
			else {
				System.out.println("회원 정보(" + clientNo + ") 삭제 실패!");
			}

		} catch (Exception e) {
			System.out.println("회원 정보 삭제 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}

	}

	@Override
	public boolean login(String clientName, String clientPassword) {
		// 로그인 (로그인 성공 여부 반환)
		String sql = "SELECT * FROM client WHERE clientName=? AND clientPassword=?";
		
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clientName);
			pstmt.setString(2, clientPassword);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				res = true; // 로그인 성공
			}
			else {
				res = false;
			}

		} catch (Exception e) {
			System.out.println("로그인 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}

		return res;
	}

}
