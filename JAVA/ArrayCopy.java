package prj2_2;

public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = new int[a.length];

		System.arraycopy(a, 1, b, 1, 3);

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "\t");
		}
		System.out.println("\n");

		int[][] arr = new int[2][3];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();

		}

		System.out.println("a의 크기 : " + arr.length);
		System.out.println("a[0]의 크기 : " + arr[0].length);
		System.out.println("a[1]의 크기 : " + arr[1].length);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = 3 * i + j + 1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();

		}

		int[][] array = { { 5, 6 }, { 8, 9 } };

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}

		// 가변 초기화

		int[][] c = { { 1, 2, 3, 4 }, { 5, 6 } };
		System.out.println("c의 크기 : " + c.length);

		for (int i = 0; i < c.length; i++) {
			System.out.println("c[" + i + "]의 크기 : " + c[i].length);
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
