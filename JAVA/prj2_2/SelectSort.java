package prj2_2;

public class SelectSort {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 8, 6, 0, 10, -1 };
		int temp, i, j;

		for (i = 0; i < arr.length; i++) {
			int index = i;
			int min = arr[i];
			for (j = i; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			System.out.println("index : " + index + " min : " + min);
			if (index != i) {
				temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}

		}

		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

	}

}
