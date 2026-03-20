package sec05;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductBindingServlet
 */
@WebServlet("/prdBinding")
public class ProductBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVo vo1 = new ProductVo("001", "아이폰", 190, "Apple");
		ProductVo vo2 = new ProductVo("002", "갤럭시", 200, "Samsung");
		ProductVo vo3 = new ProductVo("003", "gram", 250, "LG");
		
		ArrayList<ProductVo> prdList = new ArrayList<ProductVo>();
		
		prdList.add(vo1);
		prdList.add(vo2);
		prdList.add(vo3);
		
		request.setAttribute("prdList", prdList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("prdView");
		dispatch.forward(request, response);
	}

}
