package basic;

public class LiteralTest {
	
	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		// 자료형 1(int), 1.0(double), 1.0f(float), '1'(char), "1"(String)
		//float myf = 1.0; // 오류 발생. (1.0은 double 타입의 Literal)
		float myf2 = (float)1.0; // 형변환
		double myf5 = 1.0f; // 자동 형변환. double은 float보다 큰 자료형
		float myf3 = 1.0f;
		double myf4 = 1.0;
		
	
		int num = '1';
		System.out.println(num);
		
		int num1 = 50;
		System.out.println((char)num);
		
		int num2 = 50 / 40 * 5;
		System.out.println(num2);
		
		System.out.println("Hello".length());
		
	}
}


