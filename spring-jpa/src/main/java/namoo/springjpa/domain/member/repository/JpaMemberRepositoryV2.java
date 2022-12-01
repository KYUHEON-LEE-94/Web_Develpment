package namoo.springjpa.domain.member.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.member.entity.Member;

@Repository
@Slf4j
public class JpaMemberRepositoryV2 {
	//로그 사용을 위해서 interface로 만들지 않음(연습용) 순수 JPA

	@Autowired
	private EntityManager entityManager;

//	@Transactional
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(Member member) {
		log.info("- Member 저장");
		entityManager.persist(member);
	}

	public Optional<Member> find(String username) {
		Query query = entityManager.createQuery("select m from Member m where m.username=?1", Member.class);
		return query.setParameter("username", username).getResultList().stream().findAny();

	}

}
