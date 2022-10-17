package namoo.test;

import java.util.List;

import namoo.common.factory.ServiceFactory;
import namoo.common.factory.ServiceFactoryImpl;
import namoo.common.web.Params;
import namoo.user.dto.User;
import namoo.user.service.UserService;

public class UserDaoTest {

	public static void main(String[] args) {
		ServiceFactory serviceFactory = ServiceFactoryImpl.getInstance();
		UserService userService = serviceFactory.getUserService();
//		System.out.println(userService);
//		User user = new User();
//		user.setId("sylee");
//		user.setName("이승엽");
//		user.setPasswd("1111");
//		user.setEmail("sylee@gmail.com");
//		userService.registUser(user);
//		System.out.println("정상 등록 완료..");
		
//		List<User> list = userService.listAll();
//		System.out.println(list);
		
//		User findUser = userService.findById("bangry");
//		System.out.println(findUser);
		
//		User loginUser = userService.login("bangry", "11222");
//		System.out.println(loginUser);
		
//		List<User> searchList = userService.search("id", "bangry");
//		List<User> searchList = userService.search("name", "%기정%");
//		System.out.println(searchList);
		
//		int count = userService.searchCount("", "");
//		int count = userService.searchCount("id", "bangry");
//		int count = userService.searchCount("name", "기정");
//		System.out.println(count);
		
//		Params params = new Params();
		Params params = new Params("name", "기정", 20, 10, 1);
		List<User> list = userService.search(params);
		for (User user : list) {
			System.out.println(user);
		}
		
		

	}

}









