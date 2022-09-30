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
@WebServlet("/Response")
public class ResponseUseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//클라이언트 IP
//		String ClientIP = request.getRemoteAddr();
//		String webApplicationName = request.getContextPath();
//		out.println("<h2> 웹어플리케이션 이름: "+webApplicationName+"</h2>");
//		out.println("<h2> 당신의 아이피: "+ClientIP+"</h2>");
		
		//응답코드 설정
//		response.setStatus(XHttpServletResponse.SC_NOT_FOUND); //404
		//status는 200번대 값을 사용하는것, 에러일떄는 아래를 사용
//		response.sendError(XHttpServletResponse.SC_NOT_FOUND); //404

//		게시판 글쓰기 처리 완료 후 자동으로 게시판 목록 요청하게 함(redirect)	
//		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); //302
		//Location이라는 헤더를 /hello로 바꿔줘!
//		response.setHeader("Location", "hello"); //게시판 목록
		
		//위의 과정을 한줄로 가능하게 하는 메서드
		//  /가 있다면 web application이름을 기준, /가 없다면 현재의 위치를 기준으로 요청 
		response.sendRedirect("/hello");
		
	}

}
