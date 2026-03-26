package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listMember")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// 처리 모듈
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비즈니스 로직 처리하도록 제어
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memList = dao.selectMember(); 
		
		// 처리된 데이터 바인딩
		request.setAttribute("memList", memList);
		
		// 바인딩된 데이터 포함 view로 forward
		RequestDispatcher dispatch = request.getRequestDispatcher("mvcex/memberListView.jsp");
		dispatch.forward(request, response);
	}
}
