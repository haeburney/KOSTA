package Task_0224;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Menu m=new Menu();
		m.run(sc);
	
		
		//ps.ProductService(input);
		/*
		Product p=new Product();
		System.out.print("제품 번호 입력 : ");
		p.setNum(sc.nextInt());
		System.out.print("제품명 입력 : ");
		p.setName(sc.next());
		System.out.print("사진경로 입력 : ");
		p.setUrl(sc.next());
		System.out.print("판매자id 입력 : ");
		p.setId(sc.next());
		System.out.print("가격 입력 : ");
		p.setPrice(sc.nextInt());
		System.out.print("수량 : ");
		p.setAmount(sc.nextInt());
		
		System.out.println("\n\ntoString으로 출력 : "+ p+"\n\n");
		System.out.println("*** get으로 출력 *** ");
		System.out.println("제품번호 : " + p.getNum());
		System.out.println("제품명 : " + p.getName());
		System.out.println("사진경로 : " + p.getUrl());
		System.out.println("판매자 ID : " + p.getId());
		System.out.println("가격: " + p.getPrice());
		System.out.println("제품번호 : " + p.getAmount() + "\n\n");	
		
		System.out.println("*** 제품명, 가격, 수량 수정하고 객체 출력");
		System.out.print("제품명 입력 : ");
		p.setName(sc.next());
		System.out.print("가격 입력 : ");
		p.setPrice(sc.nextInt());
		System.out.print("수량 : ");
		p.setAmount(sc.nextInt());
		
		System.out.println("\n\ntoString으로 출력 : "+ p+"\n\n");
		System.out.println("*** get으로 출력 *** ");
		System.out.println("제품번호 : " + p.getNum());
		System.out.println("제품명 : " + p.getName());
		System.out.println("사진경로 : " + p.getUrl());
		System.out.println("판매자 ID : " + p.getId());
		System.out.println("가격: " + p.getPrice());
		System.out.println("제품번호 : " + p.getAmount() + "\n\n");	
		*/
	}
}
