package namoo.ajax.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Cookbook 안에 recipe가 포함되어 있기 때문에 따로 분리 안함
 * 레시피 등록 처리 서블릿 컨트롤러
 */
@WebServlet("/upload")

@MultipartConfig(
		//이 파일 용량 이상일때만 임시 폴더에 파일 생성 - fileSizeThreshold
	fileSizeThreshold = 1024 * 1024 * 1, 
	maxFileSize = 1024 * 1024 * 10, 
	maxRequestSize = 1024 * 1024 * 15
)
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	/** 레시피 등록 요청 처리 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		String commnets = request.getParameter("commnets");

		
		//파일은 Part객체로 받아온다.			//name
		Part part = request.getPart("infile");
		String imgFileName = part.getSubmittedFileName();
		String contentType = part.getContentType();

		
		File file = new File("D:/웹개발_이규헌/workspace/namoo.ajax/upload-img");
		//file이 없으면 파일을 생성해라~
		if (!file.exists()) {
			file.mkdirs();
		}

		// 업로드 파일 저장
		part.write(file.getAbsolutePath()+ File.separator + imgFileName);
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("파일업로드 처리 됬다.");
		
		
		
	}
}
