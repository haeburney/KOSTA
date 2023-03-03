package prj2_2;

import java.util.Scanner;

public class WhileTest { // while문
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 10;
		while (i > 0) {
			System.out.println(i);
			i--;
		}

		int j = 1, sum = 0;

		while (j <= 100) {
			sum += j;
			j++;
		}
		System.out.println("1부터 100까지의 합 : " + sum);

		int num;
		int sum2 = 0;
		while (true) {
			System.out.print("숫자를 입력하세요 : ");
			num = sc.nextInt();
			sum2 += num;
			System.out.print("종료를 원하면 0 계속하려면 0외의 아무 숫자 : ");
			num = sc.nextInt();
			if (num == 0) {
				break;
			}
		}
		System.out.println("입력한 숫자의 합은 :" + sum2);
	}
}
