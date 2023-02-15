package prj2_2;

import java.util.Scanner;

public class TestScore { // 입력 받고 & 학점 출력

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int score;

		while (true) {
			System.out.println("0 ~ 100의 점수를 입력해주세요.");
			score = sc.nextInt();

			if (score >= 0 && score <= 100) {
				break;
			}
		}

		if (score >= 90) {
			System.out.println("A학점입니다.");
		} else if (score >= 80) {
			System.out.println("B학점입니다.");
		} else if (score >= 70) {
			System.out.println("C학점입니다.");
		} else if (score >= 60) {
			System.out.println("D학점입니다.");
		} else{
			System.out.println("F학점입니다.");
		}

	}

}
