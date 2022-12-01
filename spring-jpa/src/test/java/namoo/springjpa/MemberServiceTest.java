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
import namoo.springjpa.domain.guestbook.entity.Guestbook;
import namoo.springjpa.domain.guestbook.repository.GuestbookRepository;
import namoo.springjpa.domain.guestbook.repository.GuestbookRepositoryImpl;
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.repository.JpaMemberRepositoryV2;
import namoo.springjpa.domain.member.repository.MemberHistoryRepository;
import namoo.springjpa.domain.member.repository.MemberRepository;
import namoo.springjpa.domain.member.service.MemberService;

@SpringBootTest
@Slf4j
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;

	@Autowired
	private JpaMemberRepositoryV2 memberRepository;

	@Autowired
	private MemberHistoryRepository memberHistoryRepository;

	/**
	 * MemberService @Transactional : OFF MemberRepository @Transactional:ON
	 * MemberHistoryRepository @Transactional:ON
	 */
// 회원, 회원이력 리포지토리 둘다 커밋 정상 처리
	@Test
	@Disabled
	public void completeTest() {
		Member member = new Member();
		member.setId("normal");
		member.setName("정상님");
		member.setPassword("1111");
		member.setAge(10);
		memberService.join(member);
		log.info("회원 및 회원이력 정상 등록 완료!");

		// member와 memberHistory가 정상적으로 들어간것을 확인
	}

	/**
	 * MemberService @Transactional : OFF MemberRepository @Transactional:ON
	 * MemberHistoryRepository @Transactional:ON
	 */
	// 회원 정상 커밋, 회원이력 롤백 -> 데이터 정합성 문제 발생
	@Test
	@Disabled
	public void failTest() {
		Member member = new Member();
		member.setId("unnormal");
		member.setPassword("1111");
		member.setName("비정상님");
		member.setAge(10);
		memberService.join(member);
		log.info("회원은 등록되고, 회원이력은 롤백!");
		// member는 등록 memberhistory는 실패해서 롤백 -> 좋지 않은 Case
		// 커넥션이 2개가 생성되어 서로 따로따로 활동중인 케이스
	}

	/**
	 * MemberService @Transactional : ON MemberRepository @Transactional:OFF
	 * MemberHistoryRepository @Transactional:OFF
	 */
	// 단일 트랜잭션 -> 회원, 회원이력 리포지토리 둘다 커밋 정상 처리되는 경우
	@Test
	@Disabled
	public void singleTxTest() {
		Member member = new Member();
		member.setId("Single");
		member.setPassword("1111");
		member.setName("단일트랜잭션");
		member.setAge(10);
		memberService.join(member);
		log.info("회원 및 회원이력 정상 등록 완료!");
	}

	/**
	 * MemberService @Transactional : ON MemberRepository @Transactional:OFF
	 * MemberHistoryRepository @Transactional:OFF
	 */
	// 단일 트랜잭션 -> 회원, 회원이력 전부 롤백 처리
	@Test
	@Disabled
	public void singleTxTest2() {
		Member member = new Member();
		member.setId("NoSingle");
		member.setPassword("1111");
		member.setName("비정상님");
		member.setAge(10);
		memberService.join(member);
		log.info("회원 및 회원이력 전부 롤백!");
		// 아무런 정보도 추가되지 않았음
	}

	/**
	 * MemberService @Transactional : ON MemberRepository @Transactional:ON
	 * MemberHistoryRepository @Transactional:ON
	 */
	// 트랜잭션 전파 -> 회원, 회원이력 리포지토리 둘다 커밋 정상 처리
	@Test
	@Disabled
	public void propagationSucessTest() {
		Member member = new Member();
		member.setId("propaga");
		member.setPassword("1111");
		member.setName("트랜잭션전파");
		member.setAge(10);
		memberService.join(member);
		log.info("회원 및 회원이력 정상 등록 완료!");
		//
	}

	/**
	 * MemberService @Transactional : ON MemberRepository @Transactional:ON
	 * MemberHistoryRepository @Transactional:ON
	 */
	// 트랜잭션 전파 -> 회원이력 리포지토리 예외 발생으로 둘다 롤백 처리
	@Test
	public void propagationFailTest() {
		Member member = new Member();
		member.setId("fail");
		member.setPassword("1111");
		member.setName("비정상님2");
		member.setAge(10);
		memberService.join(member);
		log.info("회원 및 회원이력 롤백!");
	}

}
