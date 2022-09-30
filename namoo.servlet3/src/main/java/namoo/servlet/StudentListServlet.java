package namoo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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
@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StudentDao studentDao = JDBCDaoFactory.getInstance().getStudentDao();
		List<Student> list =null;
		try {
			list = studentDao.findAll();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>학생 목록</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h2>학생 목록</h2>");
		
		out.println("<table border= '1'>");		
		
		for (Student student : list) {
			out.println("<tr>");	
			out.println("<td>"+student.getSsn()+"</td> <td>"+student.getName()+"</td> <td>"+student.getKorean()+"</td> <td>"+student.getEnglish()+"</td> <td>"+student.getMath()+"</td>");		
			out.println("</tr>");
			
		}
		
		out.println("</table>");

		out.println("</body>");	
		out.println("</html>");
	}

}
