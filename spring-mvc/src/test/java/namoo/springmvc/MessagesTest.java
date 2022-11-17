package namoo.springmvc;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MessagesTest {

	@Autowired
	MessageSource messageSource;

	void messageTest() {
		// Locale 정보가 없는 경우 Locale.getDefault()을 호출해서 시스템의 기본 로케일을 사용
		// messages_ko.properties 조회 시도 ->조회 실패 시 messages.properties 조회
		String result = messageSource.getMessage("member.page.register.title", null, null);
		log.info(result);
	}

	@Test
	void messageTest2() {
		// 코드에 해당하는 메시지 없으면 NoSuchMessageException 발생
		String result = messageSource.getMessage("noCode", null, null);
		log.info(result);
	}

	@Test
	void messageTest3() {
		// 메시지가 없어도 기본 메시지(defaultMessage)를 설정해서 사용하면 기본 메시지가 반환
		String result = messageSource.getMessage("noCode", null, "기본 메시지", null);
		log.info(result);
	}

	@Test
	void messageTest4() {
		// 메시지의 {0}에 매개변수를 전달해서 치환
		String result = messageSource.getMessage("member.page.register.result", new Object[] { "김기정" }, null);
		log.info(result);
	}
	
	@Test
	void messageTest4En() {
		// 메시지의 {0}에 매개변수를 전달해서 치환
		String result = messageSource.getMessage("member.page.register.result", new Object[] { "김기정" }, Locale.ENGLISH);
		log.info(result);
	}

	@Test
	void messageTest5() {
		// 국제화 파일 선택
		String result = messageSource.getMessage("member.page.register.title", null, Locale.ENGLISH);
		log.info(result);
	}

}
