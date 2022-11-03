package namoo.maybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import namoo.mybatis.ems.service.SomeService;

public class SomeServiceTest {

	SomeService someService;
	
	//각각의 테스트 메서드가 실행되기 전에 얘를 먼저 실행해달라.
	@BeforeEach
	public void init() {
		someService = new SomeService();
	}
	
	
	@Test
	@Disabled
	void sumTest() {
		int result = someService.sum(2, 3);
		System.out.println(result);
//		assertEquals(30, someService.sum(2, 3));
	}
	
	@Test
	void getMessageTest() {
//		int result = someService
		assertEquals(30, someService.getMessage());
	}
}
