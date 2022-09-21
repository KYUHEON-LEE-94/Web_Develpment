package namoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * JDBC-API를 이용한 RDB 연동하기
 * @author Lee KyuHeon
 *
 */
public class JDBCExample {

	public static void main(String[] args) {
// #1. JDBC 드라이버 로딩(메모리에 생성) -> 드라이버 매니저에 등록
		try {
			//오라클 드라이버 객체 정적 생성
			// OracleDriver driver = new OracleDriver();
			
			//동적생성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); -> 원래는 이렇게 해야 객체를 생성하지만, OracleDriver는 내부적으로 newInstance를 호출하고 있음.
			
			System.out.println("오라클 드라이버 로딩 완료!");

// #2 오라클 네트워크 연결하기			
			//String url = "jdbc:mysql://localhost:3306/데이터베이스명"; //MariaDB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";  //Oracle
			String user = "hr";
			String password = "hr";
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("오라클 서버 연결 완료!");
			System.out.println(conn);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}

