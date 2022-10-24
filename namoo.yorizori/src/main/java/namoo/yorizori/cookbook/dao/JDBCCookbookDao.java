package namoo.yorizori.cookbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yorizori.receipe.dto.Receipe;
import namoo.yorizori.user.dto.User;

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
		sb.append(" INSERT INTO cookbook (book_id, book_name, book_desc, author_id)")
				.append(" VALUES(cookbook_seq.nextval,?,?,?)");

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, cookbook.getBookName());
			pstmt.setString(2, cookbook.getBookDesc());
			pstmt.setString(3, cookbook.getAuthorId());

			// Query Update
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Cookbook> findAll() throws RuntimeException {
		List<Cookbook> list = new ArrayList<Cookbook>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT book_id, book_name, book_desc, author_id").append(" FROM cookbook");

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			result = pstmt.executeQuery();
			while (result.next()) {
				Cookbook cookbook = makeCookbook(result);
				list.add(cookbook);
			}

		} catch (SQLException e) {
			// SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (result != null)
					result.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Cookbook findCookbook(int bookId) throws RuntimeException {
		Cookbook cookbook = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT book_id, book_name, book_desc, author_id").append(" FROM cookbook")
				.append(" WHERE book_id = ?");

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, bookId);
			result = pstmt.executeQuery();
			if (result.next()) {
				cookbook = makeCookbook(result);
			}

		} catch (SQLException e) {
			// SQL Exception을 RuntimeException으로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (result != null)
					result.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cookbook;
	}

	@Override
	public List<Map<String, Object>> finAllCookbooksWithName() throws RuntimeException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet result = null;
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT c.book_id bookId, c.book_name bookName, c.book_desc bookDesc, c.author_id authorId, u.name authorName").append(" FROM cookbook c").append(" JOIN users u on c.author_id = u.id");
				

				

				try {
					conn = dataSource.getConnection();
					pstmt = conn.prepareStatement(sb.toString());
					result = pstmt.executeQuery();
					while (result.next()) {
						Map<String, Object> row = new HashMap<String, Object>();
						row.put("bookId", result.getInt("bookId"));
						row.put("bookName", result.getString("bookName"));
						row.put("bookDesc", result.getString("bookDesc"));
						row.put("authorId", result.getString("authorId"));
						row.put("authorName", result.getString("authorName"));
						
						list.add(row);
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

	private Cookbook makeCookbook(ResultSet result) throws SQLException {
		Cookbook cookbook = new Cookbook();

		cookbook.setBookId(result.getInt("book_id"));
		cookbook.setBookName(result.getString("book_name"));
		cookbook.setBookDesc(result.getString("book_desc"));
		cookbook.setAuthorId(result.getString("author_id"));

		return cookbook;
	}

}
