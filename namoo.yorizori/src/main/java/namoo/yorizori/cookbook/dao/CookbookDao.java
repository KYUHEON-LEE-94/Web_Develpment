package namoo.yorizori.cookbook.dao;

import java.util.List;

import namoo.yorizori.cookbook.dto.Cookbook;

public interface CookbookDao {
	public void create(Cookbook cookbook) throws RuntimeException;

	public List<Cookbook> findAll() throws RuntimeException;
}
