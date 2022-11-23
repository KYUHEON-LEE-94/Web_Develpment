package namoo.springmybatis.domain.guestbook.mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import namoo.springmybatis.domain.guestbook.dto.Guestbook;
import namoo.springmybatis.domain.member.dto.Member;
import namoo.springmybatis.domain.member.dto.MemberSearchCondition;

//@Repository
@Mapper
public interface GuestbookMapper {
	public List<Guestbook> findByAll();

	public void create(Guestbook guestBook);
}
