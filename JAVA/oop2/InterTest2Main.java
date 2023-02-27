package oop2;

interface A {
	public void f1();
}

interface B {
	public void f2();
}

// 인터페이스는 다중상속 가능 
class InterTest2 implements A, B {

	@Override
	public void f1() {
		// TODO Auto-generated method stub
		System.out.println("f1()");
	}

	@Override
	public void f2() {
		// TODO Auto-generated method stub
		System.out.println("f2()");
	}

}

public class InterTest2Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterTest2 t = new InterTest2();
		t.f1();
		t.f2();
	}
}
