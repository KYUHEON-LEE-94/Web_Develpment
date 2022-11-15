package namoo.springmvc.web.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/*
 * @PathVariable을을 이용한 URI 템플릿 매핑하는 방법
 */
@Controller
@Slf4j
public class PathVariableController {
	//전체반중//몇반//모든 학생중/특정 학생번호
	@RequestMapping("/classes/{classId}/students/{studentId}")
	public String view(@PathVariable String classId, @PathVariable String studentId) {
		//값들이 잘 들어오는지만 확인
	log.info("반번호: {}",classId);
	log.info("학생번호: {}",studentId);
	return "hello";
	}

}

//@PathVariable은 REST API 작성에 도움주는 클래스이다.
//{ } 안의 변수명은 무엇을 입력하더라도 return 으로 지정된 곳으로 포워딩한다.