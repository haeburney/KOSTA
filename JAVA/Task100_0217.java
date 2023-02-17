package homework;

public class Task100_0217 {
	public static void main(String[] args) {
		int[] arr = new int[100];
		int i, sum = 0;

		for (i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		for (i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				sum += arr[i];
		}

		System.out.println(sum);
	}

}
