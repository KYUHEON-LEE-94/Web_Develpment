package namoo.springmybatis.domain.guestbook.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import namoo.springmybatis.domain.guestbook.dto.Guestbook;

//@Repository
@Mapper
public interface GuestbookService {
	public List<Guestbook> findByAll();

	public void create(Guestbook guestBook);
}
