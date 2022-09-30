package namoo.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/MimeServlet")
public class MimeServlet extends HttpServlet {
	private String repository="D:/웹개발_이규헌/respository/sample.mp3";
	private String repositoryPDF="D:/웹개발_이규헌/respository/Mybatis.pdf";
	private static final long serialVersionUID = 1L;


	/**
	 * 브라우저 GET 요청이 올 때 서비스 메서드에 의해 자동 실행되는 Callback 메서드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("audio/mpeg");
//		response.setContentType("application/pdf");
//		response.setContentType("application/octet-stream");
		ServletOutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream(repository);	
		int count;
		byte[] buffer = new byte[1024];
		//-1은 파일의 끝을 의미

		while((count=in.read(buffer)) != -1) {
			out.write(buffer,0,count);
		}

		
		in.close();
		out.close();
	}

}
