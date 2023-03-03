package prj2_2;

import java.util.Scanner;

public class DeepCopyShalloCopy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = a;
		int i;
		int[] c = new int[3];

		System.out.println("***  a의 배열  ***");
		for (i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}

		System.out.println("\n***  b의 배열  ***");
		for (i = 0; i < b.length; i++) {
			System.out.print(b[i] + "\t");
		}

		System.out.println("\n***  a와 b의참조값  ***");
		System.out.println(a);
		System.out.println(b);

		b[1] = 20;

		System.out.println("\n***  b[1] 변경 후 a의 배열  ***");
		for (i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}

		System.out.println("\n***  b[1] 변경 후 b의 배열  ***");
		for (i = 0; i < b.length; i++) {
			System.out.print(b[i] + "\t");
		}

		System.out.println("\n***  a, b, c의 참조값  ***");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		int[] d = new int[a.length];
		for(i=0;i<d.length;i++) {
			d[i]=a[i];
		}
		d[1]=-100;
		
		System.out.println("\n***  d복사 후 d[1] 변경 후 d의 배열  ***");
		for (i = 0; i < d.length; i++) {
			System.out.print(d[i] + "\t");
		}
		System.out.println("\n***  a와 d의 참조값  ***");
		System.out.println(a);
		System.out.println(d);
		
	}
}
