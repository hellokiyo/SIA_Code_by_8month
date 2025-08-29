package myjdbc;

import java.util.Scanner;

public class Ex05 {

	/*
	 * 사용자로부터 문자열을 입력받아서 그 문자열을 숫자로 변환하여 출력하는 프로그램입니다.
	 * 
	 * 1> convert라는 메서드를 정의합니다.
	 * 
	 * A. 문자열을 전달받아서, 그 문자열을 숫자로 변환하여 리턴합니다.
	 * 
	 * B. 전달된 문자가문자열의 길이가 0이면 Exception을 발생시킨 후 메소드를 호출한 쪽으로 예외를 던집니다.
	 * 
	 * 2> main메서드에서 convert를 호출하고 결과를 출력합니다.
	 * 
	 * 3> 예외가 발생되면, “예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.”라고 출력합니다.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("숫자로 변환할 문자열을 입력하세요 : ");

		String inputStr = scan.nextLine();

		try {
			int resultNum = convert(inputStr);
			System.out.println("변환된 숫자 : " + resultNum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}

	}

	private static int convert(String inputStr) throws Exception {
		if (inputStr.length() == 0) {
			throw new Exception("문자열을 입력하지 않고 Enter키를 누르셨습니다.");
		} else {
			return Integer.parseInt(inputStr);
		}
	}

}
