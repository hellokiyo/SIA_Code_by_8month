package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpMain2 {  // EmpMain class = main 화면 담당

	public static void main(String[] args) throws Exception {
		
		// 부서번호를 입력받아서 그 부서에 근무하는 사원들의 목록을 출력함
		System.out.println("job_id : ");
		Scanner scan = new Scanner(System.in);
		String jobId = scan.nextLine();
		while(jobId != null && jobId.length() != 0) {
		System.out.println(jobId);
		
		// 부서번호를 전달받아서 그 부서의 부서원 정보를 리턴함
		List<Emp> empList = EmpDAO.getEmpListByJobId(jobId); // Emp class = 데이터 저장. EmpDAO class = DB 접속.
		for(Emp emp : empList) {
			System.out.println(emp);
		}
		System.out.println("job_id(종료 : 엔터) : ");
		jobId = scan.nextLine();
		}
	}

	private static List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {

		List<Emp> result = new ArrayList<Emp>();
		// db 접속 데이터를 가져와서 result에 담는다.
		// 커넥션을 생성한다.
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		// Statement를 생성한다.
		Statement stmt = conn.createStatement();
		// 쿼리를 실행하여 ResultSet을 참조한다.
		String sql = "select * from employees where department_id = " + deptNo;
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Emp emp = new Emp();
			emp.id = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_Name");
			emp.salary = rs.getInt("salary");
			
			result.add(emp);
			
		}
		return result;
		
	}

}
