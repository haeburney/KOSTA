package prj2_2;

import java.util.Scanner;

public class DoWhile {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int score;
		
		do {
			System.out.println("0 ~ 100의 점수를 입력해주세요.");
			score = sc.nextInt();
		} while(score < 0 || score >100);

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
