package namoo.springbasic.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//Annotation을 하나씩 다 설정해야 하는 방법은 너무 번거로움..


@Configuration					//패키지 root를 기준으로 SpringContext에 bean 등록해줘~ / @Configuration는 Component도 상속받는 느낌이기 때문에 사실상 얘만 선언해도 Component를 선언한것과 같음
//@ComponentScan(basePackages = "namoo.springbasic")
//@ComponentScan(basePackages = {"namoo.springbasic", "xxx.yyy.zzz"}) //특정 위치를 여러개 지정하는 경우
@ComponentScan  //현재 이 클래스가 위치한 패키지 기준이됨 -> @SpringBootApplication이 등록되면 알아서 Component들을 읽어오기 때문에 사실상  @ComponentScan 을 할필요가없음
public class AutoAppConfig {
	
}
