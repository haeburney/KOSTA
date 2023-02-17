package homework;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeBinarySearch {
	public static int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	public static int num;
	public static int middle;
	public static boolean flag = true;
	public static int result;
	public static int low = 0;
	public static int high = array.length;

	// num=5일때 에러
	// middle=5 5=6 middle=3 5=4 middle=3
	// 0 1 2 3 4
	// middle=2

	public static void search(int middle) {
		System.out.println(middle);
		if (num == array[middle]) {
			result = middle;
			System.out.println("찾으려는 값은 " + middle + "에 있습니다.");
			return;

		} else if (array[middle] > num) {
			high = middle;
			System.out.println(low+"\t"+high);
			if (middle == array.length - 1 && array[middle] != num || middle == 0 && array[middle] != num) {
				System.out.println("찾으려는 숫자는 존재하지 않습니다.");
				return;
			}
			middle = (low + high) / 2;
			search(middle);
		} else {
			low = middle + 1;
			if (middle == array.length - 1 && array[middle] != num || middle == 0 && array[middle] != num) {
				System.out.println("찾으려는 숫자는 존재하지 않습니다.");
				return;
			}
			middle = (low + high) / 2;
			search(middle);
		}
	}

	public static void main(String args[]) {
		Arrays.sort(array);
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 숫자는 : ");
		num = sc.nextInt();
		middle = (low + high) / 2;

		search(middle);

		if (!flag) {
			System.out.println("찾으려는 숫자는 존재하지 않습니다.");
		}
	}
}
