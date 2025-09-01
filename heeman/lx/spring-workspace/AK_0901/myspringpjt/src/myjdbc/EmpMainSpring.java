package myjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring {  // EmpMain class = main 화면 담당

	public static void main(String[] args) throws Exception {
		int deptNo =100;
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		//ClassPathXmlApplicationContext로 설정 파일 불러오기
		EmpService service = (EmpService)context.getBean("service");
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
		
		for(Emp emp : empList) {
			System.out.println(emp);
		}
	}
}
