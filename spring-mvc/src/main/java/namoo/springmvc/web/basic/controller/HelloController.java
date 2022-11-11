package namoo.springmvc.web.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	//HandlerAdapter가 Model객체를 알아서 생성해서 전달해줌
	@RequestMapping("/hello3")
	public String hello(Model model) {
		String message = "Spring MVC 동작원리입니다.";
		model.addAttribute("message", message);
		return "hello";
	}

}
