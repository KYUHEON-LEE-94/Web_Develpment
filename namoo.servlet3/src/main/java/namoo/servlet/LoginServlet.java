package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.servlet.factory.JDBCDaoFactory;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;




	//로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8"); 
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		// 추후 DB 회원 여부 검색이 필요
		// 사용자 아이디가 ~~일때만 회원이라 가정
		
		//회원일 경우
		if(userid.equalsIgnoreCase("bangry")) {
			Cookie loginIdCookie = new Cookie("loginId", "bangry");
			response.addCookie(loginIdCookie);
			response.sendRedirect("/index.html");
		}else {
			//회원이 아닐 경우
			out.println("<script>");
			out.println("alert('아이디 다시 확인해봐')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		
	}

}
