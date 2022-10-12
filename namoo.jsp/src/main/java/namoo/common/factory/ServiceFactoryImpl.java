package namoo.common.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import namoo.user.dao.JDBCUserDao;
import namoo.user.dao.UserDao;
import namoo.user.dto.User;
import namoo.user.service.UserService;
import namoo.user.service.UserServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {
	
	private static ServiceFactoryImpl factory = new ServiceFactoryImpl();
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	private DataSource dataSource;
	
	private ServiceFactoryImpl() {
		loadProperties();
		createDataSource();
	}
	
	public static ServiceFactoryImpl getInstance() {
		return factory;
	}
	
	private void loadProperties() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/resources/jdbc.properties");
		try {
			prop.load(in);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.username = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(10);     // 풀의 초기 커넥션 개수
		ds.setMaxTotal(100);       // 최대 커넥션 개수
		ds.setMaxIdle(10);         // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		ds.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		dataSource = ds;
	}
	
	public UserDao getUserDao() {
		return new JDBCUserDao(dataSource);
	}

	@Override
	public UserService getUserService() {
		return new UserServiceImpl(getUserDao());
	}
	
	// test main
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
		
		System.out.println(serviceFactory.findById("gono"));
		System.out.println(serviceFactory.login("gono", "1111"));
		
	}
}
