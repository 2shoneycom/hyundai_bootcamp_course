package sec01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트 요청을 받은 컨테이너로부터 요청받아서 처리를 진행
// 진행 결과를 view로 전달하는 역할(컨트롤러에 준하는 역할)
@WebServlet("/memberSelect")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자 인지 확인
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		
		if (id.toLowerCase().equals("admin") && pwd.toLowerCase().equals("admin")) {
			// 1. 비즈니스 로직 처리 메소드 호출
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> memList = dao.memberSelect();
			
			// 바인딩
			request.setAttribute("memList", memList);
			
			// 포워딩(view) - 응답 담당할 서블릿으로 포워딩
			// 서블릿간 포워딩 진행할 때 request, response 객체 반드시 전달해야 클라이언트 정보가 유지 됨
			RequestDispatcher dispatch = request.getRequestDispatcher("memberView");
			dispatch.forward(request, response);
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.println("<h2>관리자가 아닙니다</h2>");
			out.println("</body></html>");
		}
	}
	
}
