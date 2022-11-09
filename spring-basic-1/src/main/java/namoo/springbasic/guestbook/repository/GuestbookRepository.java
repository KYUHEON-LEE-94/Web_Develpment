package namoo.springbasic.guestbook.repository;

import java.util.List;

import namoo.springbasic.guestbook.dto.Guestbook;

/*
 * 데이터 저장과 관련된 interface
 */
public interface GuestbookRepository {
	public void create(Guestbook guestbook);
	public List<Guestbook> findAll();
}
