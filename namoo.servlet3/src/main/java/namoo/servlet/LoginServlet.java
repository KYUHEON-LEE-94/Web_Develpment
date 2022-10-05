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

//로그아웃 처리
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginId = null;
		// 요청 메시지의 쿠키 확인
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equalsIgnoreCase("loginId")) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					break;
				}
			}
		}
		resp.sendRedirect("/index");
	}

	// 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");

		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String saveid = request.getParameter("saveid");

		// 추후 DB 회원 여부 검색이 필요
		// 사용자 아이디가 ~~일때만 회원이라 가정

		// 회원일 경우
		if (userid.equalsIgnoreCase("bangry")) {
			Cookie loginIdCookie = new Cookie("loginId", "bangry");	
			Cookie saveIdCookie =null; 
			response.addCookie(loginIdCookie);
			
			//아이디저장을 체크했다면
			if(saveid != null) {
				saveIdCookie = new Cookie("saveId", "bangry");
				saveIdCookie.setMaxAge(60*60*24*30); //1달 파일 저장
				response.addCookie(saveIdCookie);
			}
			
			response.sendRedirect("/index");
		} else {
			// 회원이 아닐 경우
			out.println("<script>");
			out.println("alert('아이디 다시 확인해봐')");
			out.println("history.back()");
			out.println("</script>");
		}

	}

}
