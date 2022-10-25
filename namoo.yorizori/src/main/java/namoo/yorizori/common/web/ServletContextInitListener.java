package namoo.yorizori.common.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * WebApplication 경로 변경을 고려해서 생성한 이벤트 서블릿
 * @author Lee KyuHeon
 *
 */
@WebListener
public class ServletContextInitListener implements ServletContextListener {
	
	//context가 시작되는 상태
	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		System.out.println("서블릿컨테이너 초기화 됨...");
		//1. WebApplication 경로를 동적으로 얻어옴
		String appName = sce.getServletContext().getContextPath();
		//2.ServletContext에 ctx라는 이름으로 경로를 저장해놓음
		sce.getServletContext().setAttribute("ctx", appName);
		
	}
}
