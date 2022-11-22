package namoo.springmybatis.domain.member.mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import namoo.springmybatis.domain.member.dto.Member;

//@Repository
@Mapper
public interface MemberMapper {
public List<Member> findByAll();
public Optional<Member> findById(String id);
public List<Member> findByAgeRange(@Param("begin") int begin, @Param("end") int end);
public List<Member> findByNameLike(String name);
//public void create(Member member);
//public void update(Member member);
//public List<Member> findBySearch(Map<String, Object> searchMap);
//public List<Member> findBySearchV2(MemberSearchCondition searchCondition);
}
