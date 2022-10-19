package namoo.yorizori.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 회원 가입 처리 결과 컨트롤러
 */
@WebServlet("/user/result.do")
public class UserResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//회원가입 화면 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당 요청을 처리하는 VIWE(Form.jsp) 포워딩
		
		request.getRequestDispatcher("/WEB-INF/views/user/result.jsp").forward(request, response);
	}

	

}
