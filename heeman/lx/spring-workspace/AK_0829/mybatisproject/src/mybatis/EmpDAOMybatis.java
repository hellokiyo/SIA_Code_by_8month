package mybatis;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAOMybatis {

	/*
	 * DAO클래스 내부에서  job_id 를 전달받아서 그 직무인 직원 목록이 조회되는 메서드를
	 * mybatis를 사용하도록 수정하시고 수정된 파일의 수정된 부분을 제출하시기 바랍니다.
	 */
	
	public static List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		SqlSession session = getSession();
		result = session.selectList("getEmpListByDeptId",deptNo);
		return result;
		
	}

	public static List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		SqlSession session = getSession();
		result = session.selectList("getEmpListByJobId",jobId);
		return result;
	}

	

	private static SqlSession getSession() throws Exception{
		String resource = "configuration.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session =factory.openSession();
		return session;
	}

}
