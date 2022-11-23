package namoo.springmybatis.domain.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.springmybatis.domain.guestbook.dto.Guestbook;
import namoo.springmybatis.domain.guestbook.mapper.GuestbookMapper;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	
	@Autowired
	private GuestbookMapper guestbookMapper;

	@Override
	public List<Guestbook> findByAll() {
		List<Guestbook> list = guestbookMapper.findByAll();
		System.out.println(list);
		return list;
	}

	@Override
	public void create(Guestbook guestBook) {
		guestbookMapper.create(guestBook);
		
	}
	


	

	

}
