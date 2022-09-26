package namoo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * StudentDao 구현체(MyBatis Framework 활용)
 * @author Lee KyuHeon
 *
 */
public class MyBatisStudentDao implements StudentDao {

	@Override
	public void create(Student student) throws SQLException {
		//MyBatis 코드 구현
		

	}

	@Override
	public Student findBySsn(String ssn) throws SQLException {
		return null;
	}
	
	
	

	@Override
	public List<Student> findAll() throws SQLException {
		return null;

	}

	@Override
	public List<Student> findByType(String type, String value) throws SQLException {
		return null;

	}

	public void update(Student student) throws SQLException{
		
	}

	
	
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
