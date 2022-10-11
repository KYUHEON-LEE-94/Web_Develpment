package namoo.common.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import namoo.user.dao.JDBCUserDao;
import namoo.user.dao.UserDao;
import namoo.user.service.UserService;

public class ServiceFactoryImpl implements ServiceFactory {
	private UserDao studentDao;
	
	private String driver;
	private String url;
	private String username ;
	private String password;
	
	private static ServiceFactoryImpl factory = new ServiceFactoryImpl();
	
	private DataSource dataSource;
	
	private UserDao userDao;
	private UserService userService;

	private ServiceFactoryImpl() {
		loadProperties();
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(10); // 풀의 초기 커넥션 개수
		ds.setMaxTotal(100); // 최대 커넥션 개수
		ds.setMaxIdle(10); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		ds.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		
		dataSource = ds;

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
	
	public static ServiceFactoryImpl getInstance() {
		return factory;
	}
	
	public Connection getConnection(){
		Connection con = null;

		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	//Factory가 생성하고 실제 사용할때는 얘를 얻어가는 형태
	@Override
	public UserService getUserService() {
		if(userService == null) {
			userService = new JDBCUserDao(dataSource);	
		}
		return userService;
			
		
	}
	
	

}
