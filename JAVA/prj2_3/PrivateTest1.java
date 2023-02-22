package prj2_3;

class PrivateTest {
	private int a; // 클래스 안에서만 보임
	int b; // default: 같은 패키지 내에서만 보임
	public int c; //

	public PrivateTest() {
	}

	public PrivateTest(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "PrivateTest [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

}

public class PrivateTest1 {

	public static void main(String[] args) {
		PrivateTest pt = new PrivateTest(1, 2, 3);
		// pt.a = 10;
		pt.b = 20;
		pt.c = 30;
	}

}
