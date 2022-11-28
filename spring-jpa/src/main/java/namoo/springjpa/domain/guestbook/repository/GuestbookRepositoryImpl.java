package namoo.springjpa.domain.guestbook.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import namoo.springjpa.domain.guestbook.entity.Guestbook;
import namoo.springjpa.domain.member.entity.Member;

@Repository
@Transactional
public class GuestbookRepositoryImpl implements GuestbookRepository {
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	public void create(Guestbook guestbook) {
		entitymanager.persist(guestbook);

	}

	@Override
	public List<Guestbook> findAll() {
		String jpQL = "select m from Guestbook m"; //member의 모든 프로퍼티를 조회해와라
		return entitymanager.createQuery(jpQL, Guestbook.class).getResultList();
 
	}

}
