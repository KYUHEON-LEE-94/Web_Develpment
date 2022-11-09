package namoo.springbasic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

//이걸 선언해주면 Log 객체 따로 선언 안해도
@Slf4j
@SpringBootTest
public class LogTest {

	
//	Log log = LogFactory.getLog(LogTest.class);
	//이 파일을 컴파일시 자동으로 만들어주는 역할을 Lombok이함
	
	@Test
	public void test() {
		String message = "고고";
		//로그는 Format클래스 처럼 사용한다.
		log.trace("trace 로그 출력");
		log.debug("debug 로그 출력");
		log.info("메시지: {},{},{}", message,"테스트","레고");
			//치환해주는 위치에 {}를 넣고 ,를 찍는다.
		log.warn("warn 로그 출력");
		log.error("error 로그 출력");
	}
	
	
	
}
