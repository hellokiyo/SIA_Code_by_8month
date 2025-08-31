package pratice1;

import java.util.Scanner;

/*
연습 문제 1: 배열의 최댓값 찾기

문제
문자열로 입력받은 정수들 중 가장 큰 수를 출력하는 프로그램을 작성하시오.

입력: 10 35 7 98 23

출력: 최댓값은 98
 */

public class q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 (숫자사이 띄워쓰기)");

		// 빈숫자 예외 방지 넣기 inputArr.length == 0 || inputArr[0].isEmpty()
		
		String[] inputArr = sc.nextLine().split(" ");//다중공백 대응 :  split("\\s+") 권장
		int[] numbers = new int[inputArr.length];
		
		for(int i = 0; i<inputArr.length; i++) {
			numbers[i] = Integer.parseInt(inputArr[i]);
		}
		
		// 위쪽 for문에서 변수에 Integer.parseInt(inputArr[i])넣고
		// for문 안에서 max값 비교해버리기
		
		int max = numbers[0];
		
		for(int i = 0; i<numbers.length; i++) { //자기자신은 제외 하기위해 i=1부터 시작하기
			if(numbers[i]>max) {
				max = numbers[i];
			}
		}
		System.out.println("최댓값은 > " + max);
	}
	
	
	
}
