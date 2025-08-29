package basic;

public class FunctionTest {

	public static void main(String[] args) {

		print(5); // 컴파일 오류 => 문법이 어긋나서 컴파일이 안된다는 뜻. 컴파일 오류는 주로 문법 오류로 발생. 
		// 메서드를 호출(call),실행(execute) 했는데 존재하지 않는다.
		// 메서드 정의, 선언, 실행, 호출
		// 메서드 이름, 전달받는 데이터, 리턴  java code convention : https://www.oracle.com/docs/tech/java/codeconventions.pdf
		// 메서드의 이름은 
	}

	// 메서드 정의 define, definition
	// 함수를 왜 사용해야 하나?
	// 1. 중복코드 제거
	// 2. 코드를 이해하기 편하기 위해서
	private static int print(int count) {
		int result = 0;
		for(int i = 0; i < count ; i++) { 
			System.out.println("Hello");
			result += i;
		}
		return result;
		
	}
	
}
