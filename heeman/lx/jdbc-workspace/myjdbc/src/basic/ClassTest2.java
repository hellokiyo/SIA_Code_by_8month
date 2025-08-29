package basic;

public class ClassTest2 {

	public static void main(String[] args) {
		Util util = new Util();
		util.name = "hahaha";
		System.out.println(util.name); // hahaha 출력.
		Util util2 = new Util();
		System.out.println(util.name); // hahaha 출력. static 때문, static이 없으면 null 출력.
		
		Util.getName();
	}

}


class Util {
	static String name;
	public static String getName() {
		return name;
	}
	
}

class Sma2 {
	int count; // 인스턴스(instance) 변수, 객체변수 => 객체를 생성하고 난 후 참조 가능하기 때문
	static int amount; // 클래스 변수 => 이 클래스로 생성된 객체가 공유하기 때문
	void print() { 
		int localCount; // 로컬변수, 지역변수 => 이 지역에서만 참조 가능하다. 지역은 {} 블럭이다.
		try {
			int myCount = 500; // 로컬변수라고 해도 되지만, 특별히 '임시변수'라고도 한다. try {} 내부에서만 참조된다.
		} catch(Exception e) {
			
		}
		//System.out.println(myCount);
	}
	
}