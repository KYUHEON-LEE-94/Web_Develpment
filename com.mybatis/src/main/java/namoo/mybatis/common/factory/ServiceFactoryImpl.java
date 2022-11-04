package namoo.mybatis.common.factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import namoo.mybatis.ems.mapper.EmployeeMapper;
import namoo.mybatis.ems.mapper.UserMapper;
import namoo.mybatis.ems.service.EmployeeService;
import namoo.mybatis.ems.service.EmployeeServiceImpl;
import namoo.mybatis.ems.service.UserService;
import namoo.mybatis.ems.service.UserServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {
	
	private static ServiceFactoryImpl factory = new ServiceFactoryImpl();
	
	private EmployeeMapper employeeMapper;
	private UserMapper userMapper;
	
	SqlSessionFactory sqlSessionFactory;
	
	private ServiceFactoryImpl() {
		loadProperties();
	}
	
	public static ServiceFactoryImpl getInstance() {
		return factory;
	}
	
	private void loadProperties() {
		//src / main/resources에 있는 mybatis 설정 파일
		String mybatisConfig = "mybatis-config.xml";
		Reader reader = null;
		
		try {
			//mybatis 설정 파일 로부터 reader 객체를 생성
		reader = Resources.getResourceAsReader(mybatisConfig);
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);			
	}
	
	
	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper = sqlSessionFactory.openSession(true).getMapper(EmployeeMapper.class); 
	}
	
	public UserMapper getUserMapper() {
		return  userMapper = sqlSessionFactory.openSession(true).getMapper(UserMapper.class);
	}

	@Override
	public UserService getUserService() {
		return  new UserServiceImpl(getUserMapper());
	}
	
	@Override
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl(getEmployeeMapper());
	}
	
}
