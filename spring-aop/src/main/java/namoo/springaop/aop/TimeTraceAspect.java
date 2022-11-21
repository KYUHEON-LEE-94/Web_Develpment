package namoo.springaop.aop;
//공통 관심사항(공통 기능)정의
//하나 이상의 AdivcE(공통기능)와 PintCut(기능을 적용하는 조건) 정의

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class TimeTraceAspect {

	//시간 체크 및 로그 기록 공통 메서드
	public Object methodTimeTrace(MethodInvocationProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		String bizObject = joinPoint.getTarget().getClass().getName();
		String bizMethod = joinPoint.getSignature().to
		return joinPoint.proceed();
	}
}
