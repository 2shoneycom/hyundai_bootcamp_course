package sec04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet06Binding
 */
@WebServlet("/first06")
public class FirstServlet06Binding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request의 setAttribute(속성명, 속성값) 이용 바인딩 처리
		// 속성값의 타입은 뭐가 들어오든지 Object 타입으로 변환됨
		request.setCharacterEncoding("utf-8");
		request.setAttribute("name", "홍길동");
		request.setAttribute("address", "서울시");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second06");
		dispatch.forward(request, response);
	}

}
