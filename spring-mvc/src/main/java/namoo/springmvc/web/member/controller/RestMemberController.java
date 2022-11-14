package namoo.springmvc.web.member.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.web.member.dto.Member;
/*
 * Client Side Rendering서비스를 위한 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/rest/membres") //아래에 선언된 @RequestMapping은 Class 자체에 선언된 @RequestMapping 아래의 경로로 자동적으로 묶임
public class RestMemberController {

	
		@GetMapping()  
		public String members() {		
		return "회원 목록 처리 OK!!";
		//이게 응답메시지의 바디에 들어가서 바로 쏴줌
	}
		
		//JS 공부할때, out.print("바디내용") 으로 해줬던것을 @RestController가 붙은 클래스에서 하면 이렇게만 하면됨
		
		@PostMapping()
		public String registerMember() {
			return "회원 등록 처리 OK!!";
		}
		
		@GetMapping("/{memberid}")
		public String findMember(@PathVariable String memberid) {
			return memberid+"회원 상세정보 처리 OK!!";
		}
		
		//회원 정보 수정
		@PatchMapping("/{memberid}")
		public String updateMember(@PathVariable String memberid) {
			return memberid+"회원 수정 OK!!";
		}
		
		//회원 정보 삭제
		@DeleteMapping("/{memberid}")
		public String deleteMember(@PathVariable String memberid) {
			return memberid+"회원 삭제 OK!!";
		}
		
		
}
