package namoo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * StudentDao 구현체(JDBC API 활용)
 * @author Lee KyuHeon
 *
 */
public class JDBCStudentDao implements StudentDao {
	
	private DataSource dataSource;
	
	//생성자
	public JDBCStudentDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	//----

	@Override
	public void create(Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO students(ssn,name,korean,english,math)")
		  .append(" VALUES(stu_seq.nextval, ?,?,?,?)");
		
		try {
			conn = dataSource.getConnection();
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

	@Override
	public Student findBySsn(String ssn) throws SQLException {
		
		Student student = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ssn, name, korean, english, math").append(" FROM students").append(" WHERE ssn = ?");
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeQuery();	
			if(result.next()) {
				student = makeStudent(result);
			}
			
			
		}finally {
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return student;
	}
	
	
	

	@Override
	public List<Student> findAll() throws SQLException {
		
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ssn, name, korean, english, math").append(" FROM students");
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeQuery();		
			while(result.next()) {
				Student student = makeStudent(result);
				list.add(student);
			}
			
		}finally {
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return list;
	}

	@Override
	public List<Student> findByType(String type, String value) throws SQLException {
		
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ssn, name, korean, english, math")
		  .append(" FROM students");

// 	동적 SQL생성	
		switch (type) {
		case "ssn": sb.append(" WHERE ssn = ?"); break;
		case "name": sb.append(" WHERE name LIKE ?"); break;		
		}
				
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if(type.equalsIgnoreCase("name")) {
				value = "%"+value+"%";
				
			}
			pstmt.setString(1, value);
			result = pstmt.executeQuery();
			while(result.next()) {
				Student student = makeStudent(result);
				list.add(student);
				
			}
			
		}finally {
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return list;
	}

	public void update(Student student) throws SQLException{

	}

	
	//-=--
	private Student makeStudent(ResultSet result) throws SQLException {
		Student student = new Student();
			
			student.setSsn(result.getInt("ssn"));
			student.setName(result.getString("name"));
			student.setKorean(result.getInt("korean"));
			student.setEnglish(result.getInt("english"));
			student.setMath(result.getInt("math"));

			return student;
	}
}
