package namoo.springjpa.domain.guestbook.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import namoo.springjpa.domain.guestbook.entity.Guestbook;


public interface GuestbookRepository {
	public void create(Guestbook guestbook);
	public List<Guestbook> findAll();
}
