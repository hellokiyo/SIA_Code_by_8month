package tesk;


public class Emp {
	int empId, deptId, salary;
	String firstName, lastName, hireDate, email;
	String departmentName;
	
	@Override
	public String toString() {
		return "직원 찾기 >"
				+ "직원번호 = " + empId + 
				", 부서번호 = " + deptId + 
				", 급여 = " + salary + 
				", 이름 = " + firstName +
				", 성 = " + lastName + 
				", 입사년도 = " + hireDate + 
				", 이메일 = " + email + "]";
	}
}
