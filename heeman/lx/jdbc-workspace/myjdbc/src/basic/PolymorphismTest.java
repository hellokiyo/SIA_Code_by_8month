package basic;

public class PolymorphismTest { // polymorphism = 다형성
			
	public static void main(String[] args) {
		
		// 클래스의 3가지 구성요소 : 변수, 메서드, 생성자
		
		//System.out.println(1); // line 7, 8은 둘 다 실행 메서드이지만, 서로 다르게 정의됨.*** => overload, 다형성 중에 하나
		//System.out.println("1"); // 메서드를 정의, 선언, 호출(실행) / println 메서드를 호출한 것 
		
		// change라는 메서드가 Sample 클래스 내부에 있으며
		// static이 아니므로 객체를 생성하여 호출해야 한다.
		Sample sam = new Sample();
		sam.change(333); 
		// Sample 클래스 내부에 정의된 change 메서드를 다른 클래스에서 호출하기 위해 객체(sam)를 생성해서 호출함. 
	
		//Sample.change(1);
		//Sample.change("1");
	}	
	
}

class Sample {
	
		// overload
		void change(String string) {
			System.out.println("hahaha");
		} // 메서드 정의
		
		// overload
		void change(int i) {
			
		} // 메서드 정의
	
}