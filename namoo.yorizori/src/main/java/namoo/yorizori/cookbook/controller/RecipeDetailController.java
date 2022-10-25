package namoo.yorizori.cookbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookbook 안에 recipe가 포함되어 있기 때문에 따로 분리 안함
 * 레시피 등록 처리 서블릿 컨트롤러
 */
@WebServlet("/recipe/detail.do")

@MultipartConfig(
		//이 파일 용량 이상일때만 임시 폴더에 파일 생성 - fileSizeThreshold
	fileSizeThreshold = 1024 * 1024 * 1, 
	maxFileSize = 1024 * 1024 * 10, 
	maxRequestSize = 1024 * 1024 * 15,
	location = "D:/웹개발_이규헌/workspace/namoo.yorizori/upload-img"
)
public class RecipeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 레시피 등록 화면 조회 */
		//등록은 로그인을 해야지만 가능하기 떄문에 로그인 여부 확인
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			request.getRequestDispatcher("/WEB-INF/views/reciepe/recipeDetail.jsp").forward(request, response);
		
	}

	/** 레시피 등록 요청 처리 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}
}
