package prj2_3;

public class StringTest {

	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		String c = "bbb";
		String d = new String("hello");

		System.out.println("a==b : " + (a == b));
		System.out.println("a==b : " + (a == c));
		System.out.println("a==b : " + (a == d));
		System.out.println("a.equals(b) : " + (a.equals(b)));

		System.out.println("a : " + a.hashCode());
		System.out.println("b : " + b.hashCode());
		System.out.println("c : " + c.hashCode());
		System.out.println("d : " + d.hashCode());

	}

}
