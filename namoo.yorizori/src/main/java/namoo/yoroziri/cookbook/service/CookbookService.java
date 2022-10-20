package namoo.yoroziri.cookbook.service;

import java.util.List;

import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yorizori.user.dto.User;

public interface CookbookService {
	public void registerCookbook(Cookbook cookBoock);
	public List<Cookbook> findAllCookbooks();
}
