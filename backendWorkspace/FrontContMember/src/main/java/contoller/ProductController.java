package contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;
import model.ProductVO;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// MemberDAO memberDAO = null;
	ProductDAO productDAO = null;
	
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // forward 시킬 location 저장할 변수
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 요청 정보 확인
		String action = request.getPathInfo(); // 서블릿에 전달된 경로만 반환함
		
		
		if (action == null || action.equals("/listProducts.do")) {
			// 전체 상품 조회
			List<ProductVO> productList = productDAO.listProducts();
			request.setAttribute("productList", productList);
			nextPage="/listProducts.jsp"; // viewPage
			
		} else if (action.equals("/memberForm.do")) {
			// 회원 가입 폼 응답
			nextPage = "/memberForm.jsp";
			
		} else if (action.equals("/addMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
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
