package basic;

public class ArrayTest {

	public static void main(String[] args) {

		// array : 배열, 선언, 생성, 할당, 참조
		// int[10] list; // <= 배열을 틀리게 '선언'한 것. 배열은 선언할 때 갯수를 지정하지 않는다.
		int[] list;
		int list2[];
		// list = new int[]; // <= 배열을 틀리게 '생성'한 것. 배열을 생성할 땐 갯수를 지정해야 한다.
		list = new int[10];
		list[0] = 55;
		list[10] = 100; // 컴파일 문제는 없음. 문법이 어긋나진 않았다는 뜻. 컴파일 : '실행가능'한 코드로 변환하는 것 -> bin 폴더에 .class 파일이 만들어짐.
						// 컴파일은 실행과 다름. 컴파일은 되더라도 실행오류가 발생할 수 있음.
		
		// java의 Array : 동일타입만 가능, 만든 후 크기변경 불가 => ArrayList를 사용하는 이유
		// ArrayList => Collection API*** 검색 https://velog.io/@minsai9/Java-Collection%EC%9D%B4%EB%9E%80
		int[] list3 = {23, 45, 7, 12, 46};
		for(int ele : list3) {
			System.out.println(ele);
		}
		for(int i = 0; i < list3.length; i++) {
			System.out.println(list3[i]);
		}
		
	}

}
