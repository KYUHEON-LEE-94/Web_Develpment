package namoo.ajax.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@WebServlet("/students")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**
 * 학생 목록
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/josn; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//DB에서 SELECT(편의상 생략)
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(10,30,50,70,"개"));
		studentList.add(new Student(30,40,60,70,"소"));
		studentList.add(new Student(20,70,80,70,"양"));
		
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		String students = gson2.toJson(studentList);
		out.println(students);
		

		request.getRequestDispatcher("/studentExample.html").forward(request, response); 		

		
	}

	

/**
 * 학생 추가(CREAT)
 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println("---------post----------------");

		//역직렬화
		BufferedReader in = req.getReader();
		Gson gson = new Gson();
		Student student = gson.fromJson(in, Student.class);
		System.out.println(student.toString());
		
		//DB에 insert했다고 가정!
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("status", true);
		map.put("status", false);
		map.put("student", student);
		String result = gson.toJson(map);

		out.println(result);
		
		
	}
	
	
	

}
