package namoo.allinone.domain.member.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import namoo.allinone.domain.member.entity.Member;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, String>{
	// 아이디와 비밀번호에 의한 조회
	public Member findByIdAndPassword(String id, String password);
	
	// 아이디 또는 이름에 의한 검색 - 목록 페이징 처리
	Page<Member> findAllByIdOrNameContaining(String id, String name, Pageable pageable);
}
