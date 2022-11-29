package namoo.springjpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.entity.Member3;
import namoo.springjpa.domain.member.repository.MemberRepository;

@SpringBootTest
@Slf4j
//@Transactional //service에서 @Transactional사용하지 않고, test에서 @Transactional을 사용하면 트랜잭션 하고 나서 롤백됨
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	@Disabled
	 //@Commit //@Transactional을 사용하고 있지만, test임에도 불구하고 commit을 원한다면 이 @사용
	public void createTest() {
		// 회원 등록
		Member3 member = new Member3();
		member.setId("monday");
		member.setPasswd("1111");
		member.setName("월요일");
		member.setAge(10);
		memberRepository.create(member);
		log.info("회원등록 완료 : {}", member);
	}

	@Test
	@Disabled
	public void findAllTest() {
		List<Member> list = memberRepository.findAll();
		log.info("사용자 전체 조회 {}", list);
	}

	@Test
	@Disabled
	public void findByIdTest() {
		Optional<Member> optional = memberRepository.findById("monday");
		if (optional.isPresent()) {
			log.info("아이디로 회원 조회 : {}", optional.get());
		}
	}

	@Test
	@Disabled
	public void deleteTest() {
		memberRepository.delete("monday");
		log.info("회원 삭제 완료!");
	}

	@Test
	//@Disabled
	public void countTest() {
		long count = memberRepository.getCount();
		log.info("회원수: " + count);
	}
}
