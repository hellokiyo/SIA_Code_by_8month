package myjdbc;

public class ExceptionTest1 { // 예외처리

	public static void main(String[] args) {

		System.out.println("start");
		try {
			System.out.println("inside");
			printHello(-5);
			System.out.println("inside end");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} // 메서드 호출 오류. throws 절로 정의된 메서드를 호출하려면 예외를 처리해야 함.
		System.out.println("end");
	}

	private static void printHello(int count) throws Exception {
		if (count <= 0)
			throw new Exception("마이너스는 안되거든요!"); // new가 붙어있음. 생성자. 객체생성.
		for (int i = 0; i < count; i++) {
			System.out.println("Hello");
		}

	}

}
