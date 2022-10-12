package namoo.user.service;

import java.util.List;

import namoo.user.dto.User;

/**
 * 회원 관리 비즈니스 메서드 선언
 * 고객 요구사항 명세
 * @author Lee KyuHeon
 *
 */
public interface UserService {
	public void registUser(User user);
	public List<User> listAll();
	public User findById(String userId);
	public User login(String id, String passwd);
	
}
