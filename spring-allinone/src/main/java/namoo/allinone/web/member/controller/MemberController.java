package namoo.allinone.web.member.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import namoo.allinone.domain.member.dto.LoginForm;
import namoo.allinone.domain.member.dto.MemberForm;
import namoo.allinone.domain.member.entity.Member;
import namoo.allinone.domain.member.service.MemberService;

/**
 * Bean Validation 사용하기
 * 검증 기능을 매번 세부 컨트롤러에 자바코드로 작성해야 하는 번거로움을 없애기 위해 검증 로직을 모든 프로젝트에 적용할
 * 수 있도록 공통화하고, 표준화 시킨것이 Bean Validation 이다.
 * Bean Validation을 활용하면, 애노테이션 하나로 검증 로직을 매우 편리하게 적용할 수 있다. 
 * Bean Validation은 검증에 대한 표준 기술 명세(인터페이스와 검증 애노테이션 모음)이며, 구현체로 Hibernate Validator가 일반적으로 사용된다. 
 * 공식 사이트: http://hibernate.org/validator/ 
 * 검증 애노테이션 모음: https://docs.jboss.org/hibernate/validator/6.2/reference/en-US/html_single/#validator-defineconstraints-spec
 * Bean Validation 의존관계 추가 필요 : implementation 'org.springframework.boot:spring-boot-starter-validation'
 */
@Controller
@RequestMapping("/members")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/register")
	public String registerForm(@ModelAttribute("member") Member member) {
		return "member/registerForm";
	}

	/**
	 * build.gradle 파일에 spring-boot-starter-validation 라이브러리를 추가하면 스프링 부트는 자동으로 글로벌 Validator를 등록한다. 
	 * Validator는 @NotNull 같은 검증 애노테이션이 선언되어 있는 빈을 검증한다. 
	 * 검증이 필요한 메소드에 @Validated 만 선언하면 된다.
	 * @ModelAttribute가 선언된 폼 객체의 각각의 필드에 대한 타입 변환 시도
	 * 타입 오류가 발생하면 typeMismatch 오류코드로 FieldError 추가
	 * 타입 오류가 없으면 유효성 검증 오류 체크 
	 * 검증 오류가 발생하면, FieldError, ObjectError를 생성해서 BindingResult에 담아준다.
	 */
	@PostMapping("/register")
	public String register(@Validated @ModelAttribute("member") MemberForm member, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		// 검증 실패 시 다시 입력폼으로 포워드
		if (bindingResult.hasErrors()) {
			log.info("bindingResults : {}", bindingResult);
			// BindingResult는 모델에 자동 저장된다.
			return "member/registerForm";
		}

		// 검증 성공
		Member registerMember = new Member();
		registerMember.setId(member.getId());
		registerMember.setPassword(member.getPassword());
		registerMember.setName(member.getName());
		registerMember.setAge(member.getAge());
		
		// 회원 등록
		String userId = memberService.register(registerMember);

		redirectAttributes.addAttribute("memberId", userId);
		//새롭게 회원가입한 사람에게 [회원가입을 축하합니다.] 메시지를 보여주기 위해서
		redirectAttributes.addAttribute("status", "new");
		// 회원 상세로 리다이렉트
		return "redirect:/members/{memberId}";
	}
	
	//RequestMapping + getMapping = members/{memberID}로 매핑해주면
	//{memberId}를 REST API를 적용해서 쿼리값을 받아오고, 그 쿼리를 이용해서 DB에서 검색해오면(Optional)사용
	//model에 추가해서 view에 뿌려줌
	@GetMapping("/{memberId}")
	public String view(@PathVariable String memberId, Model model) {
		Optional<Member> optional = memberService.findMember(memberId);
		model.addAttribute("member", optional.get());
		return "member/view";
	}
	
	
	/*
	@GetMapping
	public String list(Model model) {
		List<Member> list = memberService.findMembers();
		model.addAttribute("list", list);
		return "member/list";
	}
	*/
	
	// 검색 및 페이징 처리 추가 회원 목록
	@GetMapping
	/* default page = 0, default size = 10 */
	public String listBySearchAndPaging(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search,  Model model) {
		
		Page<Member> page = memberService.findMembers(search, pageable);
		
		//조회된 총 숫자
		long totalElements = page.getTotalElements();
		List<Member> list = page.getContent();
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();
		
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("list", list);
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);
		
		return "member/list";
	}
	
	
	@GetMapping("/signup")
	public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm, @CookieValue(value = "rememberId", required = false) String rememberId, Model model) {
		if(rememberId != null) {
			loginForm.setId(rememberId);
			loginForm.setRemember(true);
		}
		return "member/loginForm";
	}
	
	@PostMapping("/signin")
	public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, 
			//LogFilter에서 검증한 param을 여기서 가져와서 활용
			            @RequestParam(name = "redirect", defaultValue = "/") String redirect, HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("로그인저장 체크 : {}", loginForm.getRemember());
		log.info("리다이렉트 : {}", redirect);
		if(bindingResult.hasErrors()) {
			// BindingResult는 모델에 자동 저장된다.
			return "member/loginForm";
		}
		
		Member loginMember = memberService.isMember(loginForm.getId(), loginForm.getPassword());
		if(loginMember == null) {
			// 글로벌 오류 생성 및 로그인화면으로 포워드
			bindingResult.reject("loginFail", "아이디 또는 비밀번호를 확인하여 주세요.");
			return "member/loginForm";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		
		// 로그인 저장 체크시
		if(loginForm.getRemember() == true) {
			Cookie cookie = new Cookie("rememberId", loginMember.getId());
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath("/");
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return "redirect:"+redirect;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session  = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	/*
	 * 1. getSession(), getSession(true)
 	- HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 세션을 생성

		2. getSession(false)
 	- HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 생성하지 않고 그냥 null을 반환
	 */
	
}
