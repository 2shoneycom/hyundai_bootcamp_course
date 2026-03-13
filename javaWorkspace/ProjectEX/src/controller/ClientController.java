package controller;

import model.ClientDAO;
import model.ClientDTO;
import view.ResultView;

public class ClientController {
	private static ClientController instance = new ClientController();
	ClientDAO dao = new ClientDAO();
	
	private ClientController() {}
	
	public static ClientController getInstance() {
		return instance;
	}
	
	public boolean login(String no, String password) {
		try {
			ClientDTO dto = new ClientDTO();
			dto.setClientNo(no);
			dto.setClientPassword(password);
			return dao.login(dto);
		} catch(Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("로그인 중 오류 발생");
		}
		return false;
	}
}
