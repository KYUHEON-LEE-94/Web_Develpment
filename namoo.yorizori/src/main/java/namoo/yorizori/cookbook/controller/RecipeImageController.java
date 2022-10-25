package namoo.yorizori.cookbook.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/recipe/image.do")
public class RecipeImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//이미지를 특정 위치에 등록했기 때문에, 그 위치에서 이미지를 받아오는 서블릿
		
// /recipe/image.do?recipeId=? 를 받아온다.
		String recipeId = request.getParameter("recipeid");
//		DB에서 읽어왔다고 가정. recipe  테이블에서 파일이름과 컨텐츠 타입 읽어오기
		String fileName = "sample.jpg";
		String contentType = "image/jpeg";
		
		response.setContentType(contentType);
		FileInputStream in = null;
		OutputStream out = null;
		
		try {
			File file = new File("D:/웹개발_이규헌/workspace/namoo.yorizori/upload-img/" + fileName);
			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count=in.read(buffer)) != -1) {
				out.write(buffer, 0, count);			
			}
		}finally {
			if(out != null) out.close();
			if(in != null) in.close();
		}
	}
}
