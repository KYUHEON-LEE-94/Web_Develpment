package namoo.springmybatis.web.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import namoo.springmybatis.domain.guestbook.dto.Guestbook;
import namoo.springmybatis.domain.guestbook.service.GuestbookService;
import namoo.springmybatis.domain.guestbook.service.GuestbookServiceImpl;

@Controller
@Slf4j
public class GuestbookController {
	
	@Autowired
	private GuestbookServiceImpl service;
	
	// 타임리프 사용X
	@GetMapping("/guestbook")
	public String show(Model model) {

		List<Guestbook> guestbook = service.findByAll();
		model.addAttribute("guestbook",guestbook);
		return "guestbook";
	}
	
	@PostMapping("/guestbook")
	public String getting(@ModelAttribute("guestbook")Guestbook guestbook) {
		Guestbook guest = new Guestbook();
		guest.setContents(guestbook.getContents());
		guest.setWriter(guestbook.getWriter());
		
		service.create(guest);
		
		return "guestbook";
	}

}
