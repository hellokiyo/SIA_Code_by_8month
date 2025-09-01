package addrbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import com.mysql.cj.Session;

public class AddrBookDAO {
	static String sql = "select * from employees where DEPARTMENT_ID = ";
	//static String driverClassName = "oracle.jdbc.driver.OracleDriver";
	static String connectionUrl = "jdbc:mysql://localhost:3306/newhr";
	static String userName = "root";
	static String password = "rootroot";
	static String sqlInsertDB = "insert into addrbook(AB_NAME,ab_email,ab_comdept,ab_birth,ab_tel,ab_memo) "
											+ "values(?,?,?,?,?,?)";

	/*
	 * static { try { Class.forName(driverClassName); } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); } }
	 */
	public boolean insertDB(AddrBookVO ab) throws Exception {
		boolean result= false;
		SqlSession session = SessionUtil.getSession();
		int insertedAmount = session.insert("insertDB", ab); // 결과의 갯수를 넘긴다..? 그렇기때문에 int로 함?
		session.commit();
		if(insertedAmount > 0) result =true;	
		/*
		 * Connection connection = null; connection = getConnection(); PreparedStatement
		 * pstmt = connection.prepareStatement(sqlInsertDB); try { pstmt.setString(1,
		 * ab.getAbName()); //AB_ID,AB_NAME,ab_email,ab_comdept,ab_birth,ab_tel,ab_memo)
		 * " pstmt.setString(2, ab.getAbEmail()); pstmt.setString(3, ab.getAbComdept());
		 * pstmt.setString(4, ab.getAbBirth()); pstmt.setString(5, ab.getAbTel());
		 * pstmt.setString(6, ab.getAbMemo()); result= pstmt.execute(); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		return result;
	}
	public boolean updateDB(AddrBookVO ab) throws Exception {
		boolean result= false;
		SqlSession session = SessionUtil.getSession();
		int updatedAmount = session.insert("updateDB", ab); // 결과의 갯수를 넘긴다..? 그렇기때문에 int로 함?
		session.commit();
		if(updatedAmount > 0) result =true;	
		return result;
	}
	

	public boolean deleteDB(int abId) throws Exception {
		boolean result= false;
		SqlSession session = SessionUtil.getSession();
		int deleteId = session.delete("deleteDB",abId);
		session.commit();
		if(deleteId > 0) result =true;
		return result;
	}
	

	public List<AddrBookVO> getDBList() throws Exception {
		List<AddrBookVO> result = new ArrayList<AddrBookVO>();
		result = SessionUtil.getSession().selectList("getDBList");
		/*
		 * Connection con = getConnection(); String sql = "select * from addrbook";
		 * PreparedStatement psmt = con.prepareStatement(sql); ResultSet rs =
		 * psmt.executeQuery(); while(rs.next()) { AddrBookVO vo = new AddrBookVO();
		 * vo.setAbId(rs.getInt("ab_id")); vo.setAbName(rs.getString("ab_name"));
		 * vo.setAbEmail( rs.getString("ab_email"));
		 * vo.setAbComdept(rs.getString("ab_comdept"));
		 * vo.setAbBirth(rs.getString("ab_birth")); vo.setAbTel(rs.getString("ab_tel"));
		 * vo.setAbMemo(rs.getString("ab_memo")); result.add(vo); } con.close();
		 */
		return result;
	}

	public AddrBookVO getDB(int abId) throws Exception {
		AddrBookVO vo = new AddrBookVO();
		Connection con = getConnection();
		
		
		String sql = "select * from addrbook where ab_id = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, abId);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			vo.setAbId(rs.getInt("ab_id"));
			vo.setAbName(rs.getString("ab_name"));
			vo.setAbEmail( rs.getString("ab_email"));
			vo.setAbComdept(rs.getString("ab_comdept"));
			vo.setAbBirth(rs.getString("ab_birth"));
			vo.setAbTel(rs.getString("ab_tel"));
			vo.setAbMemo(rs.getString("ab_memo"));
		}
		con.close();
		return vo;
	}
	
	private static Connection getConnection() throws Exception  {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
