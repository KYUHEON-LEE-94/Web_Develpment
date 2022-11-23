package namoo.springmybatis.domain.member.mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import namoo.springmybatis.domain.member.dto.Member;
import namoo.springmybatis.domain.member.dto.MemberSearchCondition;

//@Repository
@Mapper
public interface MemberMapper {
public List<Member> findByAll();
public Optional<Member> findById(String id);
public List<Member> findByAgeRange(@Param("begin") int begin, @Param("end") int end);
public List<Member> findByNameLike(String name);

public List<Member> findBySearch(Map<String, Object> searchMap);

//최근의 트렌드에 따라 타입선택칸이 없는 통합 검색할때 사용
public List<Member> findBySearchV2(MemberSearchCondition searchCondition);

public void update(Member member);

//public void create(Member member);
}
