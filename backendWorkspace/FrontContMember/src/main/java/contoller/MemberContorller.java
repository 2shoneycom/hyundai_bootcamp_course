package contoller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

// FrontContMember/member/insert
// FrontContMember/member/update
// FrontContMember/member/delete
@WebServlet("/member/*")
public class MemberContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO = null;
	
	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	// doHandle로 넘어온 요청은 /member/ 요청 문자열
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // forward 시킬 location 저장할 변수
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 요청 정보 확인
		String action = request.getPathInfo(); // 서블릿에 전달된 경로만 반환함
		
		// /members || /members/listMembers.do
		if (action == null || action.equals("/listMembers.do")) {
			// 전체 회원 조회
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage="/listMembers.jsp"; // viewPage
			
		} else if (action.equals("/productForm.do")) {
			// 상품 등록 폼 응답
			nextPage = "/productForm.jsp";
			
		} else if (action.equals("/addProduct.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			String prdNo = request.getParameter("prdNo");
			String prdName = request.getParameter("prdName");
			int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
			int prdStock = Integer.parseInt(request.getParameter("prdStock"));
			Date prdDate = request.getParameter("prdDate");
			String prdCompany = request.getParameter("prdCompany");
			
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			request.setAttribute("msg", "add");
			nextPage = "/member/listMembers.do";
			
		} else if (action.equals("/modMemberForm.do")) {
			// 수정이므로 기존 입력 데이터 검색 필요
			String id = request.getParameter("id");
			MemberVO memInfo = memberDAO.findMember(id);
			request.setAttribute("memInfo", memInfo);
			nextPage="/modMemberForm.jsp";
			
		} else if (action.equals("/modMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.modMember(memberVO);
			request.setAttribute("msg", "mod");
			nextPage = "/member/listMembers.do";
			
		} else if (action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "del");
			nextPage = "/member/listMembers.do";
			
		} else { // *.do 요청 없으면
			// 전체 회원 정보 조회
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("msg", "del");
			
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	} 
}
