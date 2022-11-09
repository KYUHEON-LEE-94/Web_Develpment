package namoo.springbasic;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springbasic.guestbook.dto.Guestbook;
import namoo.springbasic.guestbook.service.GuestbookService;

//GuestbookServiceTest 하는 곳

@Slf4j
@SpringBootTest
public class GuestbookServiceTest {

	@Autowired
	GuestbookService guestbookService;
	
	@Autowired
	GuestbookService guestbookService2;
	
	@Test
	@Disabled
	public void registerTest() {
		Guestbook gs = new Guestbook();
		gs.setWriter("방그리");
		gs.setMessage("잘 보고 갑니다");
		guestbookService.registerGuestBook(gs);
		log.info("방명록 등록 완료!");
	}
	
	@Test
	public void findTest() {
		List<Guestbook> list = guestbookService.findGuestbooks();
		log.info("등록된 리스트 {}",list);
	}
	
	@Test
	@Disabled
	public void ScopeTest() {
		log.info("같은가?{}", guestbookService == guestbookService2);
		//prototype인 경우는 요청올떄마다 새로 생성해서 false됨
	}
	
	
}
