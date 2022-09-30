package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContextUserServlet에서 정보를 공유하고, 여기서 그 정보를 얻어가는 test
 * @author Lee KyuHeon
 *
 */

@WebServlet("/container2")
public class ServletContextUserServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Get해올때마다 얻어오고 싶다면 doGet메서드 안에서
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		ServletContext contxt2 = getServletContext();
		
		String message = (String)contxt2.getAttribute("message"); //key는 String, value는 Object이기때문에 DownCasting
		
		out.println("<h2>"+message+"</h2>");
		

		//web.xml에 등록된 초기 파라미터 읽기
		String description = contxt2.getInitParameter("bts");
		
		out.println("<h2>"+description+"</h2>");
		
	}

}
