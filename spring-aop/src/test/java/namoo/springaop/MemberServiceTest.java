package namoo.springaop;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springaop.member.service.MemberServiceImpl;

@SpringBootTest
@Slf4j
class MemberServiceTest {

	@Autowired
	private MemberServiceImpl memberServiceImpl;
	
	@Test
	void join() {
		memberServiceImpl.join();
	}

	@Test
	void findMembers() {
		List<String> list = memberServiceImpl.findMembers();
		log.info("회원 전체 목록: {}",list.toString());
	}
}
