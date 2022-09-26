package namoo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 학생관련 데이터 처리 추상 메소드 선언
 * DB처리하는 역할
 * @author Lee KyuHeon
 *
 */
public interface StudentDao {

	public void  create(Student student) throws SQLException;
	
	public Student findBySsn(String ssn) throws SQLException;
	
	public List<Student> findAll() throws SQLException;
	
	public List<Student> findByType(String type, String value) throws SQLException;
	
	public void update(Student student) throws SQLException;
		
}
