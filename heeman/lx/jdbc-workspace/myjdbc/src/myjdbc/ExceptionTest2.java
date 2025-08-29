package myjdbc;

public class ExceptionTest2 { // 예외처리

	public static void main(String[] args)  {

			// printHello(-5);
		
			print();
			
			// throw 절과 try/catch의 차이
			
	}

	private static void print()  {
		try {
			printHello(-5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // prinHello 메서드가 throws로 정의되어 있어서 예외처리 해야함.
		
	}

	private static void printHello(int count) throws Exception {
		if (count <= 0)
			throw new Exception("마이너스는 안되거든요!"); // new가 붙어있음. 생성자. 객체생성.
		for (int i = 0; i < count; i++) {
			System.out.println("Hello");
		}

	}

}
