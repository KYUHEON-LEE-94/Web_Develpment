package namoo.allinone.web.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 로그인 체크 필터 : 로그인 되지 않은 사용자는 회원 목록 등을 접근하지 못하게 설정
 */
@Component
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

	private static final String[] whitelist = { "/", "/css/*", "/fonts/*", "/js/*", "/members/register",
			"/members/signup", "/members/signin", "/members/logout" };

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestURI = httpRequest.getRequestURI();
		try {
			// 인증이 필요한 URI인지 확인
			if (!isWhiteList(requestURI)) {
				HttpSession session  = httpRequest.getSession();
				// 로그인 하지 않은 경우
				if(session.getAttribute("loginMember") == null) {
					log.info("미인증 사용자 요청 {}", requestURI);
					//이전 URI정보를 기억해서 sendrirect에 저장해서 보내줌
					httpResponse.sendRedirect("/members/signup?redirect=" + requestURI);
					return;
				}
			}
			//if문에 안걸리면 정상적으로 진행하기 위한 chain.dofileter
			chain.doFilter(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/** 화이트 리스트의 경우 인증 체크하지 않음 */
	private boolean isWhiteList(String requestURI) {
		return PatternMatchUtils.simpleMatch(whitelist, requestURI);
	}
	//Match a String against the given patterns, supporting the following simple pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an arbitrary number of pattern parts), as well as direct equality.
}
