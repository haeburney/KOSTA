package prj2_2;

//클래스 정의, 타입명:Person, 변수하나에 나이와 이름을 담을 수 있음 
class Person {
	int age;
	String name;
}

//public이 붙은 클래스는 딱 하나만 만들어야 한다. 

public class ClassTest {
	public static void main(String args[]) {
		Person p1 = new Person();
		// 생성자는 클래스와 이름이 같다
		p1.age = 7;
		p1.name = "mango";
		System.out.println(p1.age + "\t" + p1.name);

		Person p2 = new Person();
		p2.age = 6;
		p2.name = "hi";
		System.out.println(p2 + "\t" + p2.age + "\t" + p2.name);

		Person p3 = p2;
		System.out.println(p3 + "\t" + p3.age + "\t" + p3.name);
		
		// p3는 메모리 할당을 받은 것이 아님 p2를 참조하여 가져오는 거임
		// 그래서 p3의 값을 바꾸면 p2의 값도 바뀐다. 
	}
}
