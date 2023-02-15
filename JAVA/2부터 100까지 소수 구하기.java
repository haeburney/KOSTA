package prj2_2;

import java.util.Scanner;

public class Practice {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		// 2부터 100의 소수 구하기
		
		for(int i=2;i<=100;i++) {
			int num=(int)Math.sqrt(i);
			int count=0;
			for(int j=1;j<=num;j++) {
				if(i%j==0) count++;
				if(count>2) break;
			}

			if(count==1) {
				System.out.println(i);
			}
		}
	}
}
