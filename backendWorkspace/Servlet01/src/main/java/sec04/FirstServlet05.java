package sec04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet05
 */
@WebServlet("/first05")
public class FirstServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Dispatcher 기능을 활용한 요청(포워딩) : 클라이언트 상관없이 직접 서버를 통해 요청
		// 클라이언트는 포워딩되는 상황을 알 수 없음
		// 메소드 호출과는 다른 개념임 : request를 진행
		// A서블렛 -> 톰캣컨테이너에게 요청(Dispatch) -> 컨테이너가 request, response 객체 생성 후
		// -> B서블렛 doGet(request, response)호출
		
		String name = "홍길동"; // 한글 그냥 쓰면 오류남 파라미터 규칙에 따라 1byte 문자로 변환되어야 함
		int age = 30;
		
		// URLEncoder 객체를 활용해서 url 인코딩 진행 후 파라미터로 전송함
		String encodedName = URLEncoder.encode(name, "utf-8");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second05?name="+encodedName+"&age"+age); // dispatch 인스턴스 반환
		
		dispatch.forward(request, response); // 이 이후 코드는 진행안됨 return 처럼
	}

}
