package namoo.springjpa.domain.member.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.entity.Member3;

@Repository
@Transactional													//<bean객체 ,pk로 사용하는 데이터타입>
public interface SpringDataJpaMemberRepository extends JpaRepository<Member3, String>{
	// 기본 CRUD 메소드 제공
	// save()
	// findAll()
	// findById()
	// delete()
	

	// 회원 이름으로 검색------------------------------------
//	List<Member> findAllByName(String name); //정확하게 일치하는것
	
	// 회원 이름으로 LIKE 검색
	//List<Member> findAllByNameLike(String name);  //내가 %를 입력해줘여ㅑ함
	List<Member> findAllByNameContaining(String name);
	// 회원 아이디로 검색------------------------------------
	List<Member> findAllByIdContaining(String id);
	
	// 아이디와 비밀번호에 의한 검색------------------------------------
	Member findByIdAndPasswd(String id, String passwd);
	
	// 날짜 범위에 의한 검색 				//bean의 regdate 타입과 일치하는지 확인
	List<Member> findAllByRegdateBetween(Date from, Date to);
	
	//JPQL 사용-----------------------------------------------------------
		//사용할 JPQL을 @Query에 등록하고 사용
	@Query("select m from Member m where m.id = ?1")
	Member findByjpQl(String id);
	// 이름 기반 파라메터
	//@Query("select m from Member m where m.id = :id")
	//Member findByjpQl(@Param("id") String id);
	
	// Native SQL 사용------------------------------------------------------------
	@Query(value = "SELECT * FROM member WHERE age BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Member> findByAgeRange(int from , int to);
	
	//Sort 클래스 활용 정렬---------------------------------------------------------
	List<Member> findAllByNameContaining(String name, Sort sort); //Containing을 사용하면서 + sort
	
	//검색 추가 페이징 처리 -검색값만 받아서 조회하는 스타일
		//Id를 컨테닝해서 검색 Or 이름을 컨테이닝해서 전부 찾아와라
	Page<Member> findAllByIdContainingOrNameContaining(String id, String name, Pageable pageable );
}
