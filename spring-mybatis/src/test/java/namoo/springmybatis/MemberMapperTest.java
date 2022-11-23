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
import namoo.springmybatis.domain.member.dto.Member;
import namoo.springmybatis.domain.member.dto.MemberSearchCondition;
import namoo.springmybatis.domain.member.mapper.MemberMapper;

@SpringBootTest
@Slf4j
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	
	
	
	@Test
	@Disabled
	void findByAllTest() {
		List<Member> list = memberMapper.findByAll();
		log.info("목록{}", list);
	}
	
	@Test
	void findByIdTest() {
		String id ="fake";
		Optional<Member> optional = memberMapper.findById(id);
		if(optional.isPresent()) {
			log.info("검색된 회원 정보:{}",optional.get());
		}
		//optional: id에 해당하는 member가 없는 경우 null이 떨어짐 -> null이 있는지도 모르고 사용하면 nullPointException이 떨어질 우려가 많음
			// -> 검색된 객체가 null일 경우 if로 체크한 구문이 optional안에 메서드로 있어서 사용가능
		// + optional.isEmpty();
	}
	
	@Test
	@Disabled
	void findByAgeRange() {
		List<Member> list = memberMapper.findByAgeRange(13,16);
		log.info("나이범위로 찾기: {}", list);
		
	}
	
	@Test
	@Disabled
	void findByNameLike() {
		String name = "가";
		List<Member> list = memberMapper.findByNameLike("%"+name+"%");
		log.info("이름으로 찾기: {}", list);
		
	}
	
	@Test
	@Disabled
	void findBySearchTest() {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("type", "id");
		searchMap.put("value", "fake");
		List<Member> list = memberMapper.findBySearch(searchMap);
		log.info("map으로 찾기: {}", list);
		
	}
	
	//통합검색 테스트
	@Test
	void findBySearchV2Test() {
		MemberSearchCondition condition = new MemberSearchCondition();
		condition.setId("fake");
		condition.setName("익");
		condition.setAge(12);
		
		List<Member> list = memberMapper.findBySearchV2(condition);
		log.info("객체를 만들어서 찾기: {}", list);
		
	}
	
	@Test
	void updateTest() {
		Member member = new Member();
		member.setId("fake");
		member.setAge(20);
		memberMapper.update(member);
	}
	
	@Test
	@Disabled
	void createTest() {
		
	}

}
