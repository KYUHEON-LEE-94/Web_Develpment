package namoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

//DBCP를 어떻게 사용하는가?

public class DBCPUseExample {

	public static void main(String[] args) throws SQLException {
//		DataSource dbs = new BasicDataSource();
//		BasicDataSource ds = (BasicDataSource) dbs;
		
		//Class.forName("oracle.jdbc.driver.OracleDriver") 과정과 conn = DriverManager.getConnection(url,user,password);과정을 아래 객체 생성으로 생략가능
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("hr");
		
		ds.setInitialSize(10); // 풀의 초기 커넥션 개수
		ds.setMaxTotal(100); // 최대 커넥션 개수
		ds.setMaxIdle(10); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		ds.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		
		Connection con = ds.getConnection();
		System.out.println(con);
		
		//사용이 끝나고나면 반드시 반납해야함
		//Connection 클래스의 close를 오버라이딩 해놔서 반환하는 메서드로 바뀜
		con.close();
		
		

	}

}
