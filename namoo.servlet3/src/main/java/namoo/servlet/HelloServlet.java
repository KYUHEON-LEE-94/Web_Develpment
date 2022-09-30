package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count;
	
	public HelloServlet() {
		System.out.println("디폴트 생성자 호출됨..");
	}
	
	@Override
	//생성자의 역할처럼 초기화시켜주는 메서드
		public void init(ServletConfig config) throws ServletException {
		
			System.out.println("init(ServletConfig) 호출됨");
			count = 0;
		}
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		count++;
			System.out.println("service(HttpServletRequest req, HttpServletResponse resp)");
			super.service(req, resp);
		}
	
	@Override
	public void destroy() {
		System.out.println("서블릿 해제됨");
	}

	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request);
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String protocol = request.getProtocol();
		System.out.println(method);
		System.out.println(uri);
		System.out.println(protocol);
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String header = e.nextElement();
			String headerValue = request.getHeader(header);
			System.out.println(headerValue);
		}
		System.out.println(response);
	
		//이 메서드가 자동 실행되면서 동적 HTML을 생성해서 브라우저로 응답
				//ContentType을 세팅
				response.setContentType("text/html; charset=utf-8");
				//현재 서블릿과 웹서버와의 문자출력스트림 생성
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>처음 작성하는 servlet</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>동적 HTML 데이터 출력</h2>");
				out.println("<h2>동적 구구단 출력</h2>");
				out.println("<table border= '1'>");
				for(int i=2; i<10; i++) {
					out.println("<tr>");
					for (int j = 1; j<10; j++) {
						out.println("<td>"+i+"X"+j+" ="+(i*j)+"</td>");
						
					}
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<h1>당신은"+count+"방문자입니다.</h1>");
				out.println("</body>");	
				out.println("</html>");
	}

}
