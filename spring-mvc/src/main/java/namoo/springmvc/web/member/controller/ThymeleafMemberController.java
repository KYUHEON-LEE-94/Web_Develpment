package namoo.springmvc.web.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.web.member.dto.Member;

@Slf4j
@Controller
@RequestMapping("/members")
public class ThymeleafMemberController {

	// 타임리프 사용X
	@GetMapping("/register")
	public String registerForm() {
		return "member/registerForm";
	}

	// 타임리프 사용
	@GetMapping("/register2")
	public String registerForm2(Model model) {
		// 빈화면 일경우에는 빈객체를 하나 전달해줘야함
		Member member = new Member();
		model.addAttribute("member", member);

		return "member/registerForm2";
	}

	@GetMapping("/{id}/edit")
	public String editForm(@PathVariable("id") String id, Model model) {
		// DB에서 회원아이디로 회원정보 조회 가정
		// Member member = memberService.findMember(id);
		Member member = new Member("bangry", "1111", "김기정", 10);
		model.addAttribute("member", member);

		return "member/editForm";
	}

	// 유효성 검증을 위한 PostMapping
//	@PostMapping("/register")
	public String register(@ModelAttribute("member") Member member, RedirectAttributes redirectAttributes,
			Model model) {

		// 검증 오류 결과 저장을 위한 Map 생성
		Map<String, String> errors = new HashMap<String, String>();
		// 키, 오류메시지

		// 폼 필드 검증
		// 아이디 검사
		if (!StringUtils.hasText(member.getId())) {
			errors.put("id", "회원 아이디는 필수입니다.");
		} else {
			if (member.getId().length() < 6 || member.getId().length() > 12) {
				errors.put("id", "회원 아이디는 6 ~ 12 사이어야 합니다.");
			}
		}

		// 비밀번호 검사
		if (!StringUtils.hasText(member.getPasswd())) {
			errors.put("password", "회원 비밀번호는 필수입니다.");
		}

		// 이름 검사
		if (!StringUtils.hasText(member.getName())) {
			errors.put("name", "회원 이름은 필수입니다.");
		}

		// 나이 검사
		if (member.getAge() == null || member.getAge() < 10 || member.getAge() > 100) {
			errors.put("age", "회원 나이는 10 ~ 100 까지 허용합니다.");
		}

		// 특정 필드가 아닌 글로벌(복합) 룰 검증
		// 예) 상품 주문 시 (상품갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 11000;
		if (totalPrice < 10000) {
			errors.put("globalError", "총 주문금액은 10,000원 이상이어야 합니다(현재 주문금액=" + totalPrice + ").");
		}

		// 검증 실패 시 다시 회원가입 폼으로 포워드
		if (!errors.isEmpty()) {
			model.addAttribute("errors", errors);
			return "member/registerForm2";
		}

		// 검증 성공 시 DB 연동 후 회원가입 상세 화면으로 쿼리스트링과 함께 리다이렉트
		redirectAttributes.addAttribute("id", member.getId());
		redirectAttributes.addAttribute("status", true);
		return "redirect:/members/{id}";
//		return "redirect:/";
	}

	@GetMapping("/{id}") // param이 없을수도 있기 때문에 default값을 설정해주는 것이 중요!! 위에 true값을 전달해주는 걸 그냥 boolean으로
							// 받아도됨
	public String view(@PathVariable("id") String id, @RequestParam(value = "status", required = false) Boolean status,
			Model model) {
		// DB에서 회원아이디로 회원정보 조회해서 찾아오기
		// Member member = memberService.findMember(id);
		Member member = new Member("아무개", "1111", id, 10);
		model.addAttribute("status", status);
		model.addAttribute("member", member);

		return "member/view";
	}

	// 회원상세페이제 회원가입한 사람이 갈수도, 이제 회원가입을 한 사람이 갈 수도 있다.
	// 그걸 status로 구분한다. 기존 회원이 갔을때는 아무런 문구도 안띄우지만, status=true인사람이 가면 회원가입을 축하합니다라고
	// 띄어주기 위함

//------------------------------bindingResult--------------------------------------------------------------------------	

//	@PostMapping("/register")                                         //이전에 내가 만든 오류 저장을 위한 map객체 역할을 함
	public String registerV2(@ModelAttribute("member") Member member, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		
		// 폼 필드 검증
		if (!StringUtils.hasText(member.getId())) {
			// 검증대상객체명, 검증실패 필드명, 오류 메시지
			FieldError fieldError = new FieldError("member", "id", "회원 아이디는 필수입니다.");
			bindingResult.addError(fieldError);
		} else {
			if (member.getId().length() < 6 || member.getId().length() > 12) {
				bindingResult.addError(new FieldError("member", "id", "회원 아이디는 6 ~ 12 사이어야 합니다."));
			}
		}
		if (!StringUtils.hasText(member.getPasswd())) {
			bindingResult.addError(new FieldError("member", "passwd", "회원 비밀번호는 필수입니다."));
		}
		if (!StringUtils.hasText(member.getName())) {
			bindingResult.addError(new FieldError("member", "name", "회원 이름은 필수입니다."));
		}
		if (member.getAge() == null || member.getAge() < 10 || member.getAge() > 100) {
			bindingResult.addError(new FieldError("member", "age", "회원 나이는 10 ~ 100 까지 허용합니다."));
		}
		// 특정 필드가 아닌 글로벌(복합) 룰 검증
		// 예) 상품 주문 시 (상품갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 9000;
		if (totalPrice < 10000) {
				//ObjectError가 부모고 FieldError가 자식
			bindingResult.addError(new ObjectError("member", "총 주문금액은 10,000원 이상이어야 합니다(현재 주문금액=" + totalPrice + ")."));
			bindingResult.addError(new ObjectError("member", "잘 되고 있나?.."));
									//field가 없기 때문에 인자 2개만 줘도 됨
		}
		// 검증 실패 시 다시 회원가입 폼으로 포워드
		if (bindingResult.hasErrors()) {

			log.info("bindingResult : {}", bindingResult);
			// BindingResult는 모델에 자동 저장된다.
			return "member/registerForm3";

		}
		// 검증 성공 시 DB 연동 후 회원가입 상세 화면으로 리다이렉트
		redirectAttributes.addAttribute("id", member.getId());
		redirectAttributes.addAttribute("status", true);
		 return "redirect:/members/{id}";
		//return "redirect:/";
	}
	
//-----------------------------------------기존값 유지하는 방법------------------------------------------------------------------------------
	@PostMapping("/register")                                        
	public String registerV3(@ModelAttribute("member") Member member, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		
		// 폼 필드 검증
		if (!StringUtils.hasText(member.getId())) {
			// 검증대상객체명, 검증실패 필드명, 오류 메시지
			FieldError fieldError = new FieldError("member", "id", member.getId(), false, null, null, "회원 아이디는 필수입니다.");
			bindingResult.addError(fieldError);
		} else {
			if (member.getId().length() < 6 || member.getId().length() > 12) {
				bindingResult.addError(new FieldError("member", "id", member.getId(), false, null, null, "회원 아이디는 6 ~ 12 사이어야 합니다."));
			}
		}
		if (!StringUtils.hasText(member.getPasswd())) {
			bindingResult.addError(new FieldError("member", "passwd", member.getPasswd(), false, null, null, "회원 비밀번호는 필수입니다."));
		}
		if (!StringUtils.hasText(member.getName())) {
			bindingResult.addError(new FieldError("member", "name", member.getName(), false, null, null, "회원 이름은 필수입니다."));
		}
		if (member.getAge() == null || member.getAge() < 10 || member.getAge() > 100) {
			bindingResult.addError(new FieldError("member", "age", member.getAge(), false, null, null, "회원 나이는 10 ~ 100 까지 허용합니다."));
		}
		// 특정 필드가 아닌 글로벌(복합) 룰 검증
		// 예) 상품 주문 시 (상품갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 9000;
		if (totalPrice < 10000) {
				//ObjectError가 부모고 FieldError가 자식
			bindingResult.addError(new ObjectError("member",null,null, "총 주문금액은 10,000원 이상이어야 합니다(현재 주문금액=" + totalPrice + ")."));
									//field가 없기 때문에 인자 2개만 줘도 됨
		}
		// 검증 실패 시 다시 회원가입 폼으로 포워드
		if (bindingResult.hasErrors()) {

			log.info("bindingResult : {}", bindingResult);
			// BindingResult는 모델에 자동 저장된다.
			return "member/registerForm3";

		}
		// 검증 성공 시 DB 연동 후 회원가입 상세 화면으로 리다이렉트
		redirectAttributes.addAttribute("id", member.getId());
		redirectAttributes.addAttribute("status", true);
		 return "redirect:/members/{id}";
		//return "redirect:/";
	}
}
