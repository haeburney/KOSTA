package oop2;

interface InterTest {
	// public final static int MAX = 100;
	// 보기에는 변수같지만 interface에서는 상수이다.
	int MAX = 100;

	// public abstract void f1();
	void f1();

	void f2();

	void f3();
	// 인터페이스는 abstract를 안 써도 에러가 나지 않는다. 어차피 추상이니까
}

class InterTestImp1 implements InterTest {

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

	@Override
	public void f3() {
		// TODO Auto-generated method stub
		System.out.println("f3()");
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		InterTest i = new InterTestImp1();
		System.out.println("MAX : "+InterTest.MAX);
		i.f1();
		i.f2();
		i.f3();

	}
}
