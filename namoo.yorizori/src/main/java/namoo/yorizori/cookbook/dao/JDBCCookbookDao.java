package namoo.yorizori.cookbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import namoo.yorizori.cookbook.dto.Cookbook;

public class JDBCCookbookDao implements CookbookDao {
	
	private DataSource dataSource;

	// 생성자
	public JDBCCookbookDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Cookbook cookbook) throws RuntimeException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO cookbook (book_id, book_name, book_desc, author_id)").append(" VALUES (cookbook_seq.nextval, ?, ?,  ?)");

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, cookbook.getBookName());
			pstmt.setString(2, cookbook.getBookDesc());
			pstmt.setString(3, cookbook.getAuthorId());
			
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
	public List<Cookbook> findAll() throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
