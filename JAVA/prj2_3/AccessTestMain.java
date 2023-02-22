package prj2_3;

public class AccessTestMain {

	public static void main(String[] args) {
		AccessTest at = new AccessTest(1, 2, 3);

		// private 멤버는 다른 클래스에서 사용 불가
		// System.out.println(at.a);
		System.out.println(at.b);
		System.out.println(at.c);
		at.printData();

		MyTest mt = new MyTest();
		mt.x = 10;
		mt.y = 20;

	}

}
