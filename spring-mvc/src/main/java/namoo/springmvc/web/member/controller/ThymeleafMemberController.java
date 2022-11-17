package namoo.springmvc.web.member.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.web.member.dto.Member;

@Slf4j
@Controller
@RequestMapping("/members")
public class ThymeleafMemberController {

	//타임리프 사용X
	@GetMapping("/register")
	public String registerForm() {
		return "member/registerForm";
	}
	
	//타임리프 사용
	@GetMapping("/register2")
	public String registerForm2(Model model) {
		//빈화면 일경우에는 빈객체를 하나 전달해줘야함
		Member member = new Member();
		model.addAttribute("member", member);
		
		return "member/registerForm2";
	}
	
	@GetMapping("/{id}/edit")
	public String editForm(@PathVariable("id") String id, Model model) {
	// DB에서 회원아이디로 회원정보 조회 가정
	//Member member = memberService.findMember(id);
	Member member = new Member("bangry", "1111", "김기정", 10);
	model.addAttribute("member", member);
	
	return "member/editForm";
	}

}
