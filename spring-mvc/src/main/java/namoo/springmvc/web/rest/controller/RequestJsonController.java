package namoo.springmvc.web.rest.controller;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.web.member.dto.Member;

@Controller
@Slf4j
public class RequestJsonController {
	
	//jsp호출을 위한 Get 메서드
	@GetMapping("/request-form")
	public String register(){
		return "members/fetchRegister";
		
	}
	
	
	@PostMapping("/request-json")
	@ResponseBody
	public String processJson(@RequestBody Member member){
		return "회원 등록 처리 완료";
		
	}
	
	/*
	 * json -> object
	 * object -> json
	 */
	@PostMapping("/request-json2")
	@ResponseBody
	public Member processJson2(@RequestBody Member member){
		return member;
		
	}
}
