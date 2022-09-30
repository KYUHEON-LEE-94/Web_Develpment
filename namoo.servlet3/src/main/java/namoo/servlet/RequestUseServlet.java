package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/request")
public class RequestUseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//클라이언트 IP
		String ClientIP = request.getRemoteAddr();
		//어플리케이션 이름. 지금은 생략되어있기 때문에 빈문자열로 반환
		String webApplicationName = request.getContextPath();
		out.println("<h2> :"+webApplicationName+"</h2>");
		out.println("<h2>"+ClientIP+"</h2>");
		
	}

}
