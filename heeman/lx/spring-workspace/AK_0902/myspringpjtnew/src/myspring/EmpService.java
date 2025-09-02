package myspring;

import java.util.List;

public interface EmpService {

	List<Emp> getEmpListByDeptNo(int deptNo);//메서드 선언
	List<Emp> getEmpByFirstNLastName(String firstName, String lastNmae);
}
