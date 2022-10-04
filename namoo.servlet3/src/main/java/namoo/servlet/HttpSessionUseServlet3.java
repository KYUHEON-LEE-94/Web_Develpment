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


@WebServlet("/delete-cart")
public class HttpSessionUseServlet3 extends HttpServlet {
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
		
		//세션에 저장된 모든 정보 삭제(장바구니 비우기)
		session.invalidate();
		
		//상품 삭제는 session.removeAttribute("key");
		
		response.sendRedirect("/view-cart");
		
	}

}
