package namoo.yorizori.cookbook.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yoroziri.cookbook.service.CookbookService;

/**
 * 요리책 등록 화면 및 등록 처리 서블릿 컨트롤러
 */
@WebServlet("/cookbook/list.do")
public class CookbookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 등록 화면 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		CookbookService service = ServiceFactoryImpl.getInstance().getCookbookService();
//		List<Cookbook> list = service.findAllCookbooks();
		List<Map<String, Object>> list = service.finAllCookbooksWithName();

		request.setAttribute("CookbookList", list);
		
		request.getRequestDispatcher("/WEB-INF/views/cookbook/cookbookList.jsp").forward(request, response);
		
		//검색기능이나, 페이징 처리도 추가해보기
	}



}









