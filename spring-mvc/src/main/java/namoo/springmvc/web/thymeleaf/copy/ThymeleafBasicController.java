package namoo.springmvc.web.thymeleaf.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		return "variable";
	}
}
