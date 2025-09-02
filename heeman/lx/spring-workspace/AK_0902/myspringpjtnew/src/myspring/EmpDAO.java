package myspring;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Repository // 이 클래스가 빈 객체로 생성되지 않으면 객체를 못 찾기 때문에 @Autowired가 되지 않음 
public class EmpDAO {

	@Autowired
	SqlSession session;
	
	public List<Emp> getEmpListByDeptNo(int deptNo) {
		return session.selectList("getEmpListByDeptNo",deptNo);
	}

	public List<Emp> getEmpByFirstNLastName(String firstName, String lastNmae) {
		Emp emp = new Emp();
		emp.lastName = lastNmae;
		emp.firstName = firstName;
		return session.selectList("getEmpByFirstNLastName",emp);
	}
}
