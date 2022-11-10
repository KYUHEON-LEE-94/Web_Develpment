package namoo.springmvc.web.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewHelloController {
	
	//hello2라는 요청이 왔을때 hello()가 실행된다.
	@RequestMapping("/hello2")
	public ModelAndView hello() {
		//DB에서 가져온거라고 가정
		String message = "Spring MVC 동작원리입니다.";
		ModelAndView mav = new ModelAndView();	
		
		mav.setViewName("hello");
		//setAttribute
		mav.addObject("message",message);
		
		// -> 반환된 이 정보들을 viewResolver를 찾고 실행
		
		return mav;
				
	}

}
