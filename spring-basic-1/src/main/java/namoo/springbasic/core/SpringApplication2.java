package namoo.springbasic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ComponentScan을 이용해서 의존관계와 자동 빈등록한 것을 사용하는 App
 *
 */
public class SpringApplication2 {
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);	
		//이름으로 찾기
		Unit unit = applicationContext.getBean("marine", Unit.class);

		unit.offense();
		unit.defense();
				
		//타입으로 조회
		Unit unit2 = applicationContext.getBean(Unit.class);	
		System.out.println("---------------------------타입조회-------------------------------");
		System.out.println(unit == unit2); //-> singleton 으로 관리된다는 것을 알 수 있음

		//등록된 빈 모두 조회
		String[] Beannames = applicationContext.getBeanDefinitionNames();
		for (String bean : Beannames) {
			System.out.println(bean + ": "+applicationContext.getBean(bean));
		}
		//등록된 빈 개수 조회
		int count = applicationContext.getBeanDefinitionCount();
		System.out.println("빈개수: "+count);
		
	}
}
