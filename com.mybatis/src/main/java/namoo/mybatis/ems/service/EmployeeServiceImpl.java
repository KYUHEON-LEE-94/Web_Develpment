package namoo.mybatis.ems.service;

import java.util.List;

import namoo.mybatis.ems.dto.Employee;
import namoo.mybatis.ems.mapper.EmployeeMapper;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeMapper employeeMapper =null;
	
	public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}
	
	@Override
	public void register(Employee employee) {
		employeeMapper.create(employee);

	}

	@Override
	public List<Employee> findEmployees() {
		return employeeMapper.findAll();
	}
	

}
