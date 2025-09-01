package basic;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationTest {
	public static void main(String[] args) {
		// Annotation이 뭘까?  => Annotation
		//변수는 아니다. 함수, 클래스, 패키지, 프레임워크도 아니다. 새로운 개념임
		//주로 Annotation은 마킹용도로 사용한다.
		
		// 1. MyClass 객체 생성
		MyClass myClass = new MyClass();
		
		// 2. MyClass의 클래스 정보에서 모든 어노테이션 목록을 가져옴
		Annotation[] annotataionList = myClass.getClass().getAnnotations();
		// myClass.getClass(): myClass 객체의 설계도인 MyClass의 클래스 정보를 가져옵니다.
		// .getAnnotations(): 클래스 정보에 붙어있는 모든 어노테이션을 찾아내 배열로 반환합니다
		
		
		
		// 3. 가져온 어노테이션 목록을 하나씩 출력
		for(Annotation annotation : annotataionList) {
			System.out.println(annotation);
		}
	}
}

// Annotation 정의하기

//어노테이션이 언제까지 살아남을지 결정하는 설정
//만약 이게 없으면 실행 중에는 정보가 사라져서 찾을 수 없습니다
@Retention(RetentionPolicy.RUNTIME)  
@interface MyAnnotation {
	
}

//MyClass 라는 클래스는 @MyAnnotation으로 마킹한 것, 도장 찍은 것
//@MyAnnotation: 위에서 만든 어노테이션을 MyClass에 붙여준 것입니다. 
//이로써 MyClass는 @MyAnnotation이라는 **꼬리표(마킹)**를 갖게 됩니다.
@MyAnnotation
class MyClass {
	
}
