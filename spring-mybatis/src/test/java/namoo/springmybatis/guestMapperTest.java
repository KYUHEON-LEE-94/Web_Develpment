package namoo.springmybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springmybatis.domain.guestbook.dto.Guestbook;
import namoo.springmybatis.domain.guestbook.mapper.GuestbookMapper;
import namoo.springmybatis.domain.guestbook.service.GuestbookServiceImpl;
import namoo.springmybatis.domain.member.dto.Member;
import namoo.springmybatis.domain.member.dto.MemberSearchCondition;
import namoo.springmybatis.domain.member.mapper.MemberMapper;

@SpringBootTest
@Slf4j
class guestMapperTest {

	@Autowired
	private GuestbookServiceImpl guest;
	

	
	
	@Test
	void findByAllTest() {
		List<Guestbook> list = guest.findByAll();
		for (Guestbook guestbook : list) {
			
		}
		log.info("test{}", list);
	}

	


}
