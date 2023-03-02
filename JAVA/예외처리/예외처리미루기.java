package 예외처리;

import java.io.IOException;

class Test {
	public void f1() throws IOException {
		int ch = System.in.read();
	}
}

public class 예외처리미루기 {
	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.f1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
