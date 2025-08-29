package basic;

public class CarTest {

	public static void main(String[] args) {

		Car car1 = new Car();
		car1.setName("Lightning Macqueen");
		car1.setSpeed(300);

		Car car2 = new Car();
		car2.setName("Doc Hudson");
		car2.setSpeed(300);

		Car car3 = new Car();
		car3.setName("Mater");
		car3.setSpeed(80);

		Car car4 = new Car();
		car4.setName("Sally Carrera");
		car4.setSpeed(200);
		
		
		System.out.println("[car1의 이름 : " + car1.getName() + "] [car1의 속도 : " + car1.getSpeed() + "]");
		System.out.println("--------------------------------------------------------");
		System.out.println("[car2의 이름 : " + car2.getName() + "] [car2의 속도 : " + car2.getSpeed() + "]");
		System.out.println("--------------------------------------------------------");
		System.out.println("[car3의 이름 : " + car3.getName() + "] [car3의 속도 : " + car3.getSpeed() + "]");
		System.out.println("--------------------------------------------------------");
		System.out.println("[car4의 이름 : " + car4.getName() + "] [car4의 속도 : " + car4.getSpeed() + "]");
		
	
	}

}

class Car {

	String name;

	int speed;

	
	// 생성자
	Car() {

	}

	Car(String name, int speed) {
		this.name = name;
		this.speed = speed;
	}

	
	// set
	public void setName(String name) {
		this.name = name;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	// get
	public String getName() {
		return name;
	}
	
	public int getSpeed() {
		return speed;
	}

}