package oop2;

// 추상클래스
abstract class Parent {
	// 추상메서드, 구현하지 않은 메서드, 왜? 상속목적, 하위클래스가 자기한테 맞게 구현을 해서 사용하라.
	public abstract void f1();

	public void f2() {
		System.out.println("parent f2()");
	}
}

class Child extends Parent {

	@Override
	public void f1() {
		// TODO Auto-generated method stub
		System.out.println("Child에서 추상 메서드 구현");
	}

	public void f3() {
		System.out.println("Child에서 f3()");
	}

}

public class ParentMain {
	public static void main(String[] args) {
		// Parent p=new Parent(); → 추상 클래스는 객체 생성 불가
		Child c = new Child();
		c.f1();
		c.f2();
		c.f3();

		Parent pc = new Child(); // 주로 업캐스팅해서 사용한다.
		pc.f1(); // 재정의된 메서드가 실행된다. 
		pc.f2();
		
		((Child)pc).f3(); // 다시 자식을 쓰고 싶다면 다운 캐스팅
	}
}
