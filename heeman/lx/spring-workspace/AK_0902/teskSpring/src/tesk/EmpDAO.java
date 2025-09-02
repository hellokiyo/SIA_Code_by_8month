package tesk;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {

	@Autowired
	SqlSession session;
	//입사년도로 찾기
	public List<Emp> findEmpByYear(int year){	//완
		return session.selectList("findEmpByYear", year);
	}
	
	//부서번호로 찾기
	public List<Emp> findEmpByDeptId(int deptId){	//완
		return session.selectList("findEmpByDeptId", deptId);
	}

	// 부서장이름으로 찾기
	public int findEmpByManagerName(String managerName){
		return session.selectOne("findEmpByManagerName",managerName);
	}
	
	// 도시이름으로 찾기
	public List<Emp> findByCity(String city){ //완
		return session.selectList("findByCity", city);
	}
	// 직원이름으로 찾기
	public List<Emp> findEmpByName(String firstName){ //어떻게 써도 찾게하기
		return session.selectList("findEmpByName", firstName);
	}
	// 집계함수 
	public List<AggregateVO> printStat(){
		return session.selectList("printStat");
	}
}
