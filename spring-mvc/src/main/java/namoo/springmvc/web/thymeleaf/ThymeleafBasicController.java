package namoo.springmvc.web.thymeleaf;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.web.member.dto.Member;

@Controller
@RequestMapping("/thymeleaf")
@Slf4j
public class ThymeleafBasicController {

	@GetMapping("/variable")
	public String variableExample(Model model) {

		Member member1 = new Member();
		Member member2 = new Member();

		List<Member> list = new ArrayList<Member>();
		list.add(member1);
		list.add(member2);

		Map<String, Member> map = new HashMap<String, Member>();
		map.put("member1", member1);
		map.put("member2", member2);
		model.addAttribute("member", member1);
		model.addAttribute("list", list);
		model.addAttribute("map", map);

		return "basic/variable";
	}

	// 세션 렌더링을 위한 예시
	@GetMapping("/objects")
	public String objectExample(HttpSession httpSession) {
		httpSession.setAttribute("loginId", "bangry");
		return "basic/objects";
	}

	// -----------------------
	@Component("helloBean")
	static class HelloBean {
		// 편한 테스트를 위해 static
		public String hello(String data) {
			return "Hello " + data;

		}
	}

	// 시간과 날짜를 보여주기 위한 예시
	@GetMapping("/date")
	public String dateExample(Model model) {
		model.addAttribute("today", Calendar.getInstance());
		model.addAttribute("localDateTime", LocalDateTime.now());
		// temporals사용을 위해서는 LocalDateTime.now()를 넘겨주어야한다.
		return "basic/date";
	}

	@GetMapping("/link")
	public String linkExammple(Model model) {
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");
		return "basic/link";
	}

	@GetMapping("/literal")
	public String literalExample(Model model) {
		model.addAttribute("data", "Thymeleaf");
		return "basic/literal";
	}

	@GetMapping("/operation")
	public String operationExample(Model model) {
		model.addAttribute("data", "Spring!");
		model.addAttribute("nullData", null);
		return "basic/operation";
	}

	// 속성 추가 메서드
	@GetMapping("/attribute")
	public String attribute(Model model) {
		model.addAttribute("testClass", "TestClass");
		return "basic/attribute";
	}

	// for문 예시
	@GetMapping("/each")
	public String each(Model model) {
		Member member1 = new Member("철수", "1111", "1111", 10);
		Member member2 = new Member("영희", "2222", "2222", 20);
		List<Member> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		model.addAttribute("members", list);
		return "basic/each";
	}

	// if문 예시
	@GetMapping("/condition")
	public String conditionExample(Model model) {
		Member member1 = new Member("철수", "1111", "1111", 10);
		Member member2 = new Member("영희", "2222", "2222", 20);
		List<Member> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		model.addAttribute("members", list);

		model.addAttribute("score", 88);
		return "basic/condition";
	}

	// blokc 예시
	@GetMapping("/block")
	public String blockExample(Model model) {
		Member member1 = new Member("철수", "1111", "1111", 10);
		Member member2 = new Member("영희", "2222", "2222", 20);
		List<Member> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		model.addAttribute("members", list);
		return "basic/block";
	}

	// JS 인라인 예시
	@GetMapping("/javascript")
	public String javascript(Model model) {
		Member member = new Member("철수", "1111", "1111", 10);
		Member member1 = new Member("기영", "3333", "333", 30);
		Member member2 = new Member("영희", "2222", "2222", 20);
		List<Member> list = new ArrayList<Member>();
		list.add(member1);
		list.add(member2);
		model.addAttribute("member", member);
		model.addAttribute("members", list);
		return "basic/javascript";
	}
	
	//fragment
	@GetMapping("/main")
	public String main() {
		return "basic/main";
	}

	//템플릿 레이아웃
	@GetMapping("/main2")
	public String main2() {
		return "basic/main2";
	}
	
	@GetMapping("/main3")
	public String main3() {
	return "basic/main3";
	}
}
