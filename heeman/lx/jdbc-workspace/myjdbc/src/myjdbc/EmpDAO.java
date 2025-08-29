package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpDAO {

	public static List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		
		// 코드는 건들지 문자열만 변경하면 된다.
		// java.sql = package(클래스를 모아놓은 것). 클래스 이름 앞에 소문자로 붙어있음.
		
		List<Emp> result = new ArrayList<Emp>();
		// db 접속 데이터를 가져와서 result에 담는다.
		// 커넥션을 생성한다.
		Connection conn = // Connection 타입의 객체
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where job_id = ?"
				
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

	public static List<Emp> getEmpListByJobId(String jobId) throws Exception {

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
