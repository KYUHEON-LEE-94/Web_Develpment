package namoo.springjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.extern.slf4j.Slf4j;

import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.repository.SpringDataJpaMemberRepository;

@SpringBootTest
@Slf4j
//@Transactional
class SpringDataJpaMemberRepositoryTest {

	@Autowired
	private SpringDataJpaMemberRepository repository;

	@Test
	@Disabled
	public void createTest() {
		Member member = new Member();
		member.setId("sunrday");
		member.setPasswd("1111");
		member.setName("일요일");
		member.setAge(19);
		repository.save(member);
		log.info("객체 생성완료: {}", member);

	}

	@Test
	@Disabled
	public void createTest2() {
		Member member = new Member();
		member.setId("monday");
		member.setPasswd("1111");
		member.setName("월요일");
		member.setAge(22);
		repository.save(member);
		log.info("객체 생성완료: {}", member);

	}

	@Test
	@Disabled
	public void findAllTest() {
		List<Member> list = repository.findAll();
		log.info("리스트: {}", list);
	}

	@Test
	@Disabled
	public void findByIdTest() {
		String id = "monday";
		Optional<Member> optional = repository.findById(id);
		log.info("아이디로 회원 조회 {}", optional.get());
	}

	@Test
	@Disabled
	public void deleteTest() {
		String id = "thuesday";
		Optional<Member> optional = repository.findById(id);
		Member member = optional.get();
		repository.delete(member);
		log.info("회원 삭제 완료 {}", member);
	}

	@Test
	@Disabled
	public void countTest() {

		log.info("개수 확인 {}", repository.count());
	}

	// Query Methods Test
	@Test
	@Disabled
	public void findAllByNameContaining() {
//이름으로 찾기
		log.info("findAllByNameContaining {}", repository.findAllByNameContaining("화"));
	}

	@Test
	@Disabled
	public void findAllByIdContaining() {
//ID로 찾기
		log.info("findAllByNameContaining {}", repository.findAllByIdContaining("mon"));
	}

	@Test
	@Disabled
	public void findByIdAndPassword() {
//아이디와 패스워드를 찾기 찾기
		log.info("findAllByNameContaining {}", repository.findByIdAndPasswd("monday", "1111"));
	}

	@Test
	@Disabled
	public void findAllByRegdateBetweenTest() throws ParseException {
		// 날짜범위로 검색
		// 연월일 이냐 연월일시붙초 등이냐의 비교를 위한 포매팅 클래스를 사용
		Date from = new SimpleDateFormat("yy/MM/dd").parse("22/11/01");
		Date date = new SimpleDateFormat("yy/MM/dd").parse("22/11/30");
		List<Member> list = repository.findAllByRegdateBetween(from, date);
		log.info("날짜범위 검색 :{}, {}", list.size(), list);
	}

	@Test
	@Disabled
	public void findByjpQlTest() {
		String id = "monday";
		Member member = repository.findByjpQl(id);
		log.info("jpQL 검색 :{}", member);
	}

	@Test
	@Disabled
	public void findByAgeRangeTest() {
		int from = 10;
		int to = 20;
		List<Member> list = repository.findByAgeRange(from, to);
		log.info("SQL 검색 :{}", list);
	}
	
	@Test
	@Disabled
	public void findAllByNameContainingSortTest(){
	//List<Member> list = memberRepository.findAllByNameContaining("요", Sort.by("name")); //이름으로 ASC정렬
	//List<Member> list = memberRepository.findAllByNameContaining("요", Sort.by("name").descending()); //이름으로 DESC
	List<Member> list = repository.findAllByNameContaining("요", Sort.by("name").descending().and(Sort.by("id"))); //이름으로 DESC 하고 (같을 경우)id로 ASC로정렬
	log.info("Sort 활용 정렬 검색 :{}", list);
	}
	
	//페이징 처리

	@Test
	@Disabled
	public void findAllPaging() {
		//Pageable pageable = PageRequest.of(0, 5); //PageRequest.of(요청페이지, 페이지당 몇개씩 보여줄래?)
		//**PageRequest는 요청페이지가 0부터 시작함
		
		Sort sort = Sort.by("name").ascending();	//Sorting
		
		Pageable pageable = PageRequest.of(1, 5, sort); //요청페이지: 1, 페이지당 5개, 이름으로 정렬
		Page<Member> pageResults = repository.findAll(pageable);
		
		//요청 페이지    0부터 시작하니까 +1해줘야함
		log.info("현재 페이지 {}: " , pageResults.getNumber()+1);
		
		//페이지당 몇개씩 보여줄래?
		log.info("페이지당 목록 개수 {}: " , pageResults.getSize());
		
		//페이지당 설정 페이지 개수
		log.info("페이지당 설정 페이지 개수 {}: " , pageResults.getPageable().getPageSize());
		
		//DB 조회 후 전체 <목록> '개수'
		log.info("전체목록 개수: {}" , pageResults.getTotalElements());
		
		//DB 조회 후 전체 목록 List<Member>
		log.info("목록: {}" , pageResults.getContent()); //
		
		//DB 조회 후 전체 <페이지> 개수
		log.info("전체페이지 개수: {}" , pageResults.getTotalPages());
		
		//DB 조회 후 '현재페이지' 에서의 목록 개수
		log.info("현재페이지 목록 개수: {}" , pageResults.getNumberOfElements()); 
		
		//처음으로 여부
		log.info("처음으로 존재여부 {}: " , pageResults.isFirst());
		
		//다음 페이지 존재 여부
		log.info("다음페이지 존재여부 {}: " , pageResults.hasNext());
		
		//이전 페이지 존재 여부
		log.info("이전페이지 존재여부 {}: " , pageResults.hasPrevious());
		
		//마지막으로 여부
		log.info("마지막으로 존재여부 {}: " , pageResults.isLast());
		
		
		}
	
	
	@Test
	public void findAllByIdContainingOrEmailContaining() {
	String searchValue = "n";
	Pageable pageable = PageRequest.of(0, 2);
	Page<Member> pageResults = repository.findAllByIdContainingOrNameContaining(searchValue, searchValue,pageable);
	log.info("목록: {}" , pageResults.getContent());  //총 3개가 검색 되었다.
	log.info("전체목록 개수: {}" , pageResults.getTotalElements()); //그리고 현재 1페이지에는 2개의 목록을 보여주고 있다.
	log.info("현재페이지 목록 개수: {}" , pageResults.getNumberOfElements());
	}
	
	

}
