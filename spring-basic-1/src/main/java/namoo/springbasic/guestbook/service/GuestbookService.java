package namoo.springbasic.guestbook.service;

import java.util.List;

import namoo.springbasic.guestbook.dto.Guestbook;

public interface GuestbookService {
	
	public void registerGuestBook(Guestbook guestbook);
	public List<Guestbook> findGuestbooks();
	
}
