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

public class MybatisTestExample {
	
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
		
		//SqlSessionFactoryBuilder() -> sqlSessionFactorty를 생성하는 Factory. 가 제공하는 build(Reader객체)를 주면 SqlSessionFactory를 생성
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);	
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "product");
		// -> "mybatis-config.xml";에 있는 <environments id="development">의 default타입을 두번째 인자에 주면 해당 태그에 저장된 내용으로 사용할수 잇음
		
		SqlSession sqlSession = sqlSessionFactory.openSession(); // Auto Commit
		/*
		 * SqlSession sqlSession = sqlSessionFactory.openSession(false); // Not Auto
		 * Commit sqlSession.commit(); //-> false인 상태에서는 내가 commit을 해주면됨
		 * sqlSession.rollback();
		 */
		System.out.println("sqlSession 생성 완료.."+sqlSession);
		
		System.out.println("==================== 전체사원 조회 ========================");
		
//		  List<Employee> employeeList = sqlSession.selectList("namoo.mybatis.ems.mapper.EmployeeMapper.findAll");
//		  List<Employee> employeeList = sqlSession.selectList(namespace+".findAll");
//		  
//		  for (Employee employee : employeeList) { 
//			  System.out.println(employee); 
//			  }
		  
//		  System.out.println("==================== 사원번호로 사원조회 ========================"); 
		  int id = 200;
//		  Employee employee = sqlSession.selectOne(namespace + ".findById", id); 
//		  System.out.println(employee);
	  
		  System.out.println("==================== 사원번호로 급여조회 ========================"); 
		  int salary = sqlSession.selectOne(namespace + ".findBySalary", id);
		  System.out.println("받는 급여 : " + salary);
//		  
//		  System.out.println("==================== 급여범위로 사원 조회 ========================");
//		  Map<String, Integer> map = new HashMap<String, Integer>();
//		  map.put("min", 3000); 
//		  map.put("max", 5000); 
//		  List<Employee> list = sqlSession.selectList(namespace + ".findBySalaryRange", map); 
//		  for (Employee emp : list) { 
//			  System.out.println(emp); 
//			  }
		 
	}
}
