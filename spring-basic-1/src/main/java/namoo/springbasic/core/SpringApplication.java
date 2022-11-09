package namoo.springbasic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
	public static void main(String[] args) {
		
		
		//스프링 컨테이너 생성 
			//스프링 컨테이너로서 기본 규격이 ApplicationContext (인터페이스)
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);	
		//내가 생성한 클래스를 컨테이너에 등록함					어노테이션으로 지정한 것들을 등록해줘~라는 느낌
		
		//스프링 컨테이너에서 빈 조회(1. 빈의 이름으로 조회)
//		Unit unit = (Unit) applicationContext.getBean("unit");
		
		// 아래처럼 어떤 타입을 할건지 설정까지 가능
//		Unit unit = applicationContext.getBean("unit", Unit.class);

		//2. 빈의 타입으로도 조회 가능 -> Unit 인터페이스를 상속받는 클래스가 많아질 경우, 조회해오는 특정 클래스를 알 수없기 때문에 오류 발생 -> 많이 사용 안함
		Unit unit = applicationContext.getBean(Unit.class);		
		unit.offense();
		unit.defense();
		
		
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
