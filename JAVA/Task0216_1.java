package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task0216_1 {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("1. 숫자 10개를 입력받아서 총합과 평균을 출력");
		int[] arr1 = new int[10];
		int sum=0;
		for(int i=0;i<arr1.length;i++) {
			System.out.print((i+1)+"번째 숫자 입력 :");
			arr1[i]=Integer.parseInt(br.readLine());
			sum+=arr1[i];
		}
		System.out.println("총합 : "+sum+"   평균 : "+(float)sum/arr1.length);
		
		System.out.println("2. 숫자 10개를 입력받아서 최댓값을 출력");
		int[] arr2 = new int[10];
		int max=arr2[0];
		int min=arr2[0];
		for(int i=0;i<arr2.length;i++) {
			System.out.print((i+1)+"번째 숫자 입력 :");
			arr2[i]=Integer.parseInt(br.readLine());
			if(max<arr2[i]) {
				max=arr2[i];
			}
			if(min>arr2[i]) {
				min=arr2[i];
			}
		}
		System.out.println("최댓값 : "+max+" 최솟값 : "+min);
	}
}
