package namoo.yorizori.common.factory;

import namoo.yorizori.user.service.UserService;
import namoo.yoroziri.cookbook.service.CookbookService;

public interface ServiceFactory {

	public UserService getUserService();

	public CookbookService getCookbookService();
}
