package 예외처리;

// 사용자 정의 예외 클래스는 Exception을 상속 받아 정의
class MyException extends Exception {
	public MyException() {
	}
	// 생성자에서 파람으로 받은 문자열을 상위 클래스 생성자에 전달
	public MyException(String s) {
		super(s);
	}
}

class Test2 {
	private int[] datas;
	private int cnt;

	public Test2() {
		datas = new int[3];
	}

	public void add(int x) throws MyException {
		if (cnt == datas.length) {
			throw new MyException("☆ 배열이 가득 찼습니다. ☆"); // 예외 발생
			// 예외 객체 생성시 생성자에 파람으로 문자열을 넣으면 예외 메시지로 사용된다.
		}
		datas[cnt++] = x;
	}

	public void printArr() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(datas[i]);
		}
	}
}

public class 예외던지기 {
	public static void main(String[] args) {
		Test2 t = new Test2();

		for (int i = 0; i < 4; i++) {
			try {
				t.add(i);
			} catch (MyException e) {
				// 우리가 정의한 예외
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		t.printArr();
	}
}
