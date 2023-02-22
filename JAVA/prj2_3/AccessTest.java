package prj2_3;

// public 클래스
public class AccessTest {
	private int a; // private 멤버
	int b; // default 멤버
	public int c; // public 멤버

	// 생성자를 비롯한 대부분 메서드는 public
	public AccessTest(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void printData() {
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
	}
}

// default 클래스
class MyTest {
	int x;
	int y;
}
