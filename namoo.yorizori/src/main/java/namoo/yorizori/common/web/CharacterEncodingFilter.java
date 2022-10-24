package namoo.yorizori.common.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/***
 * 모든 서블릿의 공통 인코딩 필터
 * @author Lee KyuHeon
 *
 */

//3.0버전 이상에서 Encoding필터 등록하는 방법
@WebFilter(
		//모든.do의 서블릿을 등록해놓음
		urlPatterns = {"*.do"},
		initParams = {
				@WebInitParam(name ="encoding", value="utf-8")
				}
		)
public class CharacterEncodingFilter implements Filter {
	private String encoding;

	/**
	 * Web.xml에 있는 코드를 init시에 읽어옴
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//요청 전처리 공통 기능
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		//
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {}
	

}
