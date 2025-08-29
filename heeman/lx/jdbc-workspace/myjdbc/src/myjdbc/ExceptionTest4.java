package myjdbc;

public class ExceptionTest4 {

	public static void main(String[] args) {
		try {
			print(); // print 메서드가 throws 절로 정의 되어있어서 예외처리 후 호출 해야함.
		} catch(RuntimeException e) {
			
		}
		/*
		 * compile time exception, runtime exception : RuntimeException의 하위 클래스에 있는 예외
		 * checked exception, unchecked exception
		 */
	}

	private static void print() throws RuntimeException {
		if (true)
			throw new RuntimeException("haha");

	}

}
