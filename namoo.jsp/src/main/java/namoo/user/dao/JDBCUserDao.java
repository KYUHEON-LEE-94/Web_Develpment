package namoo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.user.dto.User;

/**
 * UserDao 구현체(JDBC API 활용)
 * @author Lee KyuHeon
 *
 */
public class JDBCUserDao implements UserDao {
	
	private DataSource dataSource;
	
	//생성자
	public JDBCUserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO students(ssn,name,korean,english,math)")
		  .append(" VALUES(stu_seq.nextval, ?,?,?,?)");
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId()); 
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPasswd());
			pstmt.executeUpdate();
		}finally {
			if(pstmt != null) pstmt.close();
		}
		
	}

	@Override
	public List<User> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByIdAndPasswd(String id, String Passwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
	//------

	
	
}
