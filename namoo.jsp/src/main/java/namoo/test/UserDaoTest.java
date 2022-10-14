package namoo.test;

import namoo.common.factory.ServiceFactoryImpl;
import namoo.user.service.UserService;

public class UserDaoTest {

	public static void main(String[] args) {
		UserService serviceFactory = ServiceFactoryImpl.getInstance().getUserService();
//		System.out.println(serviceFactory);
//		User user = new User();
//		user.setId("안드로이드");
//		user.setName("갤럭시");
//		user.setPasswd("123456");
//		user.setEmail("efse@efes.com");
//		serviceFactory.registUser(user);
//		List<User> list = serviceFactory.listALl();
//		System.out.println(list);
		
//		System.out.println(serviceFactory.findById("gono"));
//		System.out.println(serviceFactory.login("gono", "1111"));
//	 	System.out.println(serviceFactory.search("id", "4534"));
//	 	System.out.println(serviceFactory.search("name", "%기%"));
	 	System.out.println(serviceFactory.searchCount("name", "이"));
	}

}
