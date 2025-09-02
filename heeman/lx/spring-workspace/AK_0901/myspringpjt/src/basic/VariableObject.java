package basic;

public class VariableObject {
	public static void main(String[] args) {
		Product product1 = new Product(); // 클래스 변수 선언과 동시에 객체 생성
		Product product2 = new Product();
		product2.price = 5000;
		System.out.println(product1.price);
		
		product1 =product2;
		System.out.println(product1.price);
		
	}
}

class Product {
	
	//1. Prodcut의 객체 변수
	int price; 
	String name;
	String maker;
	
}
