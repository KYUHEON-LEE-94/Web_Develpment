package namoo.allinone;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.extern.slf4j.Slf4j;
import namoo.allinone.domain.member.entity.Member;
import namoo.allinone.domain.member.repository.JpaMemberRepository;

@SpringBootTest
@Slf4j
public class JpaMemberRepositoryTest {
	
	@Autowired
	private JpaMemberRepository jpaMemberRepository;
	
	@Test
	@Disabled
	public void saveTest() {
		Member member = new Member();
		member.setId("bangry");
		member.setPassword("1111");
		member.setName("김기정");
		member.setAge(30);
		Member registerMember = jpaMemberRepository.save(member);
		log.info("회원등록 완료 : {}", registerMember);
	}
	
	@Test
	@Disabled
	public void findByIdAndPasswordTest() {
		Member loginMember = jpaMemberRepository.findByIdAndPassword("bangry", "1111");
		log.info("로그인 조회 :{}", loginMember);
	}
	
	@Test
	public void findAllByIdContainingOrNameContainingTest() {
		Pageable pageable = PageRequest.of(0, 5); //요청페이지, 페이징사이즈
//		Page<Member> page = jpaMemberRepository.findAllByIdOrNameContaining("tuesday", "요", pageable);
		Page<Member> page = jpaMemberRepository.findAllByIdOrNameContaining("", "", pageable);
		log.info("페이징 :{}", page);
		log.info("전체페이지: {}" , page.getTotalPages());
		log.info("이전페이지 존재여부 {}: " , page.hasPrevious());
		log.info("다음페이지 존재여부 {}: " , page.hasNext());
		log.info("처음으로 존재여부 {}: " , page.isFirst());
		log.info("마지막으로 존재여부 {}: " , page.isLast());
		log.info("목록: {}" , page.getContent());
		log.info("목록 개수: {}" , page.getTotalElements());
	}
}
