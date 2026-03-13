package sec05;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
	// 개발코드 (메인, 컨트롤러)에서 필요 입출력 기능을 구현하는 클래스
	// static 으로 구성

	// 1. 학생 한 명 정보 입력 (insert/update)받아 DTO에 저장 후 반환
	public static StudentDTO getStdInfo(Scanner sc) {
		StudentDTO dto = null;
		IStudentDAO idao = null;

		try {
			idao = new StudentDAO();
			
			// 학생 데이터 입력
			System.out.println("학생 정보 등록");
			System.out.print("학번 입력 : ");
			String stdNo = sc.nextLine();
			
			boolean res = idao.searchStudentNo(stdNo);
			if (res) {
				System.out.print("성명 입력 : ");
				String stdName = sc.nextLine();

				System.out.print("학년 입력 : ");
				int stdYear = sc.nextInt();
				sc.nextLine(); // 개행 문자 처리

				System.out.print("주소 입력 : ");
				String stdAddress = sc.nextLine();

				System.out.print("생년월일 입력 : ");
				String stdBirthday = sc.nextLine();
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
				Date date = fm.parse(stdBirthday); // String -> date 타입 변경 메소드

				System.out.print("학과번호 입력 : ");
				String dptNo = sc.nextLine();

				dto = new StudentDTO(stdNo, stdName, stdYear, stdAddress, date, dptNo);
			}
			else {
				System.out.println("이미 존재하는 학번입니다"); 
			}
			
		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
			return null;
		}

		return dto;
	}

	// update용, 학번은 입력받지 않음
	public static StudentDTO getStdInfo(Scanner sc, String stdNo) {
		StudentDTO dto = null;

		try {
			// 학생 데이터 입력
			System.out.println("학생 정보 수정");

			System.out.print("성명 입력 : ");
			String stdName = sc.nextLine();

			System.out.print("학년 입력 : ");
			int stdYear = sc.nextInt();
			sc.nextLine(); // 개행 문자 처리

			System.out.print("주소 입력 : ");
			String stdAddress = sc.nextLine();

			System.out.print("생년월일 입력 : ");
			String stdBirthday = sc.nextLine();
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			Date date = fm.parse(stdBirthday); // String -> date 타입 변경 메소드

			System.out.print("학과번호 입력 : ");
			String dptNo = sc.nextLine();

			dto = new StudentDTO(stdNo, stdName, stdYear, stdAddress, date, dptNo);
		} catch (Exception e) {
			System.out.println("입력 오류");
			e.printStackTrace();
			return null;
		}

		return dto;
	}

	// 2. 학생 한명 정보 출력
	public static void writeStdInfo(StudentDTO dto) {
		// 제목 출력
		System.out.println("----- 전체 학생 정보 조회 ------");
		System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %5s\n", "학번", "성명", "학년", "주소", "출생일", "학과번호");

		// 정보 추출
		String stdNo = dto.getStdNo();
		String stdName = dto.getStdName();
		int stdYear = dto.getStdYear();
		String stdAddress = dto.getStdAddress();
		Date stdBirthday = dto.getStdBirth();
		String dptNo = dto.getDptNo();

		// 출력
		System.out.format("%-10s\t %-10s\t %-4d %-20s \t%13s %5s\n", stdNo, stdName, stdYear, stdAddress, stdBirthday,
				dptNo);
	}

	// 3. 학생 여러명 정보 출력
	public static void writeStdInfo(ArrayList<StudentDTO> stdList) {
		// 제목 출력
		System.out.println("----- 전체 학생 정보 조회 ------");
		System.out.format("%-10s\t %-10s\t %-4s %-20s \t%13s %5s\n", "학번", "성명", "학년", "주소", "출생일", "학과번호");

		for (StudentDTO dto : stdList) {
			// 정보 추출
			String stdNo = dto.getStdNo();
			String stdName = dto.getStdName();
			int stdYear = dto.getStdYear();
			String stdAddress = dto.getStdAddress();
			Date stdBirthday = dto.getStdBirth();
			String dptNo = dto.getDptNo();

			// 출력
			System.out.format("%-10s\t %-10s\t %-4d %-20s \t%13s %5s\n", stdNo, stdName, stdYear, stdAddress,
					stdBirthday, dptNo);
		}
	}
}
