package namoo.jdbc;

import java.sql.SQLException;

public class StudentAPP {

	public static void main(String[] args) {
		try {
			StudentDB studentDB = new StudentDB();
			Student student = new Student();
			student.setName("누렁이");
			student.setEnglish(100);
			student.setKorean(100);
			student.setKorean(100);
			
			studentDB.create(student);
			
		} catch (SQLException e) {
			System.err.println("에뤄봘생");
		}

	}

}
