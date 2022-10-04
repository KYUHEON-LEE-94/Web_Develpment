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


@WebServlet("/container")
public class HttpSessionUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Get해올때마다 얻어오고 싶다면 doGet메서드 안에서
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//ServletContext는 ServletContainer를 의미.
		//ServletContainer안의 객체들은 Container에 의해 생성되었기 떄문에 서로 정보를 통신할 방법이 없음. 그렇기 때문에 ServletContainer자체를 생성해서 서로 통신할 방법을 마련
		ServletContext contxt = getServletContext();
		String appName = contxt.getContextPath();
		
		out.println("<h2> 공란일듯?"+appName+"</h2>");
	
		
//		서블릿간의 데이터 공유
		//container가 저장하고 있는 Map과 같이 공유하는 객체에서 각 Servlet들이 읽어간다는 개념
		contxt.setAttribute("message", "바보?");
//		response.sendRedirect("container2");
		
		//포워드(?)하는 방식
			//dispatcher 할떄는 반드시 '/' !!
		RequestDispatcher dispatcher = contxt.getRequestDispatcher("/container2");
		dispatcher.forward(request, response);
		// ->  url이 바뀌지않음!!
		
		
		
	}

}
