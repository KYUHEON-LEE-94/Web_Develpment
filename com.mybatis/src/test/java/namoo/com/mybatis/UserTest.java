package namoo.com.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import namoo.mybatis.common.factory.ServiceFactoryImpl;
import namoo.mybatis.ems.dto.User;
import namoo.mybatis.ems.service.UserService;

/**
 * Unit test for simple App.
 */
public class UserTest {

	@Test
	@DisplayName("전체 리스트 가져오기")
	public void AllList() {
		System.out.println("--------전체리스트-------------");
		UserService service = ServiceFactoryImpl.getInstance().getUserService();
		List<User> list = service.findUesr();
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	@Test
	@DisplayName("ID로 검색해서 정보 가져오기")
	public void findUserbyid() {
		System.out.println("--------ID검색-------------");
		UserService service = ServiceFactoryImpl.getInstance().getUserService();
		System.out.println(service.findUserbyid("gono2"));
		
	}
	
	@Test
	@DisplayName("Login체크")
	public void login() {
		System.out.println("--------LOGIN체크-------------");
		UserService service = ServiceFactoryImpl.getInstance().getUserService();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "gont");
		map.put("passwd", "1111");
		System.out.println(service.login(map));
		
	}
	

	@DisplayName("User등록되는지")
	@Disabled
	public void register() {
		System.out.println("--------USER등록되는지-------------");
		UserService service = ServiceFactoryImpl.getInstance().getUserService();
		User user = new User();
		user.setEmail("no@naver.com");
		user.setId("nara");
		user.setPasswd("1111");
		user.setName("나라");

		service.register(user);
		System.out.println("등록완료");
		
	}
}
