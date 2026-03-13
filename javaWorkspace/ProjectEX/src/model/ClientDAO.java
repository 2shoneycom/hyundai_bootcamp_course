package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import util.DBConnect;

public class ClientDAO implements IClientDAO {

	@Override
	public Vector<ClientDTO> getAllClient() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(ClientDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ClientDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ClientDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(ClientDTO dto) throws Exception {
		Connection con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM client WHERE clientNo=? AND clientPassword=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getClientNo());
		pstmt.setString(2, dto.getClientPassword());

		rs = pstmt.executeQuery();

		
		if (rs.next()) {
			DBConnect.close(con, pstmt, rs);
			return true;
		} else {
			DBConnect.close(con, pstmt, rs);
			return false;
		}
	}

}
