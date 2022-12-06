package namoo.allinone.domain.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import namoo.allinone.domain.member.entity.Member;

public interface MemberService {
	
	/** 회원가입 */
	public String register(Member member);
	
	/** 회원 인증 */
	public Member isMember(String id, String password);
	
	/** 회원 상세 */
	public Optional<Member> findMember(String id);

	/** 전체 회원 조회 */
	public List<Member> findMembers();
	
	/** 검색, 페이징 처리 회원 조회 */
	public Page<Member> findMembers(String searchValue, Pageable pageable);
}
