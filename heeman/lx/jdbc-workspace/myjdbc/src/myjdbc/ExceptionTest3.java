package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest3 { // 예외처리 throws 절 / try-catch 절

	public static void main(String[] args)  {
		// file reading
		FileReader fr;
		try {
			fr = new FileReader("list.txt");
			int read;
			read = fr.read();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			// 예외가 발생되든 안되든 실행되는 구간
		}
		
		
		
		// 생성자가 throws 절로 정의되었기 때문에 예외처리 해야함.  
//		try {
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // read 메서드가 throws 절로 정의되었기 때문에 예외처리 해야함.
//		System.out.println((char)read);
	}

}
