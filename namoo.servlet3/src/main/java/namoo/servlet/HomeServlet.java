package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/index")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId = null;
		String saveid = "";
		// 요청 메시지의 쿠키 확인
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equalsIgnoreCase("loginId")) {
					loginId = cookie.getValue();
				}
				if (cookieName.equalsIgnoreCase("saveId")) {
					saveid = cookie.getValue();
				}
			}
		}

		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿 홈페이지</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<form action='login' method='post'>");
		if (loginId == null) {
			if(saveid.equals("")) {
				out.println("<input type='checkbox' name='saveid'> 아이디 저장");				
			}else {
				out.println("<input type='checkbox' name='saveid' checked> 아이디 저장");		
			}
			out.println("<input type='text' name='userid' value='"+saveid+"' placeholder='아이디'>");
			out.println("<input type='password' name='pwd' placeholder='비밀번호'>");
			out.println("<button type='submit' value='로그인'>로그인</button>");
		} else {
			out.println("<span>" + loginId + "님 행복한 하루 되세요<span>");
			//href는 doget방식
			out.println("<a href='/login'>로그아웃<a>");

		}
		out.println("</form>");

		out.println("<h2>서블릿 연습 사이트입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
