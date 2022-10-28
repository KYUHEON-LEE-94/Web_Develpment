package namoo.ajax.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//API방식 서비스: 데이터만 내려다주는 방식
@WebServlet("/json")
public class JsonReceiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String txt = null;
		while ( (txt=in.readLine()) != null) {
			sb.append(txt);			
		}
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		
		
	}
}
