package myspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("empService") // 이름을 정의할땐 이전 이름을 찾는 곳을 찾아서 수정해줘야함 
//@Service // Spring Bean으로 생성되지 못한다. main클래스의 context.getBean("empServiceImpl")부분에서 오류가 남
public class EmpServiceImpl implements EmpService {

	@Autowired // 등록되지 않으면 아랫쪽 this.dao.getEmpListByDeptNo(deptNo)에서 오류가 남
	private EmpDAO dao;

	@Override
	public void setDAO(EmpDAO dao) {
		this.dao =dao;
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception{
		return this.dao.getEmpListByDeptNo(deptNo);
	}

}
