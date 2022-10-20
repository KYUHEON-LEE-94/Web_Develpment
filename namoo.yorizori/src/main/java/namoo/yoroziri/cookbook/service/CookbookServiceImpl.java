package namoo.yoroziri.cookbook.service;

import java.util.List;

import namoo.yorizori.cookbook.dao.CookbookDao;
import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yorizori.user.dao.UserDao;

public class CookbookServiceImpl implements CookbookService {
	CookbookDao Cookbookdao;

	public CookbookServiceImpl(CookbookDao Cookbookdao) {
		this.Cookbookdao = Cookbookdao;
	}

	@Override
	public void registerCookbook(Cookbook cookBoock) {
		

	}

	@Override
	public List<Cookbook> findAllCookbooks() {
		// TODO Auto-generated method stub
		return null;
	}

}
