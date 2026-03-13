package sec06;

import java.util.ArrayList;

public interface IClientDAO {
	// 회원 등록
	public void insertClient(ClientDTO dto);
	
	// 전체 회원 조회
	public ArrayList<ClientDTO> getAllClient();
	
	// 회원 정보 수정
	public void updateClient(ClientDTO dto);
	
	// 회원 정보 삭제
	public void deleteClient(String clientNo);
	
	// 로그인 (로그인 성공 여부 반환)
	public boolean login(String clientName, String clientPassword);
}
