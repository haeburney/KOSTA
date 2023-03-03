package prj2_2;

import java.util.Scanner;

public class InputTest { // input (Scanner)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력하시오.");
		String name = sc.next();
		System.out.println("이름 :" + name);

		System.out.println("나이를 입력하시오.");
		int age = sc.nextInt();
		System.out.println("나이 :" + age);

		sc.close();
	}
}
