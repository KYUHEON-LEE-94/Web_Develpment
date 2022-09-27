package namoo.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class StudentAPP2 {

	public static void main(String[] args) throws SQLException{
		//만약 FactoryDao를 사용하지 않는다면 아래와 같이 코드의 개수가 늘어나게됨
//		BasicDataSource ds = new BasicDataSource();
//		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
//		ds.setUsername("hr");
//		ds.setPassword("hr");
//		ds.setInitialSize(10); // 풀의 초기 커넥션 개수
//		ds.setMaxTotal(100); // 최대 커넥션 개수
//		ds.setMaxIdle(10); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
//		ds.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
//		
//		StudentDao studentDao = new JDBCStudentDao(ds);
//		List<Student> list = studentDao.findAll();
//		System.out.println(list);
		
		StudentDao studentDao2 =JDBCDaoFactory.getInstance().getStudentDao();
		Student stu = studentDao2.findBySsn(1);
		System.out.println(stu);
		
	}

}
