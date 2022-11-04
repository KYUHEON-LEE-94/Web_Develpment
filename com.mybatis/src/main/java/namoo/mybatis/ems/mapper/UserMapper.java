package namoo.mybatis.ems.mapper;

import java.util.List;
import java.util.Map;

import namoo.mybatis.ems.dto.User;

// EmployeeMapper.xml의 namespace와 완벽하게 일치
public interface UserMapper {
	//User등록
	public void register(User user);
	
	//전체 user리스트 찾기
	public List<User> findUesr();
	
	//User 로그인  검증
	public User login(Map<String,String> map);
	
	//id로 User찾기
	public User findUserbyid(String id);

}
