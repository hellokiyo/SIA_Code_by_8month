package pratice1;

import java.util.Arrays;
import java.util.Scanner;

/*
연습 문제 3: 평균 구하기

문제
문자열로 입력받은 정수들의 **평균값(소수점 첫째 자리까지)**을 구하는 프로그램을 작성하시오.

입력: 5 8 12 20

출력: 평균은 11.3
 */

public class q3 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	String[] input = sc.nextLine().trim().split("\\s+");
	
	double avg = Arrays.stream(input) //스트림 생성
						.mapToDouble(Double::parseDouble) //더블형으로 형변환
						.average() //평균 구하기
						.orElse(Double.NaN);// 예외처리(만약 비어있다면 NaN(Not a Number)으로 표시)
	
	
	System.out.println("평균은 : " + String.format("%.1f", avg));
	
	
	}
}
