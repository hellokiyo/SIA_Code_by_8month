package myjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring { // EmpMain class = main 화면 담당

	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		
		// 1. 설정 파일을 읽어 Spring 컨테이너를 생성하고 초기화합니다.
		// 주석 설명: ApplicationContext는 Bean의 생성, 관리, 조립을 담당하는 Spring의 핵심 IoC 컨테이너입니다.
		// ClassPathXmlApplicationContext로 설정 파일 불러오기 이건 spring container임
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		// 2. 컨테이너에 어떤 Bean들이 등록되었는지 확인합니다. (진단용 코드)
		// 주석 설명: getBeanDefinitionNames()는 Spring 컨테이너가 설정 파일(spring-context.xml)을 읽고 생성한
		// 모든 Bean의 이름(id) 목록을 문자열 배열로 반환합니다.
		// 이를 통해 설정이 잘 로드되었는지 확인할 수 있습니다.
		String[] nameList = context.getBeanDefinitionNames();
		for (String name : nameList)
			System.out.println(name);// 출력 결과: empService, empDAO, dataSource
		// 스프링의 빈이름 생성전략 :
		// @Repository나 @Service로 등록된 어노테이션들에 이름을 지정해주지 않으면 
		// 스프링에서 알아서 앞자리 소문자로 객체를 생성함 
		
		
		
		
		// 3. 컨테이너로부터 필요한 Bean을 이름(id)으로 요청(Look up)합니다.
        // 주석 설명: context.getBean("bean의 id") 메소드는 컨테이너가 관리하는 객체를 가져오는 역할을 합니다.
        // 여기서 "bean의 id"는 spring-context.xml 파일의 <bean> 태그에 정의된 id 속성값과 정확히 일치해야 합니다.
        // 만약 XML에 id="empService"로 되어 있는데 getBean("service")를 호출하면,
        // Spring은 "service"라는 이름의 Bean을 찾을 수 없으므로 오류(NoSuchBeanDefinitionException)를 발생시킵니다.
		EmpService service = (EmpService) context.getBean("empService");
	
		
		// 4. 의존성 주입이 완료된 객체를 사용하여 비즈니스 로직을 실행합니다.
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);

		for (Emp emp : empList) {
			System.out.println(emp);
		}

	}
}
