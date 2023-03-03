package prj2_2;

import java.util.Scanner;

public class ForTest { // 반복문
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i, j;

		for (i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		for (i = 10; i >= 1; i--) {
			System.out.println(i);
		}

		int sum = 0;
		for (i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("sum : " + sum);

		System.out.print("단수 : ");
		int num = sc.nextInt();
		for (i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + (i * num));
		}
		
		
		for (i=2;i<=9;i++) {
			System.out.println("***** "+i+"단 *****");
			for(j=1;j<=9;j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
	}
}
