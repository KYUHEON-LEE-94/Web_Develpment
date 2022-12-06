package namoo.allinone.web.common.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 웹과 관련된 공통 관심사(예: 요청마다 로그 기록, 로그인 사용자 체크 등) 처리를 위한 서블릿 필터 등록
 * - 서블릿 필터는 체인 가능하다
 * - 처리과정 : Http 요청 -> WAS -> 필터(문지기) -> 서블릿(디스패처 서블릿) -> 세부 컨트롤러)
 * - AOP는 필터와 다르게  도메인(핵심 비즈니스 영역)의 공통 관심사 처리
 */

//@Component
//@WebFilter(filterName = "logFilter", urlPatterns = "/*")
@Slf4j
public class LogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURI = httpRequest.getRequestURI();
		
		try {
			if(request.getDispatcherType() == DispatcherType.ERROR) {
				chain.doFilter(request, response);
			}
			log.info("클라이언트 요청 : {}", requestURI);
			chain.doFilter(request, response);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
