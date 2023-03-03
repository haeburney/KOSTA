package prj2_2;

public class OpTest { // 연산자
	public static void main(String[] args) {
		int a = 5, b = 2, c = 0;
		// int d, e, f;

		c = a / b;
		System.out.println("a/b = " + c);

		c = a % b;
		System.out.println("a%b = " + c);

		a = 5;
		b = 0;
		b = a++;
		System.out.println(b);
		System.out.println(a);

		a = 5;
		b = 0;
		b = ++a;
		System.out.println(b);
		System.out.println(a);

		a = 1;
		b = 2;
		c = 3;
		System.out.println("a>b: " + (a > b));
		System.out.println("a<b: " + (a < b));
		System.out.println("a==b: " + (a == b));
		System.out.println("a==3: " + (a == 3));
		System.out.println("a==1: " + (a == 1));

		char gender = 'f';
		int age = 15;

		boolean result = (gender == 'f') && (age >= 20);
		System.out.println(result);

		result = (gender == 'f') || (age >= 20);
		System.out.println(result);

		a = 10;
		a += 1;
		System.out.println(a);

		a -= 1;
		System.out.println(a);

		a *= 2;
		System.out.println(a);

		a /= 3;
		System.out.println(a);

		a %= 5;
		System.out.println(a);
	}
}
