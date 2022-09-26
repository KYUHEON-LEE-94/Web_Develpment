package namoo.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentAPP {

	public static void main(String[] args){
		try {
			StudentDB studentDB = new StudentDB();
			Student student = new Student();
			student.setName("얼룩이");
			student.setEnglish(100);
			student.setKorean(100);
			student.setKorean(100);	
			studentDB.create(student);
			
			StudentDao stu = JDBCDaoFactory.getInstance().getStudentDao();
			stu.create(student);
			
//			List<Student> list = studentDB.listAll();
//			for (Student student : list) {
//				System.out.println(student.toString());
//			}
			
//			List<Student> list = studentDB.search("ssn","1");
//			List<Student> list = studentDB.search("name","이");
//			System.out.println(list);
			
//			List<Map<String,Object>> empList = studentDB.listByJoin();
//			for (Map<String, Object> row : empList) {
//				System.out.println(row.get("id"));
//				System.out.println(row.get("name"));
//				System.out.println(row.get("salary"));
//				System.out.println(row.get("dname"));
//				System.out.println(row.get("city"));
//				System.out.println("-----------------------------");
//			}
			
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("에뤄봘생");
		}
		
		

	}

}
