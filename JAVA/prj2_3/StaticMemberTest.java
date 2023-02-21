package prj2_3;

class MyStatic {
	int a;
	static int b;
}

public class StaticMemberTest {

	public static void main(String[] args) {
		System.out.println(MyStatic.b);
		
		MyStatic ms1 = new MyStatic();
		ms1.a++;
		ms1.b++;
		System.out.println(ms1.a + " " + ms1.b);

		MyStatic ms2 = new MyStatic();
		ms2.a++;
		ms2.b++;
		System.out.println(ms2.a + " " + ms2.b);

		MyStatic ms3 = new MyStatic();
		ms3.a++;
		ms3.b++;
		System.out.println(ms3.a + " " + ms3.b);

		MyStatic.b++;
		System.out.println(ms3.b + " " + MyStatic.b);

	}

}
