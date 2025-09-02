package myspring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Repository // 이 클래스가 빈 객체로 생성되지 않으면 객체를 못 찾기 때문에 @Autowired가 되지 않음 
public class EmpDAO {

	@Autowired
	DataSource dataSource;
	@Autowired
	SqlSession session;
	
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		return session.selectList("getEmpListByDeptNod",deptNo);
		/*		/*
		 * List<Emp> result = new ArrayList<Emp>(); // db 접속 데이터를 가져와서 result에 담는다. //
		 * 커넥션을 생성한다. Connection conn = dataSource.getConnection(); // String sql =
		 * "select * from employees where job_id = ?";
		 * 
		 * // Statement를 생성한다. Statement stmt = conn.createStatement(); // Connection
		 * 인터페이스의 하위 클래스에 선언된 리턴타입이 Statement인 객체 // 쿼리를 실행하여 ResultSet을 참조한다. String
		 * sql = "select * from employees where department_id = " + deptNo; ResultSet rs
		 * = stmt.executeQuery(sql); // Statement 인터페이스에 선언된 리턴타입이 ResultSet인 객체
		 * 
		 * while (rs.next()) { // next 메서드 : ResultSet 인터페이스에 선언된 리턴타입이 ? Emp emp = new
		 * Emp(); emp.id = rs.getInt("employee_id"); emp.lastName =
		 * rs.getString("last_Name"); emp.salary = rs.getInt("salary");
		 * 
		 * result.add(emp);
		 * 
		 * }
		 */

	}

	public List<Emp> getEmpListByJobId(String jobId) throws Exception {
		return session.selectList("getEmpListByJobId",jobId);
		/*
		 * List<Emp> result = new ArrayList<Emp>(); // db 접속 데이터를 가져와서 result에 담는다. //
		 * 커넥션을 생성한다. Connection conn = dataSource.getConnection(); // Statement를 생성한다.
		 * Statement stmt = conn.createStatement(); // 쿼리를 실행하여 ResultSet을 참조한다. String
		 * sql = "select * from employees where job_id = ' " + jobId + " ' "; ResultSet
		 * rs = stmt.executeQuery(sql);
		 * 
		 * while (rs.next()) { Emp emp = new Emp(); emp.id = rs.getInt("employee_id");
		 * emp.lastName = rs.getString("last_Name"); emp.salary = rs.getInt("salary");
		 * 
		 * result.add(emp);
		 * 
		 * }
		 */
	}
}
