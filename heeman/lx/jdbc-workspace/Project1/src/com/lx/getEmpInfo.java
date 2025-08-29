package com.lx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class getEmpInfo {
	public static String sql = null;
	public PreparedStatement stmt = null;
	
	//1번
	public static List<Emp> getEmpInfoByName(String name) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where concat(last_name,' ',first_name) like +?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt("employee_id");
			emp.first_name = rs.getString("first_name");
			emp.last_name = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phone_number = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary= rs.getInt("salary");
			emp.commission_pct = rs.getDouble("commission_pct");
			emp.manager_id = rs.getInt("manager_id");
			emp.department_id = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}
	//2번
	public static List<Emp> getEmpInfoByHireYear(int year) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where year(hire_date) = " + year;
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt("employee_id");
			emp.first_name = rs.getString("first_name");
			emp.last_name = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phone_number = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary= rs.getInt("salary");
			emp.commission_pct = rs.getDouble("commission_pct");
			emp.manager_id = rs.getInt("manager_id");
			emp.department_id = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}
	//3번
	public static List<Emp> getEmpInfoByDepId(int dep_id) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where department_id = " + dep_id;
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt("employee_id");
			emp.first_name = rs.getString("first_name");
			emp.last_name = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phone_number = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary= rs.getInt("salary");
			emp.commission_pct = rs.getDouble("commission_pct");
			emp.manager_id = rs.getInt("manager_id");
			emp.department_id = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}
	//4번
	public static List<Emp> getEmpInfoByJobId(String job_id) throws Exception {
		
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		
		sql = "select * from employees where job_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, job_id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt("employee_id");
			emp.first_name = rs.getString("first_name");
			emp.last_name = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phone_number = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary= rs.getInt("salary");
			emp.commission_pct = rs.getDouble("commission_pct");
			emp.manager_id = rs.getInt("manager_id");
			emp.department_id = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}
	//5번
	
	public static List<Emp> add(String sql) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		//stmt.setString(1, job_id);
		while(rs.next()) {
			Emp emp = new Emp();
			emp.employee_id = rs.getInt("employee_id");
			emp.first_name = rs.getString("first_name");
			emp.last_name = rs.getString("last_name");
			emp.email = rs.getString("email");
			emp.phone_number = rs.getString("phone_number");
			emp.hire_date = rs.getString("hire_date");
			emp.job_id = rs.getString("job_id");
			emp.salary= rs.getInt("salary");
			emp.commission_pct = rs.getDouble("commission_pct");
			emp.manager_id = rs.getInt("manager_id");
			emp.department_id = rs.getInt("department_id");
			result.add(emp);
		}
		return result;
	}
	
}
