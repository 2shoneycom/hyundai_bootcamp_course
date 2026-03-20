package sec04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 비즈니스 데이터를 응답 데이터로 구성 후 응답 처리
		// (1) 전달된 바인딩 데이터 값 추출
		ArrayList<MemberVO> memList = (ArrayList<MemberVO>)request.getAttribute("memList");
		
		// (2) 응답 데이터 생성
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='gold'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>삭제</td>");
		out.print("</tr>");
		for (int i = 0; i < memList.size(); i++) {
			MemberVO vo = memList.get(i);
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			
			// 한행씩 출력
			out.print("<tr>");
			out.printf("<td>%s</td><td>%s</td><td>%s</td><td>%s</td><a href='/Servlet01/memberDelete?id=%s>삭제</a>", id, pwd, name, email, id);
			out.print("</tr>");
		}
		out.print("</table>");
		out.println("</body></html>");
	}
}
