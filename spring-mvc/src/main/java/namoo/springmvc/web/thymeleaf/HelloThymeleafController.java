package namoo.springmvc.web.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloThymeleafController {

	@GetMapping("/thymeleaf/hello")
	public String hello(Model model) {
		model.addAttribute("message","안녕. 타임리프!!!!");
		model.addAttribute("message2","안녕2. <b>타임리프!!!!</b>");
		return "hello";
	}
	
}
