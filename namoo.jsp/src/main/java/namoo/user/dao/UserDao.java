package namoo.user.dao;

import java.util.List;

import namoo.common.web.Params;
import namoo.user.dto.User;

/**
 * 회원관련 데이터 처리 추상 메소드 선언
 * 
 * @author 김기정
 */
public interface UserDao {
	public void create(User user) throws RuntimeException;

	public List<User> findAll() throws RuntimeException;

	public User findById(String id) throws RuntimeException;

	public User findByIdAndPasswd(String id, String passwd) throws RuntimeException;

	// 검색옵션에 따른 회원목록 조회
	public List<User> findAllBySearchOption(String type, String value);

	// 검색옵션에 따른 회원수 조회
	public int countBySearchOption(String type, String value);

	// 검색옵션, 페이지사이즈, 페이지카운트, 요청페이지 따른 회원목록 조회
	// public List<User> findAllBySearchOption(String type, String value, int
	// pageSize, int pageCount, int requestPage);

	// 검색옵션, 페이지사이즈, 페이지카운트, 요청페이지 따른 회원목록 조회
	public List<User> findAllBySearchOption(Params params);
}
