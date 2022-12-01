package namoo.springjpa.domain.member.service;

import namoo.springjpa.domain.member.entity.Member;

public interface MemberService {
	
	public void join(Member member);
	
	public void joinV2(Member member);
	
	//@transactional을 안건 이유는 따로따로 관리할려고

}
