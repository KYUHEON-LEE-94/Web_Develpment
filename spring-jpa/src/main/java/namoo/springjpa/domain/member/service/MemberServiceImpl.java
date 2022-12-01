package namoo.springjpa.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.entity.MemberHistory;
import namoo.springjpa.domain.member.repository.JpaMemberRepositoryV2;
import namoo.springjpa.domain.member.repository.MemberHistoryRepository;

@Repository
@Slf4j
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private JpaMemberRepositoryV2 memberRepository;

	@Autowired
	private MemberHistoryRepository memberHistoryRepository;

	/**
	* 회원을 등록하면서 회원이력을 함께 남기는 비즈니스 로직 처리 테스트
	*/
	public void join(Member member) {
		log.info("== MemberService.join() 호출 시작 ==");
		log.info("-- memberRepository 호출 시작 --");
		
		memberRepository.save(member);
		
		log.info("-- memberRepository 호출 종료 --");
		log.info("-- memberHistoryRepository 호출 시작 --");
		
		MemberHistory memberHistory = new MemberHistory();
		memberHistory.setMessage(member.getName());
		//memberHistory의 메시지 = member의 이름;
		memberHistory.setMember(member);
		memberHistoryRepository.save(memberHistory);
		
		log.info("-- memberHistoryRepository 호출 종료 --");
		log.info("== MemberService.join() 호출 종료 ==");
		//Required가 디폴트일때는 내부 트랜잭션에 오류가 발생하면 전체 롤백
	}

	/**
	* join()과 같은 기능을 수행
	* 회원이력 저장 시 예외가 발생하면 예외 처리
	*/
	@Override
	public void joinV2(Member member) {
		log.info("== MemberService.joinV2() 호출 시작 ==");
		log.info("-- memberRepository 호출 시작 --");
		
		memberRepository.save(member);
		
		log.info("-- memberRepository 호출 종료 --");
		log.info("-- memberHistoryRepository 호출 시작 --");
		
		MemberHistory memberHistory = new MemberHistory();
		memberHistory.setMessage(member.getName());
		memberHistory.setMember(member);
		
		try {
			memberHistoryRepository.save(memberHistory);
		} catch (RuntimeException e) {
			log.info("회원 이력 저장에 실패했습니다. historyMessage={}", memberHistory.getMessage());
		}
		
		log.info("-- memberHistoryRepository 호출 종료 --");
		log.info("== MemberService.joinV2() 호출 종료 ==");
		//REQUIRES_NEW때는 내부 트랜잭션에 오류가 발생하면 전체 롤백
	}

}
