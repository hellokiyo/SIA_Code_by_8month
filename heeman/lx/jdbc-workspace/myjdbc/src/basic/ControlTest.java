package basic;

import java.util.Calendar;

public class ControlTest {
	
	static int FRIDAY = 6;

	public static void main(String[] args) {
		
		// 오늘이 금요일이면? "불금이네요"라는 문자열을 출력한다.
		Calendar cal = Calendar.getInstance(); // getInstance는 Calendar 클래스 안에 있는 매서드. static <- ClassName.methodName()
		int today = cal.get(7); // day of week
		System.out.println(today);
		if(today == 6) { // 금요일
			System.out.println("불금이네요!!!");
		}
		
		int today2 = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(today2);
		if(today2 == Calendar.FRIDAY) { // 금요일
			System.out.println("불금이네요!!!");
		}
		
		int today3 = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(today3);
		if(today3 == FRIDAY) { // 금요일
			System.out.println("불금이네요!!!");
		}
	}
	
}
