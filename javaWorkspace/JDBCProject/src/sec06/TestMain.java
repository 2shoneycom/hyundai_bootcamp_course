package sec06;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IClientDAO icdao = new ClientDAO();
		
		System.out.println("로그인 해주세요");
		
		System.out.print("이름 입력: ");
		String clientName = sc.nextLine();
		System.out.print("비밀번호 입력: ");
		String clientPassword = sc.nextLine();
		
		if (icdao.login(clientName, clientPassword)) {
			System.out.println("로그인 성공!\n");
			
			IBookDAO ibdao = new BookDAO();	
			String bookNo = null;

			System.out.println("*******************************************");
			System.out.println("\t도서 관리 프로그램");
			
			int menu = -1;
			
			while (menu != 5) {
				System.out.println("*******************************************");
				System.out.println("\t다음 메뉴에서 선택");
				System.out.println("*******************************************");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 정보 조회");
				System.out.println("3. 도서 정보 수정");
				System.out.println("4. 도서 정보 삭제");
				System.out.println("5. 종료");
				menu = sc.nextInt(); sc.nextLine();
				
				switch (menu) {
				case 1:
					// 1. 도서 등록
					ibdao.insertBook(ReadWrite.getbookInfo(sc));
					break;
				case 2:
					// 2. 도서 정보 조회
					ReadWrite.writeBookInfo(ibdao.getAllBook());
					break;
				case 3:
					// 3. 도서 정보 수정
					System.out.println("도서 번호를 입력해주세요");
					bookNo = sc.nextLine();
					ibdao.updateBook(ReadWrite.getBookInfo(sc, bookNo));
					break;
				case 4:
					// 4. 도서 정보 삭제
					System.out.println("도서 번호를 입력해주세요");
					bookNo = sc.nextLine();
					ibdao.deleteBook(bookNo);
					break;
				case 5:
					break;
				default:
					System.out.println("잘못된 입력값입니다. 다시 선택해주세요");
					break;
				}
			}
			
		}
		else {
			System.out.println("등록되지 않은 회원입니다");
		}
	}
}
