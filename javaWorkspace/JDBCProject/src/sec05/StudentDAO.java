package sec05;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO implements IStudentDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StudentDTO std = null;
	ArrayList<StudentDTO> stdList = null;

	public StudentDAO() {
		con = DBConnect.getConnection();
	}

	@Override
	public void insertStudent(StudentDTO dto) {
		// 학생 정보 입력
		try {
			String sql = "insert into student values(?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getStdNo());
			pstmt.setString(2, dto.getStdName());
			pstmt.setInt(3, dto.getStdYear());
			pstmt.setString(4, dto.getStdAddress());
			pstmt.setDate(5, new java.sql.Date(dto.getStdBirth().getTime())); // 방법 1
			// pstmt.setString(5, dto.getStdBirth().toString()); // 방법 2
			pstmt.setString(6, dto.getDptNo());

			int result = pstmt.executeUpdate(); // 쿼리문 실행 (영향을 받은 행의 수 받아와서 변수에 저장)

			if (result > 0) {
				System.out.println("학생 등록 성공 !");
			}

		} catch (SQLException e) {
			System.out.println("학생 등록 실패 !");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public ArrayList<StudentDTO> getAllStudent() {
		// 전체 학생 정보 조회
		stdList = new ArrayList<StudentDTO>();

		try {
			String sql = "select * from student order by stdNo";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);
				String stdAddress = rs.getString(4);
				Date stdBirthday = rs.getDate(5);
				String dptNo = rs.getString(6);

				std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
				stdList.add(std);
			}

		} catch (SQLException e) {
			System.out.println("전체 학생 정보 조회 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}

		return stdList;
	}

	@Override
	public StudentDTO detailStudent(String stdNo) {
		// 한명 학생정보 조회
		try {
			String sql = "select * from student where stdNo = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stdNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				stdNo = rs.getString(1);
				String stdName = rs.getString(2);
				int stdYear = rs.getInt(3);
				String stdAddress = rs.getString(4);
				Date stdBirthday = rs.getDate(5);
				String dptNo = rs.getString(6);

				std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
			} else {
				System.out.println("학번에 해당하는 학생 정보가 없습니다");
			}

		} catch (Exception e) {
			System.out.println("한명 학생정보 조회 중 오류 발생");
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}

		return std;
	}

	@Override
	public void deleteStudent(String stdNo) {
		// 학생 한명 정보 삭제
		String sql = "delete from student where stdNo = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stdNo);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("학번(" + stdNo + ") 학생 정보 삭제 성공");
			} else {
				System.out.println("학번(" + stdNo + ") 학생 정보 삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public void updateStudent(StudentDTO dto) {
		// 모든 컬럼 업데이트 처리
		String sql = "update student set stdName=?, stdYear=?, " + "stdAddress=?, stdBirth=?, dptNo=? where stdNo=?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getStdName());
			pstmt.setInt(2, dto.getStdYear());
			pstmt.setString(3, dto.getStdAddress());
			pstmt.setDate(4, new java.sql.Date(dto.getStdBirth().getTime()));
			pstmt.setString(5, dto.getDptNo());
			pstmt.setString(6, dto.getStdNo());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("학번(" + dto.getStdNo() + ") 학생의 정보 수정 완료");
			} else {
				System.out.println("학번(" + dto.getStdNo() + ") 학생의 정보 수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public ArrayList<StudentDTO> searchStudent(String dptNo) {
		// 같은과 학생 검색
		stdList = new ArrayList<StudentDTO>();

		String sql = "SELECT * FROM student WHERE dptNo=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dptNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					String stdNo = rs.getString(1);
					String stdName = rs.getString(2);
					int stdYear = rs.getInt(3);
					String stdAddress = rs.getString(4);
					Date stdBirth = rs.getDate(5);
					dptNo = rs.getString(6);

					std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, dptNo);
					stdList.add(std);
				} while (rs.next()); 
			}
			else {
				System.out.println("학과의 학생 정보는 없습니다");
			}
			
		} catch (SQLException e) {
			System.out.println("같은 과 학생 검색 중 오류 발생"); 
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}

		return stdList;
	}
	
	@Override
	public ArrayList<StudentDTO> searchStudent1(String dptName) {
		// 같은과 학생 검색
		stdList = new ArrayList<StudentDTO>();

		String sql = "SELECT * "
				+ "FROM student, department "
				+ "WHERE student.dptNo = department.dptNo "
				+ "AND dptName=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dptName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					String stdNo = rs.getString(1);
					String stdName = rs.getString(2);
					int stdYear = rs.getInt(3);
					String stdAddress = rs.getString(4);
					Date stdBirth = rs.getDate(5);
					String dptNo = rs.getString(6);

					std = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, dptNo);
					stdList.add(std);
				} while (rs.next()); 
			}
			else {
				System.out.println("학과의 학생 정보는 없습니다");
			}
			
		} catch (SQLException e) {
			System.out.println("같은 과 학생 검색 중 오류 발생"); 
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}

		return stdList;
	}

	@Override
	public boolean searchStudentNo(String stdNo) {
		// 정보 입력 시 중복 학번 확인 용
		String sql = "SELECT * FROM student WHERE stdNo=?";
		boolean res = true;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stdNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				res = false; // 검색된 학생이 있으면 중복임 (false 반환)
			}
			else {
				res = true; // 검색된 학생이 없으면 쓸 수 있음 (true 반환)
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(pstmt, rs);
		}
		
		return res;
	}

}
