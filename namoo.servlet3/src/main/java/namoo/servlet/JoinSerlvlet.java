package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class JoinSerlvlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	
	//doGet방식은 빠르고 이 방식으로도 정보를 받을 수 있다(200mb제한(?)). 다만, 이 방식으로하면 데이터가 QueryString방식으로 주소창에 노출되어버리기 때문에 잘 선택해야한다.
	//-> 대표적으로 네이버나 구글에서 검색해보면 Get방식으로 한걸 볼수있음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 요청 파라미터 읽기(수신) //request받는 인코딩 방식을 변경해주어야 한글도 깨지지않게 받을 수 있음
		request.setCharacterEncoding("utf-8"); 
		
		/*
		 * String name =
		 * request.getParameter("name"); String age = request.getParameter("age");
		 * String password = request.getParameter("password");
		 * 
		 * 
		 * //checkbox를 두개 다받을 수도 있다 -> 그럴 경우에는, getParameterValues메서드를 사용해해서 배열로 받아야함 //
		 * String actor = request.getParameter("actor"); String[] actors =
		 * request.getParameterValues("actor");
		 * 
		 * System.out.println("====수신한 데이터 목록====="); System.out.println(name);
		 * System.out.println(age); System.out.println(password);
		 * 
		 * //아무것도 입력하지 않고 전송하면 빈문자열(null이 아님!!)로 들어옴; //checkbox를 선택하지 않는 경우도 고려
		 * if(actors != null) { for (String string : actors) {
		 * System.out.println(string); } } //select를 여러개 입력할 수 있다는 전제하에 String[]
		 * language = request.getParameterValues("language");
		 * 
		 * if(language != null) { for (String string : language) {
		 * System.out.println(string); } }
		 */
		
		
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String paramName = e.nextElement();
			if(paramName.equalsIgnoreCase("actor") || paramName.equalsIgnoreCase("language") ) {
				String[] actors = request.getParameterValues(paramName);
				System.out.println(actors);
			}else {
				String paramtervalue = request.getParameter(paramName);
				System.out.println(paramName+"="+paramtervalue);
				
			}
			
		}
		
	}

}
