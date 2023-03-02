package 예외처리;

import java.io.IOException;

public class Ex1 {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		try {
			String s = null;
			s.charAt(0);
			int x = 3 / 0;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");

		try {
			int ch = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // 예외메시지 상세 출력
		}
	}
}
