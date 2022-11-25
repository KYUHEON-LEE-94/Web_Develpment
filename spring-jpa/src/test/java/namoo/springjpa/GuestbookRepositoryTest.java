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
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.repository.MemberRepository;

@SpringBootTest
@Slf4j
//@Transactional //service에서 @Transactional사용하지 않고, test에서 @Transactional을 사용하면 트랜잭션 하고 나서 롤백됨
class GuestbookRepositoryTest {

	@Autowired
	private GuestbookRepository guestbookRepository;

	@Test
	//@Disabled
	 //@Commit //@Transactional을 사용하고 있지만, test임에도 불구하고 commit을 원한다면 이 @사용
	public void createTest() {
		// 회원 등록
		Guestbook guestbook = new Guestbook();
		guestbook.setContents("테스트");
		guestbook.setWriter("나");
		guestbookRepository.create(guestbook);
		log.info("회원등록 완료 : {}", guestbook);
	}


}
