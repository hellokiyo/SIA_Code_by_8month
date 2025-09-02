package tesk;

import java.util.List;

public interface EmpService {

	// 입사년도
	List<Emp> findEmpByYear(int year);

	// 부서번호
	List<Emp> findEmpByDeptId(int deptId);

	// 부서장이름으로 검색
	int findEmpByManagerName(String managerName);

	// 도시이름
	List<Emp> findByCity(String city);

	// 직원이름
	List<Emp> findEmpByName(String firstName);

	// 통계자료
	List<AggregateVO> printStat();

}
