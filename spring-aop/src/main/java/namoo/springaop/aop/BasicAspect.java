package namoo.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BasicAspect {
	
	/**
	 * Pointcut 종류
	 * : @Before(), @After(), @AfterReturnning(), @AfterThrowing(), @Around()
	 */
	@Before("execution(* namoo.springaop..*(..))")
	public void startLog() {
		System.out.println("===== 비즈니스 메소드 실행 전 =====");
	}

	@After("execution(* namoo.springaop..*(..))")
	public void endLog() {
		System.out.println("===== 비즈니스 메소드 실행 후 =====");
	}

	@AfterReturning(pointcut = "execution(* namoo.springaop..*(..))", returning = "returnValue")
	public void afterReturningLog(JoinPoint joinPoint, Object returnValue) {
		System.out.println(">> 실행 메소드 반환값: " + returnValue);
	}

	@AfterThrowing(pointcut = "execution(* namoo.springaop..*(..))", throwing = "exception")
	public void afterThrowingLog(JoinPoint joinPoint, Throwable exception) {
		System.out.println(">> " + joinPoint.getSignature().toShortString() + " 메소드 예외발생 : " + exception);
	}
}
