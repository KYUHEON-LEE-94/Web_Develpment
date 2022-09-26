package namoo.jdbc;

import java.sql.*;
import java.util.*;
/**
 * 사용자 정의 ConnectionPooling 구현 클래스
 * 예시용으로만 만들어진거임, 좋은 코드는 아님
 * Singleton 패턴 적용
 */
public class UserConnectionPool{
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER_ID = "hr";
	private static final String USER_PW = "hr";
	
	private static final int INITIAL_CONNECTIONS = 5;
	private static final int INCREMENT = 2;
	
	private static Hashtable<Connection, Boolean> connections;

	private static UserConnectionPool instance;
	
	/** 직접 생성하지 못하도록 private 선언 */
	private UserConnectionPool() throws Exception{
		Class.forName(DB_DRIVER);
		connections = new Hashtable<Connection, Boolean>();		
		// 커넥션 생성 및 저장
		for(int i = 0; i < INITIAL_CONNECTIONS; i++){
			//Connection 객체를 저장하고 value 값으로 False(일단 아무도 사용안하니까.)
			connections.put(DriverManager.getConnection(DB_URL, USER_ID, USER_PW), Boolean.FALSE);
		}
	}
	
	public static UserConnectionPool getInstance() throws Exception{
		if(instance == null){
			synchronized (UserConnectionPool.class) {
				instance = new UserConnectionPool();
			}
		}
		return instance;
	}

	/** 사용중이지 않는 Connection 반환 */
	public  Connection getConnection() throws SQLException{
		Enumeration<Connection> cons = connections.keys();		
		while(cons.hasMoreElements()){
			Connection con = cons.nextElement();
			Boolean use = connections.get(con);				
			// 사용중이지 않은 경우...
			if (use == Boolean.FALSE){
				connections.put(con, true);
				return con;
			}
		}
		
		for(int i = 0; i < INCREMENT; i++){
			System.out.println("[디버깅] : 사용 가능한 커넥션이 없어서 새로운 Connection 생성>>");
			connections.put(DriverManager.getConnection(DB_URL, USER_ID, USER_PW), Boolean.FALSE);
		}
		// 재귀호출
		return getConnection();
	}


	/** 사용한 커넥션 반납 */
	public void releaseConnection(Connection usedConnection){
		Connection con = null;
		Enumeration<Connection> e = connections.keys();
		while (e.hasMoreElements()){
			con = (Connection)e.nextElement();			
			if (con == usedConnection){
				connections.put(con, Boolean.FALSE);
				break;
			}
		}
	}

	/** 저장된 모든 Connection 닫기 */
	public void closeAll(){
		Enumeration<Connection> cons = connections.keys();		
		while(cons.hasMoreElements()){
			Connection con = (Connection)cons.nextElement();
			try{
				con.close();
			}
			catch(Exception e) {}
		}
	}
	
	/** 테스트 */
	public static void main(String[] args) throws Exception {
		//UserConnectionPool cp = new UserConnectionPool(); 에러
		UserConnectionPool cp = UserConnectionPool.getInstance();
		// 커넥션 취득
		for(int i=0; i<10; i++) {
			Connection con = cp.getConnection();
			System.out.println(con);
			cp.releaseConnection(con);
		}
	}
}
