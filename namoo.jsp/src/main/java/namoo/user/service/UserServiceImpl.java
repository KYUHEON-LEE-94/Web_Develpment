package namoo.user.service;

import java.util.List;

import namoo.common.web.Params;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;
/*
 * 회원관리 비즈니스 로직 처리
 * 복잡한 트랜잭션 관리
 */
public class UserServiceImpl implements UserService {
	

	UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void registUser(User user){
		
			userDao.create(user);
	}

	@Override
	public List<User> listAll() {		
		
		return	userDao.findAll();
	
	}

	@Override
	public User findById(String userId) {
		return userDao.findById(userId);
		
	}

	@Override
	public User login(String id, String passwd) {
		return userDao.findByIdAndPasswd(id, passwd);
	}

	@Override
	public List<User> search(String type, String value) {
		if(type.equalsIgnoreCase("name")) {
			value = "%"+value+"%";
		}
		return userDao.findAllBySearchOption(type, value);
	}

	@Override
	public int searchCount(String type, String value) {
		if(type.equalsIgnoreCase("name")) {
			value = "%"+value+"%";
		}
		return userDao.countBySearchOption(type, value);
	}
	
	@Override
	public List<User> search(Params params) {
		if(params.getSearchType().equalsIgnoreCase("name")) {
			params.setSearchValue("%" + params.getSearchValue() + "%");
		}
		return userDao.findAllBySearchOption(params);
	}

}
