package namoo.springmvc.web.rest.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RequestBodyController {
	
	@PostMapping("/request-body")
	//Servlet의 Response역할
	public HttpEntity<String> processRequestBody(HttpEntity<String> httpEntity){
		String bodyMessage = httpEntity.getBody();
		log.info("바디 요청 메시지: {}", bodyMessage);
		return new HttpEntity<String>("요청 완료");
		
	}
	
	@PostMapping("/request-body2")
	//Servlet의 Response역할
	public ResponseEntity<String> processRequestBody2(RequestEntity<String> requestEntity){
		//요청은 RequestEntity로 하고 응답은 ResponseEntity로 받고
		String bodyMessage = requestEntity.getBody();
		log.info("바디 요청 메시지2번째: {}", bodyMessage);
		return new ResponseEntity<String>("데이터 생성완료", HttpStatus.CREATED); //201번 응답을 보내겠다.
		//HttpEntity와 달리 바디메시지 뿐만 아니라 추가적인 액션이 가능해짐
		
	}
	
	@PostMapping("/request-body3")
	@ResponseBody //**					//**
	public String processRequestBody3(@RequestBody String bodyMessage){
		log.info(bodyMessage);
		return bodyMessage+"를 잘 받았습니다.";

		
	}
}
