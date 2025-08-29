package basic;

public class ClassTest {

	public static void main(String[] args) {
		
		// class 구성요소 : 메서드, 생성자, 변수
		Emp emp; // emp : Emp 타입의 변수 선언, '힙영역에 생성된 객체의 주소값'을 저장할 수 있는 메모리 공간**
				// stack 영역에 64비트 메모리 공간을 할당받아서 emp 라는 이름으로 참조하게 되고 그 공간엔 객체의 주소값을 저장할 수 있다.
		emp = new Emp(); // heap 영역에 객체를 생성하는 것. 생성자 호출. new로 시작하는 것은 생성자이다. 생성자는 꼭 없어도 된다.
		emp.count = 500;
		System.out.println(emp.count);
		change(emp);
		System.out.println(emp.count); // call by reference*** 
	}

	private static void change(Emp emp2) {
		emp2.count = 1000;
	}
	
}
class Emp {
	int count;
	
	// 생성자
	Emp() {
		System.out.println("Emp()");
	}
}
