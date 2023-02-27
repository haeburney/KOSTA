package oop2;

import java.awt.Frame;

class Test extends Frame implements Runnable {

	@Override
	public void run() {
		// 쓰레드를 실행코드를 작성하는 메서드
		// TODO Auto-generated method stub
		System.out.println("run");
		for (int i = 1; i <= 10; i++) {
			// setTitle은 Frame것이다. 
			this.setTitle(i + "번째 타이틀");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// Frame 윈도우 그려주는거
	// 다중상속이 기본으로 안되기 때문에 하나는 interface로 상속을 받는ㄴ것
	// 다중상속을 할수 있게 class로도 제공해주고 interface로도 제공해주고..

}

public class InterTest3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.setSize(300, 200); // 윈도우 가로, 세로 길이 설정
		t.setVisible(true); // 윈도우를 보이기 설정
		Thread th = new Thread(t); // 쓰레드 생성
		th.start(); // 쓰레드 실행
	}

}
