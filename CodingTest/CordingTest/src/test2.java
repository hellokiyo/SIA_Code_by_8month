
//전달받은 문자열이 회문(앞으로나 뒤로나 동일한 문자열) 
//문자열인지를체크하는 메서드를 완성하시오

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] inputStr = sc.nextLine().trim().split("");
		
		System.out.println(checkStr(inputStr));
		
	}
	
	public static String checkStr(String[] inputStr) {
		
		String output = null;
		
		for (int i = 0; i < inputStr.length; i++) {
			
			if(inputStr[i].equals(inputStr[inputStr.length-1])) {
				output = "앞뒤 문자열 같음";
			}
			
			else if(!(inputStr[i].equals(inputStr[inputStr.length-1]))) {
				output = "앞뒤 문자열 다름";
			}
			
		}
		return output;
	}
	
	
}
