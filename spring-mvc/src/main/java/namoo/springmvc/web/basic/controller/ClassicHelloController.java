package namoo.springmvc.web.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import lombok.extern.slf4j.Slf4j;

/*
 * 옛날 컨트롤러 방식
 */
@Slf4j
@Component("/hello")
public class ClassicHelloController implements Controller {

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("hello 요청 들어옴...");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		return mav;
	}

}
