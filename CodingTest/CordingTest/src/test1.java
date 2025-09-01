/*입력한 배열의 합을 구하는 프로그램을 작성하시오.
 - 입력 : 4 9 3 50 => 문자열로 입력됨
 - 출력 : 66*/

import java.util.Arrays;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요. 입력시 숫자사이 공백해주세요 => ex) 4 9 3 50 ");
		
		int sum = Arrays.stream(scan.nextLine().trim().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.sum();
		System.out.println("합계 : " + sum);
		

		
		
		

	}


}
