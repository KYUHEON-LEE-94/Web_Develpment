package namoo.allinone;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.extern.slf4j.Slf4j;
import namoo.allinone.domain.member.entity.Member;
import namoo.allinone.domain.member.service.MemberService;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	@Disabled
	public void registerTest() {
		Member member = new Member();
		member.setId("monday");
		member.setPassword("1111");
		member.setName("월요일");
		member.setAge(10);
		String userId = memberService.register(member);
		log.info("회원등록 완료 : {}", userId);
	}
	
	@Test
	@Disabled
	public void isMemberTest() {
		Member loginMember = memberService.isMember("bangry", "1111");
		log.info("로그인 정보 : {}", loginMember);
	}
	
	@Test
	@Disabled
	public void findMemberTest() {
		Optional<Member> memberOptional = memberService.findMember("bangry");
		log.info("회원 정보 : {}", memberOptional.get());
	}
	
	@Test
	@Disabled
	public void findMembersTest() {
		List<Member> list = memberService.findMembers();
		log.info("회원 목록 : {}", list);
	}
	
	@Test
	public void findMembersTest2() {
//		String searchValue = "";
//		String searchValue = "bangry";
		String searchValue = "요";
		Pageable pageable = PageRequest.of(0, 5); //요청페이지, 페이징사이즈
		Page<Member> page = memberService.findMembers(searchValue, pageable);
		log.info("목록: {}" , page.getContent());
		log.info("목록 개수: {}" , page.getTotalElements());
	}
	
}
