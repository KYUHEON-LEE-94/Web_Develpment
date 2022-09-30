package namoo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value = "/config") 이걸 생략하고 아래로 작성한것

@WebServlet(
		value = "/config", 
		initParams = {@WebInitParam(name = "url", value = "jdbc:xxx"),
					  @WebInitParam(name = "username", value = "hr"),
					  @WebInitParam(name = "password", value = "hr")})
public class ServletConfigUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * 한번만 로딩해오면 된다! 싶으면 init메서드안에서
     */
//	public void init(ServletConfig config) throws ServletException {
//		String url = config.getInitParameter("url");
//		String username = config.getInitParameter("username");
//		String password = config.getInitParameter("password");
//		System.out.println(url+": "+username+": "+password );
//	}

	/**
	 * Get해올때마다 얻어오고 싶다면 doGet메서드 안에서
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = getInitParameter("url");
		System.out.println(url);
		
	}

}
