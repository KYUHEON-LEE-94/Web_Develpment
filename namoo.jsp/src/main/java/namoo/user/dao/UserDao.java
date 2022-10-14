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
	
	//검색옵션에 따른 회원 목록 조회
	public List<User> findAllBySearchOption(String type, String value);
	
	//검색옵션에 따른 회원수 조회
	public int countBySearchOption(String type, String value);
		
}
