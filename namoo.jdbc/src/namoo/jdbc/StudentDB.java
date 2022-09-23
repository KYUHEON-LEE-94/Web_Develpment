package namoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 학생 성적 관련 DB 처리를 담당하는 전담 클래스
 *
 */
public class StudentDB {

	
// DB관련한 비즈니스 메소드 정의	
	public void  create(Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO students(ssn,name,korean,english,math)")
		  .append(" VALUES(stu_seq.nextval, ?,?,?,?)");
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
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
	
	public List<Student> listAll() throws SQLException {
		List<Student> list;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ssn, name, korean, english, math").append(" FROM students");
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeQuery();		
			list = makeStudent(result);
			
		}finally {
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return list;
	}
	
	
	
	public List<Student> search(String type, String value) throws SQLException {
		List<Student> list;
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
			conn = ConnectionFactory.getInstance().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if(type.equalsIgnoreCase("name")) {
				value = "%"+value+"%";
				
			}
			pstmt.setString(1, value);
			result = pstmt.executeQuery();
			list = makeStudent(result);
			
		}finally {
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return list;
	}
	
	private List<Student> makeStudent(ResultSet result) throws SQLException {
		List<Student> list = new ArrayList<Student>();
		while(result.next()) {
			Student student = new Student();
			int ssn = result.getInt("ssn");
			int korean = result.getInt("korean");
			int english = result.getInt("english");
			int math = result.getInt("math");
			String name = result.getString("name");
			student.setSsn(ssn);
			student.setName(name);
			student.setKorean(korean);
			student.setEnglish(english);
			student.setMath(math);
			list.add(student);
		}
		return list;
	}
	
	//테이블 조인을 이용하여 리스트 목록을 가져올떄
	public List<Map<String, Object>> listByJoin() throws SQLException{
		//Map을 arrayList 배열에 넣어준다.
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT e.employee_id id,")
		.append(" e.last_name name,")
		.append(" e.salary salary,")
		.append(" d.department_name dname,")
		.append(" l.city city")
		.append(" FROM employees e")
		.append(" JOIN departments d ")
		.append(" ON e.department_id = d.department_id")
		.append(" JOIN locations   l ")
		.append(" ON d.location_id = l.location_id");
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeQuery();
			
			while(result.next()) {
				//각 Alias를 매핑해주고
				int id = result.getInt("id");
				int salary = result.getInt("salary");
				String name = result.getString("name");
				String dname = result.getString("dname");
				String city = result.getString("city");
				//매핑해준 변수를 Map에 키와 밸류값으로 입력해준다.
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", id);
				row.put("salary", salary);
				row.put("name", name);
				row.put("dname", dname);
				row.put("city", city);
				//입력된 Map을 list에 등록해준다.
				list.add(row);
				
			}
		}finally {
			if(pstmt != null) pstmt.close();
			if(result != null) result.close();
		}
		return list;
	}
	
	public void update(Student student) {
		
	}
	
}
