package namoo.yoroziri.cookbook.service;

import java.util.List;
/*
 * 요리책 관련 비즈니스 메소드 구현
 * 복잡한 비즈니스 로직의 경우 트랜잭션 관리
 * @author Lee
 */
import java.util.Map;

import namoo.yorizori.cookbook.dao.CookbookDao;
import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yorizori.receipe.dao.ReceipeDao;
import namoo.yorizori.receipe.dto.Reciepe;
import namoo.yorizori.user.dao.UserDao;

public class CookbookServiceImpl implements CookbookService {
	private CookbookDao Cookbookdao;
	private ReceipeDao ReceipeDao;

	public CookbookServiceImpl(CookbookDao Cookbookdao) {
		this.Cookbookdao = Cookbookdao;
	}

	@Override
	public void registerCookbook(Cookbook cookBoock) {		
		Cookbookdao.create(cookBoock);
	}

	@Override
	public List<Cookbook> findAllCookbooks() {
		return Cookbookdao.findAll();
	}


	@Override
	public Cookbook findCookbook(int bookId) {
		return Cookbookdao.findCookbook(bookId);
	}

	@Override
	public List<Map<String, Object>> finAllCookbooksWithName() {
		return Cookbookdao.finAllCookbooksWithName();
	}
	
	//레시피 기능 등록
	@Override
	public Reciepe findRecipeById(int reciepeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void registerRecipe(Reciepe Reciepe) {
		ReceipeDao.create(Reciepe);
	
	}

}
