package namoo.springjpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.repository.MemberRepository;

@SpringBootTest
@Slf4j
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	@Disabled
	// @Commit
	public void createTest() {
		// 회원 등록
		Member member = new Member();
		member.setId("monday");
		member.setPassword("1111");
		member.setName("월요일");
		member.setAge(10);
		memberRepository.create(member);
		log.info("회원등록 완료 : {}", member);
	}

	@Test
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
	@Disabled
	public void countTest() {
		long count = memberRepository.getCount();
		log.info("회원수: " + count);
	}
}
