package prj2_2;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 4, 1, 5, 2, -1, 10 };
		int temp;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(i + " " + j + " 비교");

				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					// i=1 j=2 j<=2까지
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

}
