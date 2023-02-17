package homework;

import java.math.BigInteger;

public class TastFibonaci_0217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger[] arr=new BigInteger[100];
		
		
		arr[0]=BigInteger.valueOf(1); 
		arr[1]=BigInteger.valueOf(1); 
	
		for(int i=2;i<100;i++) {
			arr[i]=arr[i-1].add(arr[i-2]);
		}
		
		for(int i=0;i<100;i++) {
			System.out.println(arr[i]);
		}
		
	}

}
