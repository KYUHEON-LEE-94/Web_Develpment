package namoo.com.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import namoo.mybatis.ems.dto.Employee;
import namoo.mybatis.ems.mapper.EmployeeMapper;

/**
 * MyBatis테스트
 */
public class MyBatisTest {
	
	private SqlSession sqlSession;

	@BeforeEach
	public void setUp() {
		String mybatisConfig = "mybatis-config.xml";
		Reader reader = null;		
		try {
			//mybatis 설정 파일 로부터 reader 객체를 생성
		reader = Resources.getResourceAsReader(mybatisConfig);
		} catch (IOException e) {
		e.printStackTrace();
		}
				
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);	
		sqlSession = sqlSessionFactory.openSession(true);		
	}
	
	
	
	@Test
	public void findAll() {
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> list = employeeMapper.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
	}
	
}
