package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinResServlet
 */
@WebServlet("/memberJoin")
public class JoinResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("memberJoin 요청의 init");
	}

	public void destroy() {
		System.out.println("memberJoin 요청의 destroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("memberJoin 요청의 get");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("memberJoin 요청의 post");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터값 받아오기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phonF = request.getParameter("phonF");
		String phonS = request.getParameter("phonS");
		String phonT = request.getParameter("phonT");
		String grade = request.getParameter("grade");
		String department = request.getParameter("department");
		String[] interests = request.getParameterValues("interests");
		
		String interest_list = ""; 
		for (String interest : interests) {
			interest_list += interest + " ";
		}
		
		// response 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>"
				+ "<h1>회원 가입 내용</h1><br>"
				+ "이름: " + name + "<br>"
				+ "ID: " + id + "<br>"
				+ "비밀번호: " + pw + "<br>"
				+ "휴대폰 번호: " + phonF + "-" + phonS + "-" + phonT + "<br>"
				+ "학년: " + grade + "<br>"
				+ "관심분야: " + interest_list + "<br>"
				+ "학과: " + department + "<br>"
				+ "</body></html>");
	}
}
