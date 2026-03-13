package clientView;

import java.util.Scanner;

import controller.ClientController;
import model.ClientDTO;

public class ClientLogin {
	ClientController controller = ClientController.getInstance();
	
	public boolean login(Scanner sc) {
		String clientNo, clientPassword;
		
		System.out.println("\n*************************");
		System.out.println("로그인 정보 입력");
		System.out.println("***************************");
		
		System.out.print("회원번호 입력 : ");		
		clientNo = sc.nextLine();
		
		System.out.print("비밀번호 입력 : ");	
		clientPassword = sc.nextLine();
		
		return controller.login(clientNo, clientPassword);
	}
}
