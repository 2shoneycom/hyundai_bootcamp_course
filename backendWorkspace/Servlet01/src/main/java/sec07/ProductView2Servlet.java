package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/prdView2")
public class ProductView2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO2> prdList = (ArrayList<ProductVO2>)request.getAttribute("prdList");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='gold'>");
		out.print("<td>상품번호</td><td>상품명</td><td>가격</td><td>회사명</td><td>삭제</td><td>수정</td>");
		out.print("</tr>");
		for (int i = 0; i < prdList.size(); i++) {
			ProductVO2 vo = prdList.get(i);
			String prdNo = vo.getPrdNo();
			String name = vo.getPrdName();
			int price = vo.getPrdPrice();
			String company = vo.getPrdCompany();
			
			// 한행씩 출력
			out.print("<tr>");
			out.printf("<td>%s</td><td>%s</td><td>%d</td><td>%s</td><td><a href='/Servlet01/prdDelete?id=%s'>삭제</a></td><td><a href='/Servlet01/prdUpdate?id=%s'>수정</a></td>", prdNo, name, price, company, prdNo, prdNo);
			out.print("</tr>");
		}
		out.print("</table>");
		out.println("</body></html>");
	}

}
