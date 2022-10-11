package namoo.user.dao;

import java.sql.SQLException;
import java.util.List;

import namoo.user.dto.User;

/**
 * 회원관련 데이터 처리 추상 메소드 선언
 * DB처리하는 역할
 * @author Lee KyuHeon
 *
 */
public interface UserDao {

	public void  create(User user) throws SQLException;
	
	public List<User> findAll() throws SQLException;
	
	public User findById(String id) throws SQLException;
	
	public User findByIdAndPasswd(String id, String Passwd) throws SQLException;
		
}
