package namoo.servlet.factory;

import namoo.servlet.dao.StudentDao;

public interface DaoFactory {

	public StudentDao getStudentDao();
//	public Employee getEmployeeDao();
//	public UserDao getUserDao();
	
}
