package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginRes2")
public class LoginServletResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}


	public void destroy() {
		System.out.println("destory");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//(1) 클라이언트가 전송한 파라미터 추출 후 처리
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		//(2) 클라이언트로 전송 : 응답처리
		//HttpServletResponse.setContentType() 전송되는 데이터의 종류와 결합방식을 설정
		response.setContentType("text/html;charset=utf-8");
		//브라우저로 응답하기 위한 응답출력 인스턴스 생성
		//HttpServletResponse.getWriter() : 서버 컨테이너 출력 인스턴스 반환, 반환객체 타입(PrintWriter객체)
		PrintWriter out = response.getWriter();
		
		//컨테이너로 출력(응답 데이터 구성) : 브라우저가 해석할 수 있는 형태로 출력
		out.println("<html><head></head><body>");
		out.println("아이디 : "+userId+"<br>");
		out.println("비밀번호 : "+userPw +"<br>");
		out.println("</body></html>");
		//컨테이너는 웹서버로 버퍼에 있는 출력데이터 전달 -> 웹서버 브라우저에게 전송
		//컨테이너 + 웹서버 : 톰캣(was)
	}

}




