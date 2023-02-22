package prj2_3;

class PrivateTest2 {
	private int a;
	private String b;

	// setter
	public void setA(int a) {
		this.a = a;
	}
	public int getA() {
		return a;
	}

	public void setB(String b) {
		this.b = b;
	}
	public String getB() {
		return b;
	}

	public void printData() {
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
}

public class PrivateTest2Main {

	public static void main(String[] args) {
		PrivateTest2 pt = new PrivateTest2();
		pt.setA(10);
		pt.setB("mango");
		System.out.println(pt.getA());
		System.out.println(pt.getB());
	}

}
