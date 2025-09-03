package myspring;

import java.util.List;

import org.springframework.stereotype.Component;


@Component("empService") // 이름을 정의할땐 이전 이름을 찾는 곳을 찾아서 수정해줘야함 
//@Service // Spring Bean으로 생성되지 못한다. main클래스의 context.getBean("empServiceImpl")부분에서 오류가 남
public class EmpServiceImpl implements EmpService {

	EmpDAO dao;

	public EmpServiceImpl(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo){
		return this.dao.getEmpListByDeptNo(deptNo);
	}
	
	@Override
	public List<Emp> getEmpByFirstNLastName(String firstName, String lastNmae){
		return this.dao.getEmpByFirstNLastName(firstName, lastNmae);
	}

}
