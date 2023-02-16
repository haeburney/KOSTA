package homework;

import java.util.Scanner;

public class PracticeBinarySearch {
	public static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	public static int num;
	public static int middle;
	public static boolean flag=true;
	public static int result;
	
	public static int search(int middle) {
		System.out.println(middle);
		if(num==array[middle]) {
			result=middle;

		} else if(array[middle] > num) {
			middle/=2;
			search(middle);
		} else {
			middle= (middle+array.length)/2;
			search(middle);
		}
		
		if (middle == array.length - 1 && array[middle] != num || middle == 0 && array[middle] != num) {
			flag=false;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 숫자는 : ");
		num = sc.nextInt();
		middle = array.length / 2;
		
		
		
		search(middle);
		
		if(!flag) {
			System.out.println("찾으려는 숫자는 존재하지 않습니다.");
		}
		

	}
}
