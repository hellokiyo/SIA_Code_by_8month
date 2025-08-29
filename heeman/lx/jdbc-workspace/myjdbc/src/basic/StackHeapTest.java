package basic;

public class StackHeapTest {

	public static void main(String[] args) {
		
		int count = 500; // 기본형 4bytes 할당
		Product product; // 참조형 64bit 할당. 생성된 객체의 주소값을 저장.
		product = new Product(); // heap 영역에 객체 생성 => 할당받은 메모리 공간에 저장
		product.maker = "Samsung";
		change(product);
		System.out.println(product.maker);

	}

	private static void change(Product pro) {
		pro.maker = "Apple";
		
	}

}
