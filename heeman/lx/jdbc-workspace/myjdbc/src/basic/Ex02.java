package basic;

public class Ex02 {

	public static void main(String[] args) {

		/*
		1부터 999까지의 100개의 임의의 수로 이루어진 배열을 생성하는 함수를 호출하여 배열을 생성한다. 
		
		2. 인덱스가 홀수인 수들을 출력하는 함수 
		3. 배열의 수들의 합을 반환하는 함수 
		4. 가장 작은 수의 위치(인덱스)를 반환하는 함수 
		5. 3의 배수만을 새로운 배열에 복사하여 리턴하는 함수
 
		option! - 배열의 수들을 한 줄에 10개씩 출력하는 함수, 이때 각 수들은 줄이 맞춰져야 함
		
		5번은 List Collection API를 사용하는 것이 더 적절한다.
		*/
		
		// 임의의 수 배열 생성
		int[] list = makeArray(); // 메서드를 '호출'했는데 메서드가 '정의'되지 않으면 오류 발생.
		
		System.out.println("생성된 무작위 배열");
        for(int i = 1; i < 100; i += 2) { 
            System.out.print(list[i] + " ");
        }
		
		
	}

	// 배열 생성 메서드 '정의'
	private static int[] makeArray() {
		int[] result = new int[100];
		for(int i = 0; i < 100; i++) {
			result[i] = (int) (Math.random() * 999) + 1;
		}
		return result;
	}
	
	// 홀수 출력 메서드
	private static int[] oddIndex() {
		int[] result1 = new int[50];
		for(int i = 1; i < 50; i++) {
			result1[i] = (int)
		}
	}
	
	
	
	// 인덱스가 홀수인 수들을 출력하는 메서드
	
	

}
