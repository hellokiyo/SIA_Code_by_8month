package basic;

public class InheritnaceTest {

	public static void main(String[] args) {
		// Rectangle 클래스의 print() 메서드를 실행하고 싶다.
		
		//Rectangle rect = new Rectangle();
		//rect.print();
		
		Shape shape = new Rectangle();
		shape.print(); // print = shape에 선언되어 있는 메서드. 실행은 Rectangle에서
		//shape.write(); // Shape 인터페이스에 write 메서드가 없어서 오류 발생.
	
	}

	// Shape shape = new Shape(); // 객체가 생성되지 않기 때문에 오류 발생.
	Shape shape; // 변수의 타입으로는 사용 가능함.

}

// 일종의 추상클래스, .class 파일로 존재한다. 객체생성되지 않는다. 그러나, 변수 타입으로는 생성 가능하다.
// 내부에 메서드를 선언하는 곳에 사용한다.
interface Shape {
	// 메소드 선언. declare method, 추상메서드라고도 한다. 바디{}를 갖지 않는다 = 호출할 수 없다.
	public abstract void print(); // public abstract는 없어도 자동으로 적용된다.
}

// implements Shape이라는 부분으로 인터페이스에 선언된 메서드를 정의해야 한다. 
class Rectangle implements Shape {

	@Override
	public void print() {
		
	}
	
	
	
}

//class Rectangle {
	// 정의란, {} 구간을 만드는 것이고 호출되었을 때 무엇이 실행될지를 기술해 둔다.
	//void print() {
		//System.out.println("Rectangle");
	//}


