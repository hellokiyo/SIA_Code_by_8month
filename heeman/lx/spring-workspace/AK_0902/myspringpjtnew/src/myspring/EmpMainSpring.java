package myspring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring { // EmpMain class = main 화면 담당

	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		
		EmpService service = (EmpService) context.getBean(EmpService.class); //이름으로 가져올 필요 없이 EmpService타입의 Bean객체가 있으면 그냥 가져옴
		//다형성(객체지향의 꽃) : 오버로딩, 오버라이딩 > 같은 이름으로 정의되어 있는 건 (중복정의, 중복재정의) 폴리? 
//		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
//
//		for (Emp emp : empList) {
//			System.out.println(emp);
//		}
		
		String firstName = "Steven"; 
		String lastName = null;
		List<Emp> empList =  service.getEmpByFirstNLastName(firstName, lastName);
		System.out.println(empList);	

	}
}
