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


@WebServlet("/add-cart")
public class HttpSessionUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Get해올때마다 얻어오고 싶다면 doGet메서드 안에서
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

//		접속 브라우저의 상태정보 유지(저장)을 위해 HttpSession 생성
//		HttpSession session = request.getSession(true);
		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		
		session.setAttribute("item", "아이폰");
		session.setAttribute("user1", "강아지");
		
		//세션 공유 테스트를 위해 다른 서블릿 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-cart");
		dispatcher.forward(request, response);

		
		
	}
}
