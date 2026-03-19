package sec02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InputServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destory");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String emailRCV = request.getParameter("emailRcv");
		//동일한 name 속성(파라미터명)으로 여려개의 값이 전달되는 경우 배열로 받음
		String[] subject = request.getParameterValues("subject");
		
		System.out.println("아이디 : "+ user_id);
		System.out.println("비밀번호 : "+ user_pw);
		System.out.println("이메일 수신 여부 : "+ emailRCV);
		
		System.out.print("선택한 과목 : ");
		//배열 요소 출력
		for(String sub : subject) {
			System.out.print(sub + " ");
		}
		System.out.println();
	}

}







