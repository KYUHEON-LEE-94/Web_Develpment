package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.servlet.dao.StudentDao;
import namoo.servlet.dto.Student;
import namoo.servlet.factory.JDBCDaoFactory;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/students/regist")
public class StudentRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("studentnameinput");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));		
		

		Student registSudent = new Student();
		registSudent.setName(name);
		registSudent.setKorean( kor);
		registSudent.setMath(math);
		registSudent.setEnglish(eng);
		
		StudentDao studentDao = JDBCDaoFactory.getInstance().getStudentDao();
		try {
			studentDao.create(registSudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//학생 목록으로 포워드 이중 등록 발생 할 수 있다.
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/students");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/students");		
//		dispatcher.forward(request, response);
		
		//이중 등록 방지를 위해서 Redirect 방법  사용		
		response.sendRedirect("/students");
		
	}

}
