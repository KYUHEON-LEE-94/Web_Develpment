package namoo.user.service;

import java.util.List;

import namoo.bean.User;
/*
 * 회원관리 비즈니스 로직 처리
 * 복잡한 트랜잭션 관리
 */
public class UserServiceImpl implements UserService {
	
//	UserDao userDao = new JDBCUserDao();

	@Override
	public void registUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> listALl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String id, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
