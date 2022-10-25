package namoo.yorizori.cookbook.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.common.web.YzruntimeException;
import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yorizori.receipe.dto.Reciepe;
import namoo.yoroziri.cookbook.service.CookbookService;

/**
 * Cookbook 안에 recipe가 포함되어 있기 때문에 따로 분리 안함
 * 레시피 등록 처리 서블릿 컨트롤러
 */
@WebServlet("/recipe/register.do")

@MultipartConfig(
		//이 파일 용량 이상일때만 임시 폴더에 파일 생성 - fileSizeThreshold
	fileSizeThreshold = 1024 * 1024 * 1, 
	maxFileSize = 1024 * 1024 * 10, 
	maxRequestSize = 1024 * 1024 * 15,
	location = "D:/웹개발_이규헌/workspace/namoo.yorizori/upload-img"
)
public class RecipeRegistertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** 레시피 등록 화면 조회 */
		//등록은 로그인을 해야지만 가능하기 떄문에 로그인 여부 확인
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		String loginId = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("loginId")) {
					loginId = cookie.getValue();
				}
			}
		}
		// 로그인 하지 않은 경우
		if (loginId == null) {
			throw new YzruntimeException("레시피를 등록하려면 로그인이 필요합니다.", "/user/loginform.do");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/reciepe/recipeForm.jsp").forward(request, response);
		}
	}

	/** 레시피 등록 요청 처리 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String recipeName = request.getParameter("recipe_name");
		String authorId = request.getParameter("author_id");
		String recipeTime = request.getParameter("recipe_time");
		String recipeLevel = request.getParameter("recipe_level");
		String ingredients = request.getParameter("ingredients");
		String[] seqNums = request.getParameterValues("seq_num");
		

		
		  Reciepe reciepe = new Reciepe();
		  reciepe.setReceipeName(recipeName);
		  
		  for (String seqNum : seqNums) {
			  reciepe.set(seqNum);
		  }
		  
		  reciepe.setReceipeTime(Integer.parseInt(recipeTime));
		  reciepe.setReceipeLevel(Integer.parseInt(recipeLevel));
		  reciepe.setIngredients(ingredients);
		
		
		//파일은 Part객체로 받아온다.			//name
		Part part = request.getPart("img_file_name");
		String imgFileName = part.getSubmittedFileName();
		String contentType = part.getContentType();
		
		
		// 디버깅 : 확인 후 삭제
		System.out.println(recipeName);
		System.out.println(authorId);
		System.out.println(recipeTime);
		System.out.println(recipeLevel);
		System.out.println(ingredients);
		System.out.println(seqNum1);
		System.out.println(seqNum2);
		System.out.println(seqNum3);
		System.out.println(imgFileName);
		System.out.println(contentType);
		
		CookbookService service =  ServiceFactoryImpl.getInstance().getCookbookService();
		service.registerRecipe(null);
		
		File file = new File("D:/웹개발_이규헌/workspace/namoo.yorizori/upload-img");
		//file이 없으면 파일을 생성해라~
        if (!file.exists()) {
            file.mkdirs();
        }
		// 업로드 파일 저장
		part.write(file.getAbsolutePath()+ File.separator + imgFileName);
		
		// DB 테이블 저장
//		내가 만들기
		
		// 임시 메인
		response.sendRedirect("/");
	}
}
