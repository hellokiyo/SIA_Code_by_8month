package myjdbc;

import java.util.List;

//EmpServiceImpl이 EmpDAO를 의존하고 있구나.
public class EmpServiceImpl implements EmpService {

	//객체지향원칙: 캡슐화  > 변수는 private, 함수는 public로 해야함
	private EmpDAO dao; //EmpDAO에 대한 의존성을 필드로 선언
	
	// Spring 컨테이너가 의존성을 주입하기 위해 호출할 Setter 메소드
	// XML의 <property name="dAO"> 설정에 의해 호출됨
	public void setDAO(EmpDAO dao) {
		this.dao =dao;
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception{
		// 주입받은 dao 객체의 메소들 호출 
		return this.dao.getEmpListByDeptNo(deptNo); //의존한다.
	}

}
