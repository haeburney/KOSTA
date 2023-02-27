package langtest;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String 생성의 다양한 종류
		String s1 = "abcdefu";
		String s2 = new String(s1);
		String s3 = new String("345");
		char[] ch = { 'h', 'e', 'l', 'l', 'o' };
		String s4 = new String(ch);
		byte[] b = { 'h', 'e', 'l', 'l', 'o' };
		//byte 아스키코드가 저장이 됨.
		String s5 = new String(b);

		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);
		System.out.println("s5 : " + s5);
	}

}
