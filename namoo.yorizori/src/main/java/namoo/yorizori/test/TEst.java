package namoo.yorizori.test;

import java.util.List;

import namoo.yorizori.common.factory.ServiceFactoryImpl;
import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yoroziri.cookbook.service.CookbookService;

public class TEst {
	public static void main(String[] args) {
		CookbookService test = ServiceFactoryImpl.getInstance().getCookbookService();
		
		  Cookbook cookbook = new Cookbook(); 
		  cookbook.setBookName("된장국");
		  cookbook.setBookDesc("나의 레시피"); 
		  cookbook.setAuthorId("567789");
		  
			/* test.registerCookbook(cookbook); */
		 
		 List<Cookbook> list = test.findAllCookbooks();
		 for (Cookbook cookbook2 : list) {
			System.out.println(cookbook2);
		}
		 
		 
	}
}
