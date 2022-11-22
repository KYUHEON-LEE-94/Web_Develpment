package namoo.springaop.aop;
//공통 관심사항(공통 기능)정의
//하나 이상의 AdivcE(공통기능)와 PintCut(기능을 적용하는 조건) 정의

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class TimeTraceAspect {

	//적용할 Advice정의
	@Around("execution(* namoo.springaop..*(..))") //접근자 상관없이, springaop아래에 있는 모든 메서드에 매개변수 상관없이
	//시간 체크 및 로그 기록 공통 메서드
	public Object methodTimeTrace(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		String bizObject = joinPoint.getTarget().getClass().getName();
		String bizMethod = joinPoint.getSignature().toShortString();
		log.info("{}객체의 {}메소드 실행--------",bizObject,bizMethod);
		
		try {
			//핵심 비즈니스 객체의 메소드 호출
			return joinPoint.proceed();
		} finally {
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			log.info("실행시간{}ms",timeMs);
			log.info("{}객체의 {}메소드 끝--------",bizObject,bizMethod);
		}
	}
}
