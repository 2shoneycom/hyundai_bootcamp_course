package sec01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberCheck")
public class memberCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		MemberVO vo = dao.memberSearch(id, pwd);
		
		ArrayList<MemberVO> memList = new ArrayList(); // MemberViewServlet 에 일관되게끔 일부러 ArrayList 사용
		memList.add(vo);
		request.setAttribute("memList", memList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("memberView");
		dispatch.forward(request, response);
	}

}
