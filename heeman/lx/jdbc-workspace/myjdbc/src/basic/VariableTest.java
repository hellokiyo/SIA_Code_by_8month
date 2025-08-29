package basic;

public class VariableTest {

	public static void main(String[] args) {
		
		// 메모리, 할당, 이름
		// 변수는 할당*받은 메모리 공간*에 대한 이름
		int count; // 메모리를 할당받고 그 공간을 count 이름으로 참조하게 한다.
		count = 100; // 할당받은 메모리 공간에 100이라는 숫자를 기입한다.
		System.out.println(Integer.toBinaryString(count));
		count = Integer.MAX_VALUE; //MAX_VALUE : Integer 클래스에 들어있는 int 타입의 변수
		System.out.println(count);
		System.out.println(Integer.toBinaryString(count));
		
		count = count + 1;
		System.out.println(count);
		System.out.println(Integer.toBinaryString(count));
		
		count = count - 1;
		System.out.println(count);
		System.out.println(Integer.toBinaryString(count));
		
		String name = new String("Haha"); // 생성된 객체의 주소를 name 변수로 할당받은 공간에 기입한다.
	}

}
