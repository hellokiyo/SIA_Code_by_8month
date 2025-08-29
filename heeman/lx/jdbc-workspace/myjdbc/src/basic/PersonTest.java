package basic;

public class PersonTest {

	public static void main(String[] args) {

		Person person1 = new Person();
		Person person2 = new Person("Anonymous2", 13);

		person1.selfIntroduce();
		person2.selfIntroduce();

		System.out.println("총 인구 : " + Person.getPopulation() + "명");

	}

}

class Person {

	// 전체 인구 수 초기화
	static int numberOfPerson = 0;

	String name;

	int age;

	// 생성자
	Person() {
		name = "Anonymous";
		age = 12;
		numberOfPerson++;
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
		numberOfPerson++;
	}

	void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "입니다.");
	}

	static int getPopulation() {
		return numberOfPerson;
	}

}