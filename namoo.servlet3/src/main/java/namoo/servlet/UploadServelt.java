package namoo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class UploadServelt extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// String fileStorage = “d:/.../...”;

	// 클라이언트에서 파일을 업로드하면 서버에 그 파일을 저장하는 특정 위치를 나타내는 변수
	private String fileStorage;

	// 업로드되는 파일의 사이즈를 제한하기 위한 변수 2MB
	private int limitFileSize = 2 * 1024 * 1024;

	@Override
	public void init() throws ServletException {
		// 모든 서블릿에서 공통적으로 읽어가야할 필요가 있어서 servletcontext에서 해당 initparamet를 얻어옴.
		fileStorage = getServletContext().getInitParameter("fileStorage");
		String size = getServletContext().getInitParameter("limitFileSize");
		if (size != null) {
			limitFileSize = Integer.parseInt(size);
		}
	}

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.setCharacterEncoding("utf-8"); String writer =
	 * request.getParameter("writer"); System.out.println("Writer : " + writer);
	 * String file = request.getParameter("upfile"); System.out.println("File : " +
	 * file);
	 * 
	 * // 서블릿 API를 이용하여 업로드 파일 데이터 읽기 InputStream in = request.getInputStream();
	 * byte[] buffer = new byte[1024]; int count = 0; while((count=in.read(buffer))
	 * != -1){ String data = new String(buffer, 0, count); System.out.println(data);
	 * } in.close();
	 * 
	 * }
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// FileUpload API 활용
		File storageDir = new File(fileStorage);
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		
		// 파일 저장 위치
		fileItemFactory.setRepository(storageDir);
		
		// 파일 사이즈 제한
		fileItemFactory.setSizeThreshold(limitFileSize);
		
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for (FileItem item : items) {
				//Form데이터
				if (item.isFormField()) {
					System.out.println("파라메터 이름 : " + item.getFieldName());
					System.out.println("파라메터 값 : " + item.getString("utf-8"));
					//업로드된 파일
				} else {
					System.out.println("파라메터 이름 : " + item.getFieldName());
					System.out.println("파일명 : " + item.getName());
					System.out.println("파일사이즈 : " + item.getSize());
					System.out.println("===================================");
					//0보다 크다는 것 = 업로드된 파일이 있다.
					if (item.getSize() > 0) {
						// File.separator는 프로그램이 실행 중인 OS에 해당하는 구분자를 리턴합니다.
						String separator = File.separator;
						//파일의 '이름만'을 얻기 위한 파싱 절차.
						int index = item.getName().lastIndexOf(separator);
						String fileName = item.getName().substring(index + 1);
						//fileStorage = 저장하고자 하는 파일 위치 /+ File.separator = 현재 OS의 구분자 /+ fileName = 업로드한 파일 이름  -> 경로 설정 완료
						File uploadFile = new File(fileStorage + File.separator + fileName);
						
						//파일 저장
						item.write(uploadFile);
					}
				}
			}

			out.println("<html>");
			out.println("<body>");
			out.println("<h2>파일 업로드 완료!</h2>");
			out.println("</body>");
			out.println("</html>");
			// response.sendRedirect("/파일목록처리 서블릿");
		} catch (Exception e) {
			e.printStackTrace();
			new ServletException(e.getMessage());
		}
	}

}
