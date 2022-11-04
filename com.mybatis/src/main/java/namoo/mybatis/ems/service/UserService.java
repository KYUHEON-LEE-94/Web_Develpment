package namoo.mybatis.ems.service;

import java.util.List;
import java.util.Map;

import namoo.mybatis.ems.dto.User;

public interface UserService {

	public void register(User user);
	public List<User> findUesr();
	public User login(Map<String,String> map);
	public User findUserbyid(String userId);
	
}
