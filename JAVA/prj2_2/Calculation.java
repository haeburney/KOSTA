package homework;

import java.util.Scanner;

public class Calculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 두 개를 입력해주세요");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("어떤 연산을 하고 싶나요 + - * / %");
		String op = sc.next();
		int result=0;

		switch (op) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			if (b == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				return;
			}
			result = a / b;
			break;
		case "%":
			result = a % b;
			break;
		default:
			System.out.println("올바른 연산자를 입력해주세요.");
			return;
		}
		System.out.println(a + " " + op + " " + "=" + result);

	}

}
