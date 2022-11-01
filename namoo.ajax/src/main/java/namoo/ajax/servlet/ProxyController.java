package namoo.ajax.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/***
 * REST API 방식의 서비스
 * @author Lee KyuHeon
 *
 */

// 규정에 따라 소문자+복수형
@WebServlet("/movies")
public class ProxyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**
 * Proxy Servlet For YTS moivieList
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/josn; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		URL url = new URL("https://yts.torrentbay.to/api/v2/list_movies.json");
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		
		
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder();
		
		//브라우저 상태값 받아오는 변수
		int status = connection.getResponseCode();
		
		String txt = null;
		
		//브라우저 수신이 비정상일 경우
		if(status> 299) {
			in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while((txt=in.readLine()) != null) {
				sb.append(txt);
			}
			
			//정상 수신일 경우
		}else {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((txt=in.readLine()) != null) {
				sb.append(txt);
			}
		}
		in.close();
		
		/**
		 * 비정상적인 값을 읽어왔을 경우 OR
		 * 정상적인 값을 읽어왔을 경우(JSON)를 StringBuilder에 append 해놓았기 때문에
		 * 해당 값을 JS Fecth API가 읽을 수 있도록 내보내줌
		 */
		out.println(sb.toString());
		
	}

	


	
	
	

}
