package prj2_2;

public class ArrayTest {
	public static void main(String args[]) {
		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		char[] name = new char[3];

		for (int i = 0; i < name.length; i++) {
			name[i] = (char) (97 + i);
			System.out.print(name[i] + "\t");

		}
		System.out.println();

		String[] arr3 = new String[2];
		arr3[0] = "mango";
		arr3[1] = "love";

		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + "\t");
		}
		System.out.println();

		int[] arr1 = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();

		int[] arr2 = new int[] { 1, 2, 3, 4 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + "\t");
		}
		System.out.println();

		String[] arr4 = { "man", "go" };
		for (int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + "\t");
		}
		
		
	}
}
