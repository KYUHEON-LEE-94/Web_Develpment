package namoo.yorizori.user.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.user.dto.User;
import namoo.yorizori.user.service.UserService;

/**
 * 회원 관련 브라우저 요청 처리 서블릿 컨트롤러입니다.
 */
@WebServlet("/user/regist.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//회원가입 화면 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당 요청을 처리하는 VIWE(Form.jsp) 포워딩
		
		
		request.getRequestDispatcher("/WEB-INF/views/user/form.jsp").forward(request, response);
	}

	//회원 가입 DB처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩을 위하여
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");		
		String name = request.getParameter("name");		
		String email = request.getParameter("email");
		System.out.println(email);
		
		User user = new User();
		user.setId(id);
		user.setPasswd(passwd);
		user.setName(name);
		user.setEmail(email);
		
		//DB users 테이블에 INSERT
		UserService userSevService = ServiceFactoryImpl.getInstance().getUserService();
		userSevService.registUser(user);
		
		//가입을 완료하면 result.jsp로 보내야하지만, 포워드 방식은 이중 등록 우려가 있어서 사용 불가능
			//sendRedirect를 써야하지만 해당 서블렛은 form.jsp서블릿이기 떄문에 다른 서블릿을 생성해서 그쪽으로 redirect
		
		//한글을 써야하기 때문에 인코딩을 한번 해줌
		name = URLEncoder.encode(name, "utf-8");
		response.sendRedirect("/user/result.do?id="+id+"&name="+name+"&email="+email);
	}

}
