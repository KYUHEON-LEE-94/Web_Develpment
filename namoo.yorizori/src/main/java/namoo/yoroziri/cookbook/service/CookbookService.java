package namoo.yoroziri.cookbook.service;

import java.util.List;
import java.util.Map;

import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yorizori.receipe.dto.Reciepe;
import namoo.yorizori.user.dto.User;

public interface CookbookService {
	public void registerCookbook(Cookbook cookBoock);
	public List<Cookbook> findAllCookbooks();
	public List<Map<String, Object>> finAllCookbooksWithName();
	public Cookbook findCookbook(int bookId);
	public Reciepe findRecipeById(int reciepeId);
	public void registerRecipe(Reciepe Reciepe);
}
