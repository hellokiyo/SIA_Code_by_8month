package myjdbc;

import java.util.List;

//EmpServiceImpl이 EmpDAO를 의존하고 있구나.
public class EmpServiceImpl implements EmpService {

	private EmpDAO empDAO;
	//객체지향원칙: 캡슐화  > 변수는 private, 함수는 public로 해야함
	
	@Override
	public void setDAO(EmpDAO empDAO) {
		this.empDAO =empDAO;
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception{
		return this.empDAO.getEmpListByDeptNo(deptNo); //의존한다.
	}

}
