package namoo.com.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import namoo.mybatis.common.factory.ServiceFactoryImpl;
import namoo.mybatis.ems.dto.Employee;
import namoo.mybatis.ems.service.EmployeeService;

/**
 * Unit test for simple App.
 */
public class EmployeeTest {

	@Test
	@DisplayName("전체 리스트 가져오기")
	public void AllList() {
		EmployeeService service = ServiceFactoryImpl.getInstance().getEmployeeService();
		List<Employee> list = service.findEmployees();
		System.out.println(list);	
	}

}
