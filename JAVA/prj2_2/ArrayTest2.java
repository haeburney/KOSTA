package prj2_2;

import java.util.Scanner;

public class ArrayTest2 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);

		String[] name=new String[3];
		
		for(int i=0;i<name.length;i++) {
			System.out.print((i+1)+"번째값 입력 : ");
			name[i]=sc.next();
		}
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}
		
	}
}
