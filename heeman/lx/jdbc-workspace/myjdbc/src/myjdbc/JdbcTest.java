package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws Exception {

		// Class = 클래스. 클래스는 변수, 메서드, 생성자를 모아둔 것. forName = Class 클래스 안에 있는 메서드
		// forName 메서드는 Class 클래스에 static으로 정의되어 있다.
		// com.nysql.cj.jdbc.Driver 패키지
		
		// Class 클래스 안에 있는 forName 메서드를 실행함.
		Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.cj.jdbc = 패키지 Driver = 클래스. driver 클래스를 메모리에 로딩
		
		
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
			// DriverManager 클래스 안에 있는 getConnection 메서드를 실행(static으로 정의됨). => retrurn 타입 Connection. 
		
		System.out.println(conn.getClass().getName());
		
		String sql = "select * from employees";
		
		Statement stmt = conn.createStatement();
		// Connection 인터페이스의 하위 클래스 안에 있는 createStatement 메서드 실행.
		
		ResultSet rs = stmt.executeQuery(sql);
		// Statement 인터페이스의 하위 클래스 안에 있는 executeQuery 메서드 실행 => return 타입 ResultSet
		
		while(rs.next()) { // rs.next() : while문의 조건. return 타입 boolean.
			// ResultSet 인터페이스에 선언된 next 메서드 실행. 인터페이스의 하위 클래스에 객체가 생성되었고, 그 객체가 실행됨.
			String lastName = rs.getString("last_name");
			int salary = rs.getInt("salary");
			System.out.println("last name = " + lastName + ", salary = " + salary);
		}
		
		conn.close();
		

	}

}
