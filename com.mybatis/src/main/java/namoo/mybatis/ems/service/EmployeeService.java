package namoo.mybatis.ems.service;

import java.util.List;

import namoo.mybatis.ems.dto.Employee;

public interface EmployeeService {
	public void register(Employee employee);
	public  List<Employee> findEmployees();
	
	
}
