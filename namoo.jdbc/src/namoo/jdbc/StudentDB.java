package namoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 학생 성적 관련 DB 처리를 담당하는 전담 클래스
 *
 */
public class StudentDB {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";  //Oracle
	private String user = "hr";
	private String password = "hr";
	
	private Connection conn = null;
	

	public StudentDB() throws SQLException {
		conn = DriverManager.getConnection(url,user, password);
	}
	
// DB관련한 비즈니스 메소드 정의	
	public void  create(Student student) throws SQLException {
		
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO students(ssn,name,korean,english,math)")
		  .append(" VALUES(stu_seq.nextval, ?,?,?,?)");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getKorean()); 
			pstmt.setInt(3, student.getEnglish());
			pstmt.setInt(4, student.getMath());
			pstmt.executeUpdate();
		}finally {
			if(pstmt != null) pstmt.close();
		}
		
		
	}
	
	public List<Student> listAll() {
		return null;
	}
	
	public List<Student> search(String type, String value) {
		return null;
	}
	
	public void update(Student student) {
		
	}
	
}
