package namoo.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
	
	private ConnectionFactory() {
		loadProperties();
		try {
			Class.forName(driver);
			} catch (ClassNotFoundException e) { }
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
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
		}
		return con;
	}

}
