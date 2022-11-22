package namoo.springmybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springmybatis.domain.member.dto.Member;
import namoo.springmybatis.domain.member.mapper.MemberMapper;

@SpringBootTest
@Slf4j
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	
	@Test
	void findByAllTest() {
		List<Member> list = memberMapper.findByAll();
		log.info("목록{}", list);
	}

}
