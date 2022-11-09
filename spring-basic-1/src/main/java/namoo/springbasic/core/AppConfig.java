package namoo.springbasic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ServiceFactory 역할
 *	생성된 객체간의 의존관계를 설정 (조립자)
 *
 *Autoconfig파일과 겹체서, 임시 주석
 */
//이 어노테이션이 있어야지만 Springcontext에 설정가능해짐 - 자바파일을 빈으로 설정하는 방식
// @Configuration
public class AppConfig {
	
	
	//이 메서드로 생성되는 객체를 너가 등록해줘야대!
		//Spring 설정 파일로 만들때는 그냥 클래스 이름 그대로 만들어주는게 좋음
//	@Bean("w")  //별칭도 지정 가능
	public Weapon weapon() {
		return new Gun();
	}
	
//	@Bean
	public Unit unit() {
		return new Marine("bang",1, weapon());
	}
	
	
}
