package namoo.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// String fileStorage = “d:/.../...”;

	// 클라이언트에서 파일을 업로드하면 서버에 그 파일을 저장하는 특정 위치를 나타내는 변수
	private String fileStorage;

	// 업로드되는 파일의 사이즈를 제한하기 위한 변수 2MB
	private int limitFileSize = 2 * 1024 * 1024;

	@Override
	public void init() throws ServletException {
		fileStorage = getServletContext().getInitParameter("fileStorage");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fileName = request.getParameter("file");
		if (fileName == null || fileName.equals(""))
			return;
		//~~에서 다운로드 하는 경로
		String filePath = fileStorage + File.separator + fileName;
		File file = new File(filePath);

		// HTTP 버전별 브라우저 캐시 사용 않도록 응답헤더 설정
		//내가 다운로드 받는 도중에 다른 사람이 파일을 업로드해서 내용이 변경될 수도 있기 때문에 브라우저 캐시를 사용하지 않게하면서 다운로드 받을 수 있게 설정
		
		/*
		 * String httpVersion = request.getProtocol(); if
		 * (httpVersion.equals("HTTP/1.0")) { response.setDateHeader("Expires", 0);
		 * response.setHeader("Pragma", "no-cache"); } else if
		 * (httpVersion.equals("HTTP/1.1")) { response.setHeader("Cache-Control",
		 * "no-cache"); }
		 */
		response.setHeader("Cache-Control", "no-cache");
		
		// 파일 다운로드 처리를 위한 응답헤더에 마임타입 설정
		response.setContentType("application/octet-stream");
		
		//한글 파일과 같은 걸 인코딩해주기 위한 메서드사용
		fileName = URLEncoder.encode(fileName, "utf-8");
		//다운받는 파일명을 기존의 파일명으로 다운받을 수 있게 설정 ; 이걸 안하면 기존의 servlet이름으로 다운로드되어버림
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		response.setHeader("Content-Length", file.length()+"");
		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		try {
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		} finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}
}
