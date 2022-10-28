package namoo.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//API방식 서비스: 데이터만 내려다주는 방식
@WebServlet("/receive")
public class PostRecieveController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(id+","+passwd);
	}

}
