package sec01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeberView1Servlet
 */
@WebServlet("/memberView")
public class MeberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request에 저장되는 Attribute는 모두 Object 타입으로 변환 됨
		ArrayList<MemberVO> memList = (ArrayList<MemberVO>) request.getAttribute("memList");

		// 응답 데이터 생성
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>" + "<td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for (MemberVO vo: memList) {
			out.print("<tr><td>" + vo.getId() + "</td>");
			out.print("<td>" + vo.getPwd() + "</td>");
			out.print("<td>" + vo.getName() + "</td>");
			out.print("<td>" + vo.getEmail() + "</td>");
			out.print("<td>" + vo.getMemJoinDate() + "</td>");
			out.print("<td><a href='/Servlet01/memDelete?memId=" + vo.getId() + ">삭제</td></tr>");
		}
		
		out.print("</table></body></html>");
		out.close();
	}
}
