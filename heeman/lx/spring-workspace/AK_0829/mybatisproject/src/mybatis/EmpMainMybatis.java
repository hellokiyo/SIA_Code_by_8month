package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMainMybatis {
	public static void main(String[] args) throws Exception {
		String resource = "configuration.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session =factory.openSession();
		
		List<Emp> list = session.selectList("getEmpListByJobId","IT_PROG");  //리스트 전체 찾을때
		for(Emp vo : list) {
			System.out.println(vo);
		}	
			
			
			
			
			
			
			
			
			
		/*
		 * Emp vo = session.selectOne("getEmpListByDeptId",80); //하나 찾을때
		 * 
		 * List<Emp> list = session.selectList("getEmpListByDeptId",80); //리스트 전체 찾을때
		 * for(Emp vo : list) { System.out.println(vo.lastName); }
		 * 
		 */
			
		
	}
}
