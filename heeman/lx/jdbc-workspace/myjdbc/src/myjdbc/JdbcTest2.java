package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTest2 {
	
	public static void main(String[] args) throws Exception {
		
		// Class 클래스 안에 있는 forName 메서드를 실행함. 
		// static으로 정의되어 있어서 객체생성 없이 실행.
		//Class myClass = 
		// db-info.properties
		//Class.forName("com.mysql.cj.jdbc.Driver"); // forName의 리턴타입 = Class
		//collection api class Map type
		
		
		Properties props = new Properties(); // Properties는 Hashtable의 하위 클래스
		FileReader fr = new FileReader("db-info.properties");
		props.load(fr);
		System.out.println(props.getProperty("url"));
		
		Class.forName(props.getProperty("driverClassName"));
		
		Connection conn = 
				DriverManager.getConnection(props.getProperty("url"), props.getProperty("userName"),
						props.getProperty("password"));
		
		System.out.println(conn.getClass().getName());
		String sql = "select * from employees";
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) { // rs.next() : while문의 조건. return 타입 boolean.
			// ResultSet 인터페이스에 선언된 next 메서드 실행. 인터페이스의 하위 클래스에 객체가 생성되었고, 그 객체가 실행됨.
			String lastName = rs.getString("last_name");
			int salary = rs.getInt("salary");
			System.out.println("last name = " + lastName + ", salary = " + salary);
		}
		
		conn.close();
				
		// throws 절로 정의된 forName 메서드를 호출하기 위해서는 예외처리를 해야함.
		//JdbcTest2 test = (JdbcTest2) myClass.newInstance();
		
		//JdbcTest test2 = new JdbcTest();
		
//		Connection conn = 
//				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		
	}

}
