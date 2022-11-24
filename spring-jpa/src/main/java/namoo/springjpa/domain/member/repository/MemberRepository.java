package namoo.springjpa.domain.member.repository;

import java.util.List;
import java.util.Optional;

import namoo.springjpa.domain.member.entity.Member;

//Mybatis에서의 Mapper 역할

public interface MemberRepository {
	
	public void create(Member member);
	public List<Member> findAll();
	public Optional<Member> findById(String id);
	public void delete(String id);
	public long getCount();

}
