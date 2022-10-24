package namoo.yorizori.cookbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.common.web.YzruntimeException;
import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yoroziri.cookbook.service.CookbookService;

/**
 * 요리책 등록 화면 및 등록 처리 브라우저 요청 처리 서블릿 컨트롤러
 */
@WebServlet("/cookbook/register.do")
public class CookbookFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//등록 화면 처리
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		  Cookie[] cookies = request.getCookies();
		  String loginId = null;
		  if(cookies != null) {
			  for (Cookie cookie : cookies) {
				  if(cookie.getName().equalsIgnoreCase("loginid")) {
					  loginId = cookie.getValue();
				  }
			  }
		  }
		  
		  //로그인을 하지않은 상태일 경우와 했을 경우
		  if(loginId == null) {
			  //로그인 되지 않은 사용자가 화면을 요청하면 예욀르 발생시킨다.
			  	// => 로그인 한 후에 이전에 보던 페이지로 보내야하기 때문에
			  		//=> 즉 예외 객체는 이전의 페이지로 보내야하기 때문에, 그 정보를 저장해놓기 위해
			  
			  //urlHeader에 같이 전달되는 이전 페이지의 정보는 Header에 referer라는 이름으로 전달된다.
//			  String referer = request.getHeader("referer");
			  
			  throw new YzruntimeException("요리책 등록을 위해서는 로그인이 필요합니다.","/user/loginform.do");
		  }else {
			  request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookForm.jsp").forward(request, response); 		  
		  }
	  	  
	  }
	  
		//등록 처리
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

		  String bookname = request.getParameter("bookname");
		  String bookdesc = request.getParameter("bookdesc");
		  String authorid = request.getParameter("authorid");
		  
		  Cookbook cookbook = new Cookbook();
		  cookbook.setBookName(bookname);
		  cookbook.setBookDesc(bookdesc);
		  cookbook.setAuthorId(authorid);
		  System.out.println(bookname);

		 CookbookService service =  ServiceFactoryImpl.getInstance().getCookbookService();
		 service.registerCookbook(cookbook);
		 //임시적으로
		 response.sendRedirect("/");
		  
	  }
	 
	 

}
