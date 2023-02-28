package homework;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch0215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int low = 0, high = arr.length;
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

		int middle = (low+high) / 2;
		System.out.print("\n찾으려는 숫자는 ? ");
		int num = sc.nextInt();

		while (true) {
			if (arr[middle] == num) {
				System.out.println(middle + "번째에 있습니다.");
				break;
			} else if (arr[middle] > num) {
				high = middle - 1;
				middle = (low + high) / 2;
			} else {
				low = middle + 1;
				middle = (low + high) / 2;
			}

			if (middle == arr.length - 1 && arr[middle] != num || middle == 0 && arr[middle] != num) {
				System.out.println("찾으려는 숫자는 존재하지 않습니다.");
				break;
			}

		}

	}

}
