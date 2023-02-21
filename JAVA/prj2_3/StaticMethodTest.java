package prj2_3;

class StaticMethod {
	int a;
	static int b;

	StaticMethod() {
	}

	void f1() {
		System.out.println("일반 메서드. f1()");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}

	static void f2() {
		System.out.println("일반 메서드. f2()");
//		System.out.println("a : " + a); // 객체 생성 전에 이 메서드를 호출할 수도 있기 때문에 에러 발생
		System.out.println("b : " + b);
	}
	
	void f3() {
		f1();
		f2();
	}
	
	static void f4() {
//		f1();	static 메서드에서 일반 메서드 호출 불가
 		f2();
	}
}

public class StaticMethodTest {
	public static void main(String[] args) {
		System.out.println("객체 생성전");
		System.out.println("static 멤버만 사용 가능");
		StaticMethod.f2();
		StaticMethod.f4();
		System.out.println(StaticMethod.b);
		
		System.out.println("객체 생성후");
		System.out.println("일반 멤버, static 멤버 모두 사용 가능");
		StaticMethod s1=new StaticMethod();
		System.out.println(s1.a);
		System.out.println(StaticMethod.b);
		s1.f1();
		StaticMethod.f2();
		s1.f3();
		StaticMethod.f4();
		
	}
}
