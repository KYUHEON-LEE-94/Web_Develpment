package namoo.user.dao;

import java.util.List;

import namoo.user.dto.User;

/**
 * 회원관련 데이터 처리 추상 메소드 선언
 * DB처리하는 역할
 * @author Lee KyuHeon
 *
 */
public interface UserDao {

	public void  create(User user) throws RuntimeException;
	
	public List<User> findAll() throws RuntimeException;
	
	public User findById(String id) throws RuntimeException;
	
	public User findByIdAndPasswd(String id, String Passwd) throws RuntimeException;
		
}
