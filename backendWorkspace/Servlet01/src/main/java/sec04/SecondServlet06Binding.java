package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second06")
public class SecondServlet06Binding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second06의 doGet 호출");
		
		// Object -> String
		String name = request.getAttribute("name").toString();
		String age = request.getAttribute("address").toString();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("name: " + name + "<br>");
		out.println("address: " + age + "<br>");
		out.println("dispatch 이용한 포워딩, 포워딩 되었지만 url은 동일합니다. 바인딩을 통한 데이터를 전송");
		out.println("</body></html>");
	}

}
