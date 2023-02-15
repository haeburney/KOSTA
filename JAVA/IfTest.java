package prj2_2;

public class IfTest { // 제어문
	public static void main(String[] args) {
		int a = 5;
		if (a == 3) {
			System.out.println("a는 3이다");
		}
		if (a >= 5) {
			System.out.println("a는 5보다 크다");
		}

		String name = "aaa";
		if (name == "aaa") {
			System.out.println("right");
		}
		if (name.equals("aaa")) {
			System.out.println("right");
		}

		int score = 63;
		if (score >= 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}

		int num = 5;
		if (num % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}

		int x = 3;

		if (x == 1) {
			System.out.println("x는 1입니다.");
		} else if (x == 2) {
			System.out.println("x는 2입니다.");
		} else if (x == 3) {
			System.out.println("x는 3입니다.");
		} else {
			System.out.println("x는 3보다 큽니다.");
		}

		score = 66;

		if (90 <= score && score <= 100) {
			System.out.println("A학점입니다.");
		} else if (80 <= score && score < 90) {
			System.out.println("B학점입니다.");
		} else if (70 <= score && score < 80) {
			System.out.println("C학점입니다.");
		} else if (60 <= score && score < 70) {
			System.out.println("D학점입니다.");
		} else if (0 <= score && score < 70) {
			System.out.println("F학점입니다.");
		} else {
			System.out.println("0~100점 사이로 입력해주세요.");
		}
	}
}
