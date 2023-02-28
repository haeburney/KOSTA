package prj2_2;

import java.util.Scanner;

public class Array_성적처리2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String[] name = new String[3];
		int[][] score = new int[3][5];
		float[] avg = new float[3];
		int i, j;

		String[] title = { "name", "num", "kor", "eng", "math", "totle", "avh" };

		for (i = 0; i < name.length; i++) {
			System.out.print(title[0] + ": ");
			name[i] = sc.next();

			for (j = 0; j < 4; j++) {
				System.out.print(title[j + 1] + " : ");
				score[i][j] = sc.nextInt();

				if (j != 0) {
					score[i][4] += score[i][j];
				}
			}

			avg[i] = (float) score[i][4] / 3;
		}

		System.out.println("name\tnum\tkor\teng\tmath\ttotal\tavg");
		for (i = 0; i < name.length; i++) {
			System.out.print(name[i] + "\t");
			for (j = 0; j < score[0].length; j++) {
				System.out.print(score[i][j] + "\t");
				// System.out.print("i : " + i + "J: " + j + " ");
			}
			System.out.print(avg[i]);
			System.out.println();
		}
	}
}
