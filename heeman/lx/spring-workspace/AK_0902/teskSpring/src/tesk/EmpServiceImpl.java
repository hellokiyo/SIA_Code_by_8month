package tesk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@Component("empService") // 이름을 정의할땐 이전 이름을 찾는 곳을 찾아서 수정해줘야함 
@Service // Spring Bean으로 생성되지 못한다. main클래스의 context.getBean("empServiceImpl")부분에서 오류가 남
public class EmpServiceImpl implements EmpService {

	@Autowired // 등록되지 않으면 아랫쪽 this.dao.getEmpListByDeptNo(deptNo)에서 오류가 남
	EmpDAO dao;

	@Override //입사년도
	public List<Emp> findEmpByYear(int year){
		return this.dao.findEmpByYear(year); 
	}
	
	@Override //부서번호
	public List<Emp> findEmpByDeptId(int deptId){
		return this.dao.findEmpByDeptId(deptId);
	}
	
	@Override //부서장성으로 ID 검색
	public int findEmpByManagerName(String managerName){
		return (int)this.dao.findEmpByManagerName(managerName);
	}
	
	@Override //도시이름
	public List<Emp> findByCity(String city){
		return this.dao.findByCity(city);
	}
	
	@Override //직원이름
	public List<Emp> findEmpByName(String firstName){
		return this.dao.findEmpByName(firstName);
	}
	
	@Override //통계자료
	public List<AggregateVO> printStat(){
		return this.dao.printStat();
	}
	

}
