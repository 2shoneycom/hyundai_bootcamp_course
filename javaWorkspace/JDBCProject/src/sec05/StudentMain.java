package sec05;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// 클래스 테스트 용
		IStudentDAO idao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		ArrayList<StudentDTO> stdList = null;

		try {
			int menu = -1;
			while (menu != 7) {
				System.out.println("메뉴를 선택하시오 1. 학생 정보 입력 / 2. 전체 학생 정보 조회 / 3. 한명 학생 정보 조회 / 4. 학생 한명 정보 삭제 / 5. 학생 정보 수정 / 6. 학과명 검색 / 7. 종료");
				menu = sc.nextInt();
				sc.nextLine();
				
				StudentDTO std = null;
				String stdNo = null;
				StudentDTO dto = null;
				
				switch (menu) {
				case 1:
					// 1. 학생 정보 입력
					std = ReadWrite.getStdInfo(sc);
					
					while (std == null) {
						System.out.println("학번을 다시 입력해주세요");
						std = ReadWrite.getStdInfo(sc);
					}
					
					idao.insertStudent(std);
					
					break;
				case 2:
					// 2. 전체 학생 정보 조회
					stdList = idao.getAllStudent();
					ReadWrite.writeStdInfo(stdList);
					break;
				case 3:
					// 3. 한명 학생 정보 조회
					System.out.println("학번을 입력하세요");
					stdNo = sc.nextLine();
					dto = idao.detailStudent(stdNo);

					if (dto != null)
						ReadWrite.writeStdInfo(dto);
					break;
				case 4:
					// 4. 학생 한명 정보 삭제
					System.out.println("학번을 입력하세요");
					stdNo = sc.nextLine();
					idao.deleteStudent(stdNo);
					break;
				case 5:
					// 5. 학생 정보 수정
					System.out.println("학번을 입력하세요");
					stdNo = sc.nextLine();
					dto = idao.detailStudent(stdNo);

					if (dto != null) {
						ReadWrite.writeStdInfo(dto);
						idao.updateStudent(ReadWrite.getStdInfo(sc, stdNo));
					}
					break;
				case 6:
					// 6. 학과명 검색
					System.out.println("학과명을 입력하세요");
					String dptName = sc.nextLine();

					stdList = idao.searchStudent(dptName);

					if (!stdList.isEmpty()) {
						ReadWrite.writeStdInfo(stdList);
					}
					break;
				case 7:
					break;
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요");
					break;
				} 
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("프로그램을 종료합니다");
		}
	}

}
