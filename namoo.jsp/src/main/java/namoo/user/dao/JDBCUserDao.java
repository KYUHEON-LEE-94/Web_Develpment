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
 * 
 * @author Lee KyuHeon
 *
 */
public class JDBCUserDao implements UserDao {

	private DataSource dataSource;

	// 생성자
	public JDBCUserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) throws RuntimeException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO users(id, name, passwd, email)").append(" VALUES (?, ?, ?, ?)");

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			// Query Update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			//SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public int countBySearchOption(String type, String value) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(*) cnt").append(" FROM users");
		
		switch (type) {
		case "id": sb.append(" WHERE  id = ?"); break;
		case "name": sb.append(" WHERE name LIKE ?"); break;		
		}

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if(!(type.equals(""))) {			
				pstmt.setString(1, value);			  
			}
			result = pstmt.executeQuery();
			while (result.next()) {
				count = result.getInt("cnt");
				
			}

		} catch (SQLException e) {
			//SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (result != null) result.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
	}

	@Override
	public List<User> findAll() throws RuntimeException {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD') regdate").append(" FROM users")
				.append(" ORDER BY regdate DESC");
		
		

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeQuery();
			while (result.next()) {
				User user = makeUser(result);
				list.add(user);
			}

		} catch (SQLException e) {
			//SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (result != null) result.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	@Override
	public List<User> findAllBySearchOption(String type, String value) {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD') regdate").append(" FROM users");
		
		//type에 따라 Where절 동적 추가
		switch (type) {
		case "id": sb.append(" WHERE  id = ?"); break;
		case "name": sb.append(" WHERE name LIKE ?"); break;		
		}
		
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if(!(type.equals(""))) {			
				pstmt.setString(1, value);			  
			}
			 
			result = pstmt.executeQuery();
			while (result.next()) {
				User user = makeUser(result);
				list.add(user);
			}

		} catch (SQLException e) {
			//SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (result != null) result.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
		
	}

	@Override
	public User findById(String id) throws RuntimeException {
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD HH24:MI:SS') regdate").append(" FROM users").append(" WHERE id = ?");
		

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			if (result.next()) {
				user = makeUser(result);
			}

		} catch (SQLException e) {
			//SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (result != null) result.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public User findByIdAndPasswd(String id, String Passwd) throws RuntimeException {
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD HH24:MI:SS') regdate").append(" FROM users").append(" WHERE id = ?  AND passwd = ?");
		

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, Passwd);
			result = pstmt.executeQuery();
			if (result.next()) {
				user = makeUser(result);
			}

		} catch (SQLException e) {
			//SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (result != null) result.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	// ------
	private User makeUser(ResultSet result) throws SQLException {
		User user = new User();

		user.setId(result.getString("id"));
		user.setName(result.getString("name"));
		user.setEmail(result.getString("email"));
		user.setRegdate(result.getString("regdate"));

		return user;
	}

}
