package tesk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProjectMain {
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		int way = 2;

		while (way != 0) {
			System.out.println("<원하는 검색방법 번호를 입력하세요>(0 입력시 종료됩니다)");
			System.out.println("1.부서번호 2.입사년도 3.부서장번호 4.도시이름 5.직원이름 6.통계자료");
			try {
				way = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자로 다시 입력해주세요.");
				scan.nextLine();
				continue;
			}
			switch (way) {
			case 1: // 입사년도
				findEmpByYear();
				break;

			case 2: // 부서번호
				findEmpByDeptId();
				break;

			case 3: // 부서장이름으로 검색
				findEmpByManagerName();
				break;

			case 4: // 도시이름
				findByCity();
				break;

			case 5: // 직원이름
				findEmpByName();
				break;

			case 6: // 통계자료
				printStat();
				break;

			default:
				System.out.println("선택지에 없는 번호입니다.");
				break;
			}
		}
		System.out.println("-프로그램 종료-");
	}

	// 1. 입사년도
	private static void findEmpByYear() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		Scanner scan = new Scanner(System.in);
		System.out.println("입사년도 입력 : ");
		int year = scan.nextInt();

		EmpService service = (EmpService) context.getBean(EmpService.class);
		List<Emp> empList = service.findEmpByYear(year);

		for (Emp emp : empList) {
			System.out.println(emp);
		}

		System.out.println("입사년도 입력(0은 종료) : ");
		year = scan.nextInt();
	}

	// 2. 부서번호
	private static void findEmpByDeptId() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		Scanner scan = new Scanner(System.in);
		System.out.println("부서번호 입력 : ");
		int deptId = scan.nextInt();

		EmpService service = (EmpService) context.getBean(EmpService.class);
		List<Emp> empList = service.findEmpByDeptId(deptId);

		for (Emp emp : empList) {
			System.out.println(emp);
		}

		System.out.println("부서번호 입력(0은 종료) : ");
		deptId = scan.nextInt();
	}

	// 3. 부서장 성으로 ID찾기
	private static void findEmpByManagerName() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		Scanner scan = new Scanner(System.in);
		System.out.println("부서장 이름 입력 : ");
		String managerName = scan.nextLine();

		EmpService service = (EmpService) context.getBean(EmpService.class);
	
		int deptId = service.findEmpByManagerName(managerName);
		
		System.out.println(deptId);
	}

	// 4. 도시이름
	static void findByCity() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		Scanner scan = new Scanner(System.in);
		System.out.println("도시이름 입력 : ");
		String city = scan.nextLine();

		EmpService service = (EmpService) context.getBean(EmpService.class);
		List<Emp> empList = service.findByCity(city);

		for (Emp emp : empList) {
			System.out.println(emp);
		}

		System.out.println("도시이름 입력(0은 종료) : ");
		city = scan.nextLine();
	}
	
	// 5. 직원이름
	static void findEmpByName() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		Scanner scan = new Scanner(System.in);
		System.out.println("직원이름 입력 : ");
		String firstName = scan.nextLine();

		EmpService service = (EmpService) context.getBean(EmpService.class);
		List<Emp> empList = service.findEmpByName(firstName);

		for (Emp emp : empList) {
			System.out.println(emp);
		}

		System.out.println("직원이름 입력(0은 종료) : ");
		firstName = scan.nextLine();
	}

	// 6. 통계함수 출력
		static void printStat() {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

			EmpService service = (EmpService) context.getBean(EmpService.class);
			List<AggregateVO> empList = service.printStat();

			for (AggregateVO emp : empList) {
				System.out.println(emp);
			}

		}
	
}
