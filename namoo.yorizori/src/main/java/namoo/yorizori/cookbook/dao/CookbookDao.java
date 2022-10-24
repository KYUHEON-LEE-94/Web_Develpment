package namoo.yorizori.cookbook.dao;

import java.util.List;
import java.util.Map;

import namoo.yorizori.cookbook.dto.Cookbook;
import namoo.yorizori.receipe.dto.Receipe;

public interface CookbookDao {
	public void create(Cookbook cookbook) throws RuntimeException;
	public List<Cookbook> findAll() throws RuntimeException;
	public Cookbook  findCookbook(int bookId) throws RuntimeException;
	public List<Map<String, Object>> finAllCookbooksWithName() throws RuntimeException;
}
