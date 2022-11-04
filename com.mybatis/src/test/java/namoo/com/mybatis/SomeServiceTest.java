package namoo.com.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import namoo.mybatis.ems.service.SomeService;

/**
 * Junit실습
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SomeServiceTest {
	SomeService someService;
	
	//각각의 테스트 메서드가 실행되기 전에 얘를 먼저 실행해달라.
	@BeforeEach
	public void init() {
		someService = new SomeService();
	}
	
	
	@Test
	@Order(2)
	@Disabled //메소드 테스트 비활성화
	public void sumTest() {
//		int result = someService.sum(2, 3);
//		System.out.println(result);
		assertEquals(30, someService.sum(20,10));
	}
	
	@Test
	@Order(1)
	@DisplayName(value = "메시지 응답 테스트")
	public void getMessageTest() {
		System.out.println(someService.getMessage());
	}
	

	
	
}
