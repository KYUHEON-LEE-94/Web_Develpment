package namoo.springbasic.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import namoo.springbasic.guestbook.dto.Guestbook;
import namoo.springbasic.guestbook.repository.GuestbookRepository;

@Service
//@Scope("prototype") //그떄 그때 생성됨 Not singleton
public class GuestBookServiceImpl implements GuestbookService {

	//DI
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@Override
	public void registerGuestBook(Guestbook guestbook) {
		guestbookRepository.create(guestbook);

	}

	@Override
	public List<Guestbook> findGuestbooks() {		
		return guestbookRepository.findAll();
	}

}
