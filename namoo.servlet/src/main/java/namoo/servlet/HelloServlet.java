package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 동적 리소스(HTML, CSS, JS)를 생성하는 서블릿
 */

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이 메서드가 자동 실행되면서 동적 HTML을 생성해서 브라우저로 응답;
		//ContentType을 세팅
		response.setContentType("text/html;");
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
		out.println("</body>");	
		out.println("</html>");
	}

}
