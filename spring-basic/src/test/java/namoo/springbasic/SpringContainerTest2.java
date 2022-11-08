package namoo.springbasic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import namoo.springbasic.core.Marine;
import namoo.springbasic.core.Unit;
import namoo.springbasic.core.Weapon;

/*
 * ApplicationContext를 생성하지 않고 테스트하는 방법
 */

//이 Annotation을 붙이면 SpringBootApplication 클래스가 이걸 실행하라는 뜻
//SpringBootApplication 어노테이션은 자기를 기준으로 하위 패키지를 전부 ComponentScan됨
	//AutoConfig역시도 그 대상이 되어버리고 컨테이너에 싸악 올라감
		//즉 이 어노테이션 하나로 컨테이너가 생성되고, Component, configuration 어노테이션 된 것들도 전부 올렸다는 뜻
@SpringBootTest
public class SpringContainerTest2 {
	
	@Autowired
	Unit unit;

	@Autowired()
	@Qualifier("sword")
	Weapon weapon;
	
	@Test
	public void containerTest() {
		System.out.println(unit);
		unit.offense();
		unit.defense();

	}
	
	@Test
	public void containerTest2() {
		System.out.println(weapon);


	}
	
	
}
