package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/trick/include")
public class includeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Get해올때마다 얻어오고 싶다면 doGet메서드 안에서
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>현재 서블릿에서 데이터 출력</h2>");
		out.println("---------------------------<br");

		RequestDispatcher dispathcer = getServletContext().getRequestDispatcher("/hello");
		dispathcer.include(request, response);

		
	}

}
