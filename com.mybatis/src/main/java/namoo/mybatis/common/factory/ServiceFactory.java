package namoo.mybatis.common.factory;

import namoo.mybatis.ems.service.EmployeeService;
import namoo.mybatis.ems.service.UserService;

public interface ServiceFactory {

	public UserService getUserService();
	public EmployeeService getEmployeeService();


}
