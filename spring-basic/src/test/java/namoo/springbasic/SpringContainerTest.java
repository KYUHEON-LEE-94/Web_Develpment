package namoo.springbasic;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import namoo.springbasic.core.AutoAppConfig;
import namoo.springbasic.core.Unit;


public class SpringContainerTest {

	ApplicationContext applicationContxt = new AnnotationConfigApplicationContext(AutoAppConfig.class);
	
	@Test
	public void containerTest() {
		Unit unit = applicationContxt.getBean("marine", Unit.class);

		unit.offense();
		unit.defense();
				
		//타입으로 조회
		Unit unit2 = applicationContxt.getBean(Unit.class);	
		System.out.println("---------------------------타입조회-------------------------------");
		System.out.println(unit == unit2); //-> singleton 으로 관리된다는 것을 알 수 있음

		//등록된 빈 모두 조회
		String[] Beannames = applicationContxt.getBeanDefinitionNames();
		for (String bean : Beannames) {
			System.out.println(bean + ": "+applicationContxt.getBean(bean));
		}
		//등록된 빈 개수 조회
		int count = applicationContxt.getBeanDefinitionCount();
		System.out.println("빈개수: "+count);
	}
	
	
}
