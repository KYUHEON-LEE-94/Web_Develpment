package namoo.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 싱글톤 디자인 패턴을 적용한 Connection Factory
 * @author Lee KyuHeon
 *
 */

public class ConnectionFactory {
	private String driver;
	private String url;
	private String username ;
	private String password;
	
	private static ConnectionFactory factory = new ConnectionFactory();
	
	private BasicDataSource dataSource;
	
	//ConnectionFactory를 객체화했을 떄 커넥션 연결이 필요하기 떄문에 안에서 BasicDataSource를 객체화해줘야함.
	//그러나, 여기안에서 선언한경우 지역변수로 작용하기 때문에 getConnection()에서 해당 BasicDataSource를 사용할 수 없음
	//그래서 위에서 클래스 내의 전역변수로 선언을 해줌
	private ConnectionFactory() {
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
		InputStream in = getClass().getResourceAsStream("jdbc.properties");
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
	
	
	public static ConnectionFactory getInstance() {
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

}
