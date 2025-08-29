package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest5 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
			Statement stmt = con.createStatement();
			String sql = "select * from employees";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String lastName = rs.getString("last_name");
				System.out.println(lastName);
			} // try 절의 () 안에 선언된 변수는 try
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
