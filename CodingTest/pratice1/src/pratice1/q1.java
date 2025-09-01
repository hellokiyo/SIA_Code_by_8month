package pratice1;

import java.util.Arrays;
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
		
		//문자열 받기
		String input = sc.nextLine();
		
		int max = Arrays.stream(input.trim().split("\\s+"))
		//trim() => 입력받은 문자열 앞뒤 공백, split("\\s+")) => " " 기준으로 나눔
		//Arrays.stream() => Stream으로 변환
								.mapToInt(Integer::parseInt) // 문자열을 정수형으로 형변환
								.max()
								//최댓값찾기 OptionalInt(값이 없음)반환
								.orElseThrow();// 값이 없으면 예외 던지고, 있으면 최댓값 반환
		// .orElse(defaultValue)와 .orElseThrow()의 차이점
		// .orElse는 값이 있으면 그 값을 반환, 없으면 defaultValue를 반환함
		// .orElseThrow() 값이 있으면 그 값을 반환, 없으면 예외를 던짐
		// 기본값으로 대체할 거냐 (orElse), 없으면 아예 프로그램 터뜨릴 거냐 (orElseThrow)의 차이
		System.out.println("최댓값은 > " + max);
	}
	
}
