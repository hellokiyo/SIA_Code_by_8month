package myspring;

import java.util.List;

public interface EmpService {

	void setDAO(EmpDAO dao);

	List<Emp> getEmpListByDeptNo(int deptNo) throws Exception;//메서드 선언

}
