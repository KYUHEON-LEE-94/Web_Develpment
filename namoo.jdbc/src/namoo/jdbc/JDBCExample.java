package namoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * JDBC-API를 이용한 RDB 연동하기
 * @author Lee KyuHeon
 *
 */
public class JDBCExample {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		
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
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("오라클 서버 연결 완료!");
			System.out.println(conn);

// #3 Statement 객체 생성
			//sql develpoer에서 검증하고 가져오는 걸 권고
			String sql = " SELECT employee_id, last_name, email, salary"
					+ " FROM employees";
			stmt = conn.createStatement();
			//createStatement()로 사용한 Statemnet 객체는 재사용이 불가능
			result = stmt.executeQuery(sql);
			// -> 테이블 형식의 데이터 결과를 변수로 저장했다고 생각하면 됨
			
			//가져올 다음의 데이터가 있으면 true, 없으면 false
			while(result.next()) {
				//System.out.println("강좌명"+result.getString("가져오고자 하는 컬럼 이름"));
				int empNo = result.getInt("employee_id");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				int salary = result.getInt("salary");
			
				System.out.println(empNo +"\t"+lastName+"\t"+email+"\t"+salary);	
				
				//리소스를 많이 잡아먹기 때문에 닫아줌.
			}

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				result.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
	}

}

