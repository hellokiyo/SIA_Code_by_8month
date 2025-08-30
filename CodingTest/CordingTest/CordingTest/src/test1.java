/*입력한 배열의 합을 구하는 프로그램을 작성하시오.
 - 입력 : 4 9 3 50 => 문자열로 입력됨
 - 출력 : 64*/

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요. 입력시 숫자사이 공백해주세요 => ex) 4 9 3 50 ");

		String[] inputArr =scan.nextLine().split(" ");
		
		int sum = 0; 
		
		for(int i = 0; i<inputArr.length; i++) {
			sum = sum + Integer.parseInt(inputArr[i]);
		}
		System.out.println("합계는 > " + sum);

		
		
		

	}


}
