package namoo.ajax.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//API방식 서비스: 데이터만 내려다주는 방식
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestJson = "{'id':'bang', 'name':'김기정', 'email':'fes@naver.com'}";
		String reqeustArray = "[{'id':'bang', 'name':'김기정', 'email':'fes@naver.com'},{'id':'bang2', 'name':'김기정2', 'email':'fes@naver.com2'}]";

		Gson gson = new Gson();
		User usr = gson.fromJson(requestJson, User.class);
		System.out.println(usr.toString());
		
		ArrayList<User> list = gson.fromJson(reqeustArray, new TypeToken<ArrayList<User>>() {}.getType());
		for(User u: list) {

			System.out.println(u);
		}
		
		//Gson을 이용한 직렬화
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		User user2 = new User("이뻐져라","얍!","뾰로로롱@");
		String userJson = gson2.toJson(user2);
		System.out.println("--이쁘게 출력--------");
		System.out.println(userJson);
		
		String usrJsonList = gson2.toJson(list);
		System.out.println(usrJsonList);
		
	}

	
	/**
	 * Json(User)로 받고, Json(ArrayList<Usr>)로 응답
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println("---------post----------------");

		//역직렬화
//		BufferedReader in = req.getReader();
//		Gson gson = new Gson();
//		User user = gson.fromJson(in, User.class);
//		out.println(user);
		List<User> list = new ArrayList<User>();
		list.add(new User("bang3","fs","sdfes"));
		list.add(new User("bang5","fs","sdfes"));
		list.add(new User("bang4","fs","sdfes"));
		
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		String userJson = gson2.toJson(list);
		out.println(userJson);
		
		
	}
	
	
	

}
