package namoo.mybatis.ems.mapper;

import java.util.List;
import java.util.Map;

import namoo.mybatis.ems.dto.Employee;

// EmployeeMapper.xml의 namespace와 완벽하게 일치
public interface EmployeeMapper {
	
	/** 사원 전체 목록 조회 */
	public List<Employee> findAll();
	
	/** 사원번호로 사원 조회*/
	public Employee findById(int id);
	
	/** 성으로 사원 조회*/
	public List<Employee> findByLastName(String lastName);
	
	public List<Employee> findBySalaryRange(Map<String,Integer> map);
	
	/** 사원 등록 */
	public void create(Employee employee);
		
	
	/** 사원 정보 수정 */
	public void update2(Employee employee);
	
	/** 사원 정보 삭제 */
	public void delete(int id);
}
