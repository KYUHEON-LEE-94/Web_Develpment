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
public class InsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";  //Oracle
		String user = "hr";
		String password = "hr";
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO students(ssn,name,korean,english,math)").append(" VALUES(stu_seq.nextval, ?,?,?,?)");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn = DriverManager.getConnection(url,user,password);
			//트랜잭션 관리
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, "고양이");
			pstmt.setInt(2, 50);
			pstmt.setInt(3, 70);
			pstmt.setInt(4, 100);
			int count = pstmt.executeUpdate();
			
			//트랜잭션 커밋
			conn.commit();
			
			System.out.println(count+"개 추가");
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		//예외가 발생하면 롤백해줘라!
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
	}

}

