package prj2_3;

public class OverTest {
	int add(int a, int b) {
		System.out.println("add int : " + (a + b));
		return a + b;
	}

	String add(String a, String b) {
		System.out.println("add String : " + (a + b));
		return a + b;
	}

	float add(float a, float b) {
		System.out.println("add float : " + (a + b));
		return a + b;
	}

	public static void main(String[] args) {
		OverTest o = new OverTest();

		o.add(1, 2);
		o.add("min", "hyun");
		o.add(3.14f, 3.14f);

	}

}
