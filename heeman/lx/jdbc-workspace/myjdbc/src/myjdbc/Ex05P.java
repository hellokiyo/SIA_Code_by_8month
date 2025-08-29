package myjdbc;

public class Ex05P {

	public static void main(String[] args) {
		Scanner scan = new Scanner
	}

	private static int convert(String str) throws Exception {
		if(str.length() == 0) throw new Exception("그냥 엔터를 치셨군요!");
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch(NumberFormatException e) {
			throw new Exception("숫자를 변환할 수 없습니다.");
		}
		return result;
	}

}
