package namoo.mybatis.ems.service;

import java.util.List;
import java.util.Map;

import namoo.mybatis.ems.dto.User;
import namoo.mybatis.ems.mapper.UserMapper;

public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void register(User user) {
		userMapper.register(user);

	}

	@Override
	public List<User> findUesr() {
		return userMapper.findUesr();
	}

	@Override
	public User login(Map<String,String> map) {
		return userMapper.login(map);
	}

	@Override
	public User findUserbyid(String userId) {
		return userMapper.findUserbyid(userId);
	}

}
