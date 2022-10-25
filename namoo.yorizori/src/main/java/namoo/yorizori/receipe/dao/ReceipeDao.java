package namoo.yorizori.receipe.dao;

import namoo.yorizori.receipe.dto.Reciepe;

/**
 * 회원관련 데이터 처리 추상 메소드 선언
 * 
 * @author 김기정
 */
public interface ReceipeDao {
	public void create(Reciepe Reciepe) throws RuntimeException;

	public Reciepe findById(int id) throws RuntimeException;


}
