package prj2_2;

import java.util.Scanner;

public class ArrayTest3 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int i;
		System.out.print("몇 개의 배열을 만드시겠습니까? : ");
		int num = sc.nextInt();
		int[] arr = new int[num];

		for (i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.print("찾고싶은 숫자를 입력해주세요 :");
		num = sc.nextInt();
		System.out.println();
		String answer = "";
		int count = 0;

		for (i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				count++;
				answer += i + "번째 방에 있습니다.\n";
			}
		}

		if (count == 0) {
			System.out.println("찾으려는 숫자가 존재하지 않습니다.");
		} else {
			System.out.println(answer);
		}

	}
}
