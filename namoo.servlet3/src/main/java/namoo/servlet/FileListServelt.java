package namoo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/files")
public class FileListServelt extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private String fileStorage;

	@Override
	public void init() throws ServletException {
		fileStorage = getServletContext().getInitParameter("fileStorage");

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("utf-8"); 
		
		File directory = new File(fileStorage);
		File[] list = directory.listFiles();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>자료실</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border= '1'>");
		int index = 0;
		for (File file : list) {
			out.println("<tr>");
			out.println("<td>"+(++index)+"</td>");
			out.println("<td>"+file.getName()+"</td>");
			out.println("<td>"+(file.length()/1024)+"</td>");
			out.println("<td><a href='/download?file="+file.getName()+"'>다운로드</a></td>");
			out.println("</tr>");				
		}
		
		out.println("</table>");
		out.println("</body>");	
		out.println("</html>");
		
	}

}
