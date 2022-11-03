package namoo.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import namoo.mybatis.ems.dto.Employee;
import namoo.mybatis.ems.mapper.EmployeeMapper;

public class MybatisTestExample2 {
	
	//SQL문을 저장해둔 xml파일 경로를 먼저 변수 선언
	private static final String namespace = "namoo.mybatis.ems.mapper.EmployeeMapper";
	
	public static void main(String[] args) {
		//src / main/resources에 있는 mybatis 설정 파일
		String mybatisConfig = "mybatis-config.xml";
		Reader reader = null;
		
		try {
			//mybatis 설정 파일 로부터 reader 객체를 생성
		reader = Resources.getResourceAsReader(mybatisConfig);
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);	
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//Mapper Interface 사용
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		System.out.println("동적 구현체: "+employeeMapper);
	
		
		//전체 조회
		List<Employee> list = employeeMapper.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		System.out.println("---성으로 조회----");
		//성으로 사원 조회
		list = employeeMapper.findByLastName("B%");
		System.out.println(list);
		
		System.out.println("---JOIN으로 조회----");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("max", 4000);
		map.put("min", 2000);
	
		list = employeeMapper.findBySalaryRange(map);
		System.out.println(list);
		

	}
}
