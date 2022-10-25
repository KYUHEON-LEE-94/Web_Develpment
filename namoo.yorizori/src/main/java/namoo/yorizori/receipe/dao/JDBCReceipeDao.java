package namoo.yorizori.receipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import namoo.yorizori.common.web.Params;
import namoo.yorizori.receipe.dto.Reciepe;
import namoo.yorizori.user.dto.User;

/**
 * UserDao 구현체(JDBC API 활용)
 * 
 * @author Lee KyuHeon
 *
 */
public class JDBCReceipeDao implements ReceipeDao {

	private DataSource dataSource;

	// 생성자
	public JDBCReceipeDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Reciepe Reciepe) throws RuntimeException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO recipe (recipe_id, book_id, recipe_name, recipe_time, recipe_level, ingredients, img_cont_type, img_file_name, writer_id)")
		.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

		

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, Reciepe.getReceipeId());
			pstmt.setInt(2, Reciepe.getBookId());
			pstmt.setString(3, Reciepe.getReceipeName());
			pstmt.setInt(4, Reciepe.getReceipeTime());
			pstmt.setInt(5, Reciepe.getReceipeLevel());
			pstmt.setString(6, Reciepe.getIngredients());
			pstmt.setString(7, Reciepe.getImgContType());
			pstmt.setString(8, Reciepe.getImgFileName());
			pstmt.setString(9, Reciepe.getWriterId());
			
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
	public Reciepe findById(int id) throws RuntimeException {
		Reciepe Reciepe = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT recipe_id, book_id, recipe_name, recipe_time, recipe_level, ingredients, img_cont_type, img_file_name, writer_ide")
		.append(" FROM recipe")
		.append(" WHERE recipe_id = ?");
		

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			if (result.next()) {
				Reciepe = makeReciepe(result);
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
		return Reciepe;
	}

	
	// ------
	private Reciepe makeReciepe(ResultSet result) throws SQLException {
		Reciepe reciepe = new Reciepe();

		reciepe.setReceipeId(result.getInt("recipe_id"));
		reciepe.setBookId(result.getInt("book_id"));
		reciepe.setReceipeName(result.getString("recipe_name"));
		reciepe.setReceipeTime(result.getInt("recipe_time"));
		reciepe.setReceipeLevel(result.getInt("recipe_level"));
		reciepe.setIngredients(result.getString("ingredients"));
		reciepe.setImgContType(result.getString("img_cont_type"));
		reciepe.setImgFileName(result.getString("img_file_name"));
		reciepe.setWriterId(result.getString("writer_id"));


		return reciepe;
	}

}
