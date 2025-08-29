package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		
		// Collection API. 배열과 관련이 있음.
		// https://velog.io/@mini_mouse_/%EC%9E%90%EB%B0%94-%EC%BB%AC%EB%A0%89%EC%85%98-API-collection-APIArrayListforEachlamda%EC%8B%9D
		// 배열의 특징(문제) : 한 번 배열의 길이가 정해지면 변경할 수 없음. 동일한 타입의 값만 저장할 수 있음.
		
		// 객체지향 설계원칙 https://inpa.tistory.com/entry/OOP-%F0%9F%92%A0-%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%84%A4%EA%B3%84%EC%9D%98-5%EA%B0%80%EC%A7%80-%EC%9B%90%EC%B9%99-SOLID
		
		// List, Map, Set, Iterator
		// List list = new ArrayList(); // List = interface. ArrayList = class. ArrayList는 List에 상속됨.
		ArrayList list = new ArrayList();
		// List는 동적 배열, index로 참조한다. 0번째, 1번쨰 ....
		list.add(33);
		list.add("hello");
		//list.add(new Employee());
		
		list.size(); // 전체 갯수
		String str = (String)list.get(1);
		
		List<String> list2 = new ArrayList<String>(); // String 타입만 다루게 된다.
		//list2.add(11);
		list2.add("Hello");
		String str2 = list2.get(0);
		
		// Map name & value로 관리 컨테이너, 뭔가 담아두는 것
		//Map<K, v>
		Map<String, Object> map = new HashMap<String, Object>(); // Map = 인터페이스, HashMap = 클래스. 상속관계. map = stack 영역에 생성된 64bit로 할당된 변수, 생성된 객체의 주소값을 넣을 수 있는 공간
		map.put("name", "Gyeyeon");
		map.put("pw", "12345");
		String name = (String)map.get("name");
		map.put("list", list2);
		
		// set : 수학의 set : 중복되지 않은 요소들 가지고 있는 콜렉션
		Set<String> keyset = map.keySet(); // keySet = Map 인터페이스에 있는 메서드.
		
	}
	
	
	
}
