package namoo.springmvc.web.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.web.member.dto.Member;

@Slf4j
@Controller
@RequestMapping("/members") //아래에 선언된 @RequestMapping은 Class 자체에 선언된 @RequestMapping 아래의 경로로 자동적으로 묶임
public class MemberController {

	//@RequestMapping({"test1","test2"}) 배열이기 때문에 여러개 받을 수도 있기는함

		@GetMapping("/form")
		public String form(Model model) {		
			return "members/register";
		}
		
		/*
		 * 이전 방식
		 */
//		@PostMapping("/register")
//		public String register(HttpServletRequest request, Model model) {		
//			String passwd = request.getParameter("passwd");
//			String id = request.getParameter("id");
//			String name = request.getParameter("name");
//			int age = Integer.parseInt(request.getParameter("age"));
//			
//			log.info("이름: {}, 나이:{}",name,age);
//			
//			model.addAttribute("name",name);
//			model.addAttribute("age",age);
//			return "members/register-result";
//		}
		
		
//		@PostMapping("/register")  //@RequestParam(“name") String name 이렇게 쓰는게 정석이지만, 이름과 param이 같으면 아래와 같이 생략가능
//		public String register(@RequestParam String id, 
//				//required = true는 반드시 전달해달라 / 그러나 프로그램 특성상 id가 전달되지 않아도 괜찮다면 required를 false로 하고 defualt값 전달 가능
//								@RequestParam String passwd, 
//								@RequestParam String name, 
//								@RequestParam(value="age", required = true, defaultValue = "10") int  age, Model model) {		
//		
//		log.info("이름: {}, 나이:{}",name,age);
//		
//		model.addAttribute("name",name);
//		model.addAttribute("age",age);
//		return "members/register-result";
//	}
		
		/*
		 * bean 객체로 한번 받아버리기
		 */
		@PostMapping("/register")  
		public String registerV2(@ModelAttribute("member") Member member, Model model) {		
		
//		model.addAttribute("member", member);
		return "members/register-result";
	}
		
		
		
		
}
