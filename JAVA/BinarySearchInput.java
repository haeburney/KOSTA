package homework;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchInput {
	public static int[] array;
	public static int num;
	public static int middle;
	public static int low = 0;
	public static int high;

	public static void search(int middle) {
		//System.out.println(middle);
		if (num == array[middle]) {
			System.out.println("찾으려는 값은 index " + middle + "방에 있습니다.");
			return;

		} else if (array[middle] > num) {
			high = middle;
			//System.out.println(low + "\t" + high);
			if (middle == array.length - 1 && array[middle] != num || middle == 0 && array[middle] != num) {
				System.out.println(num+"은 존재하지 않습니다.");
				return;
			}
			middle = (low + high) / 2;
			search(middle);
		} else {
			low = middle + 1;
			if (middle == array.length - 1 && array[middle] != num || middle == 0 && array[middle] != num) {
				System.out.println(num+"은 존재하지 않습니다.");
				return;
			}
			middle = (low + high) / 2;
			search(middle);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("몇 개의 배열을 만들까요? : ");
		int size = sc.nextInt();
		array = new int[size];
		System.out.println("\n" + size + "개의 배열을 입력해주세요 : ");
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}

		Arrays.sort(array);
		System.out.println("!배열을 정리했습니다!");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"\t");
		}

		System.out.print("\n찾으려는 숫자는 : ");
		num = sc.nextInt();

		high = size;
		middle = (low + high) / 2;

		search(middle);

	}
}
