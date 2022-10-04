package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/view-cart")
public class HttpSessionUseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Get해올때마다 얻어오고 싶다면 doGet메서드 안에서
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		//접속 브라우저의 상태정보 유지(저장)을 위해 HttpSession 생성
		//만들어져 있는 세션을 반환받음
		HttpSession session = request.getSession();
		
		System.out.println(session.isNew());
		
		String item = (String) session.getAttribute("item");
		String user1 = (String)session.getAttribute("user1");
		
		out.println("<h2>카트에 담긴 상품 이름: "+item+"</h2>");
		out.println("<h2>고객이름: "+user1+"</h2>");
		out.println("<a href='delete-cart'>카트 비우기</a>");
		
	}

}
