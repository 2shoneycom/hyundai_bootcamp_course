package sec02;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}


	public void destroy() {
		System.out.println("destory");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Enumeration<String> enu = request.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String pname = enu.nextElement();
			String[] values = request.getParameterValues(pname);
			
			for(String value:values) {
				System.out.println("parameter-name="+pname+",value="+value);
			}
		}
	}

}
