package namoo.springaop.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

	//대충 비즈니스 로직이라고 가정
	@Override
	public void join() {
		log.info("회원가입 완료");

	}

	@Override
	public List<String> findMembers() {
		log.info("회원 전체 목록 반환 완료..");
		List<String> members = new ArrayList<String>();
		members.add("강아지");
		members.add("고양이");
		return members;
	}

}
