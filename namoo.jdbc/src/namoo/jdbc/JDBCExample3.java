package namoo.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * JDBC-API를 이용한 RDB 연동하기
 * @author Lee KyuHeon
 *
 */
public class JDBCExample3 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";  //Oracle
		String user = "hr";
		String password = "hr";
		
//		String sql = " SELECT employee_id, last_name, email, salary"
//				+ " FROM employees";
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT employee_id, last_name, email, salary, To_CHAR(hire_date, 'yyyy-MM-DD HH24:MI:SS') hire_date").append(" FROM employees").append(" WHERE employee_id = ?");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn = DriverManager.getConnection(url,user,password);
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, 100);
			result = pstmt.executeQuery();
			//StringBuilder는 StringBuilder로 반환하기 때문에 toString()사용
			
			while(result.next()) {		
				int empNo = result.getInt("employee_id");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				int salary = result.getInt("salary");
//				Date hireDate = result.getDate("hire_date");
				String hireDate = result.getString("hire_date");
				System.out.println(empNo +"\t"+lastName+"\t"+email+"\t"+salary+"\t"+hireDate);	
			}
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			try {
				result.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
	}

}

