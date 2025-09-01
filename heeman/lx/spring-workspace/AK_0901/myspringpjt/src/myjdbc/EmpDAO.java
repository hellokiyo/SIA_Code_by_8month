package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class EmpDAO {

	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
	List<Emp> result = new ArrayList<Emp>();
		// db 접속 데이터를 가져와서 result에 담는다.
		// 커넥션을 생성한다.
		Connection conn = // Connection 타입의 객체
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		//String sql = "select * from employees where job_id = ?";
				
		// Statement를 생성한다.
		Statement stmt = conn.createStatement(); // Connection 인터페이스의 하위 클래스에 선언된 리턴타입이 Statement인 객체
		// 쿼리를 실행하여 ResultSet을 참조한다.
		String sql = "select * from employees where department_id = " + deptNo;
		ResultSet rs = stmt.executeQuery(sql); // Statement 인터페이스에 선언된 리턴타입이 ResultSet인 객체

		while (rs.next()) { // next 메서드 : ResultSet 인터페이스에 선언된 리턴타입이 ?
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_Name");
			emp.salary = rs.getInt("salary");

			result.add(emp);

		}
		return result;

	}

	public List<Emp> getEmpListByJobId(String jobId) throws Exception {

		List<Emp> result = new ArrayList<Emp>();
		// db 접속 데이터를 가져와서 result에 담는다.
		// 커넥션을 생성한다.
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		// Statement를 생성한다.
		Statement stmt = conn.createStatement();
		// 쿼리를 실행하여 ResultSet을 참조한다.
		String sql = "select * from employees where job_id = ' " + jobId + " ' ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_Name");
			emp.salary = rs.getInt("salary");

			result.add(emp);

		}
		return result;
	}
}
