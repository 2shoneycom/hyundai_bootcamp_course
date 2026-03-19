package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginRes")
public class LoginServletRes2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("loginRes init");
	}


	public void destroy() {
		System.out.println("loginRes destory");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginRes doGet 호출");
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginRes doPost 호출");
		doProcess(request, response);
	}
	
	//처리를 담당하는 메소드
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();		

		out.println("<html><head></head><body>");
		out.println("아이디 : "+userId+"<br>");
		out.println("비밀번호 : "+userPw +"<br>");
		out.println("</body></html>");
	
	}

}










