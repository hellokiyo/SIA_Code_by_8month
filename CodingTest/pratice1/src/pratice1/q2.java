package pratice1;

import java.util.Arrays;
import java.util.Scanner;

/*
연습 문제 2: 홀수와 짝수 개수 세기

문제
문자열로 입력받은 정수들 중에서 홀수와 짝수의 개수를 
각각 구하는 프로그램을 작성하시오.

입력: 3 4 7 10 13 22

출력:

홀수 개수: 3
짝수 개수: 3
 */

public class q2 {

	public static void main(String[] args) {
		
		// 입력한 값 받아오기
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력해주세요 (공백 구분)");
		
		String[] input = sc.nextLine().trim().split("\\s+");
		
		long even = Arrays.stream(input)
							.mapToInt(Integer::parseInt)
							.filter(n -> n%2 == 0)
							.count();
		long odd = input.length - even;
		
		// 배열이 굳이 안담고 for문에서 int형 변수에 담아서 
		// 그 자리에서 if조건문 
		
		System.out.println("홀수 갯수 : " + odd );
		System.out.println("짝수 갯수 : " + even );
		
	}
	
}
