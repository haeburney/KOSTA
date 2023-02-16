package homework;

import java.math.BigInteger;
import java.util.Scanner;

public class Task0215 { // 과제 0215

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("별의 크기를 입력해주세요 : ");

		int star = sc.nextInt();

		System.out.println("[왼쪽 직삼각형]");
		for (int i = 1; i <= star; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("[오른쪽 직삼각형]");
		for (int i = 1; i <= star; i++) {
			for (int j = star - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("[이등변삼각형]");
		for (int i = 1; i <= star; i++) {
			for (int j = star - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		int n = star / 2 + 1;

		for (int i = 0; i < n; i++) {
			for (int j = n - i - 1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		/* 선생님 코드 */

		int m = star / 2;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j < m - i; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		/* 선생님 코드 */

		System.out.println("[이등변역삼각형]");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = star - i * 2; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.print("구할 약수의 수를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.print(num + "의 약수는? : ");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println("\n[2 ~ 100 사이의 소수 출력]");
		for (int i = 2; i <= 100; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					count++;
				if (count > 0)
					break;
			}
			if (count == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println("\n[피보나치 수열 100개 출력]");

		BigInteger left = new BigInteger("1");
		BigInteger right = new BigInteger("1");
		BigInteger temp = new BigInteger("0");

		System.out.print("1번쨰 :" + left + "\n2번째 :" + right + "\n");
		for (int i = 0; i < 98; i++) {
			temp = left;
			left = right;
			right = right.add(temp);

			System.out.println((i + 3) + "번째 :" + right);
		}
	}

}
