package namoo.springmvc.web.member.controller;

import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.web.member.dto.Member;

@Controller
@Slf4j
public class HttpHeaderController {

	@GetMapping("/headers")
	public String receiveHeaders(HttpMethod httpMethod, 
								Locale locale,
								@RequestHeader("host") String host,
								@RequestHeader MultiValueMap<String, String> map,
								@CookieValue(value="saveid", required = false, defaultValue = "guest") String cookie) {
		
		log.info("요청방식 : {}",httpMethod);
		log.info("지역정보 : {}",locale);
		log.info("host : {}",host);
		log.info("모든 헤더 정보: {}",map);
		log.info("connection 정보: {}",map.get("connection"));
		log.info("쿠키: {}",cookie);
		return "hello";
		
	}
	
	/*
	 * 조건 매핑: id가 bangry인 경우만 요청 처리하고 싶을때
	 */
	@GetMapping(value ="/condition", params="id=bangry")  
	public String receiveParameter(Model model) {			
		log.info("조건 실행됨");
	return "hello";
}
}
