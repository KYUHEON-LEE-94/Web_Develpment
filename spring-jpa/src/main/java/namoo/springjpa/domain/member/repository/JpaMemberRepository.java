package namoo.springjpa.domain.member.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.entity.Member3;

@Repository
//JPA의 모든 데이터 변경(등록, 수정, 삭제)은 트랜잭션 안에서 이루어져야 한다.
//JPA에서는 데이터 변경시 트랜잭션이 필수다. '일반적으로는' 비즈니스 로직을 시작하는 서비스 계층에서 트랜잭션을 걸어준다.
@Transactional  //속성이 엄청~많음
@Slf4j
public class JpaMemberRepository implements MemberRepository {
	
//JPA의 모든 동작은 EntityManager를 통해서 이루어진다.
//EntityManager는 내부에 DataSource를 가지고 있고, 커넥션풀을 통해 데이터베이스에 접근한다.
	@Autowired
	private EntityManager entityManager;

//@Autowired
//PlatformTransactionManager transactionManager; //transaction을 직접관리할 때 필요
	
	@Override
	public void create(Member member) {
		//트랜잭션 직접 관리
		//TransactionStatus transactionStatus = null; //트랜잭션 상태 정보
		//transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		entityManager.persist(member);	//DB에 insert
											//문제가 발생하면 rollback, 정상적이면 commit해야됨 
		//transactionManager.commit(transactionStatus); //정상적일때는 commit이 됨
			//-> 많이 사용하는 방법은 아님
				//편하게 관리를 원하면 @Transactional을 선언해주면 위에 주석처리되어 있는게 자동실행됨(AOP 가 적용되어있음)
	}

	
	/*
	 * 전체를 가져오는 메서드는 따로 내부적으로 만들어져 있지 않아서 내가 직접 코드를 실행
	 */
	@Override
	public List<Member3> findAll() {
		// JPA는 JPQL(Java Persistence Query Language)이라는 SQL 문법과 비슷한 객체지향 쿼리 언어를 제공한다
		// 주로 여러 데이터를 복잡한 조건으로 조회할 때 사용한다
		// SQL이 테이블을 대상으로 한다면, JPQL은 엔티티 객체를 대상으로 SQL을 실행한다
		// 엔티티 객체를 대상으로 하기 때문에 from 다음에 Member 엔티티 객체 이름이 들어간다
		// JPQL을 실행하면 그 안에 포함된 엔티티 객체의 매핑 정보를 활용해서 SQL을 작성한다
		String jpQL = "select m from Member m"; //member의 모든 프로퍼티를 조회해와라
		List<Member3> result = entityManager.createQuery(jpQL, Member3.class).getResultList();
																			//다수의 쿼리 결과
		return result;
	}

	/*
	 * find는 내부적으로 메서드가 만들어져있음
	 */
	@Override
	public Optional<Member3> findById(String id) {
// JPA에서 엔티티 객체를 PK를 기준으로 조회할 때는 find()를 사용하고 조회 타입과, PK 값을 전달한다
// JPA가 SELECT SQL을 만들어서 실행하고, 결과를 객체로 반환한다
		Member3 member = entityManager.find(Member3.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public void delete(String id) {
		Member member = entityManager.find(Member.class, id);
		entityManager.remove(member);
	}

	@Override
	public long getCount() {
		//Oracle이 제공하는 모든 함수들을 제공하지는 않음
		return entityManager.createQuery("select count(m) from Member m", Long.class).getSingleResult();
																					//단 하나의 쿼리 결과
	}
}