package homework;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WritingService main=new WritingService();
		/*
		main.input(sc);
		main.input(sc);
		main.input(sc);
		main.input(sc);
		//main.print();
		main.search(sc);
		main.delete(sc);
		main.print();
		*/
		
		int num;
		
		while(true) {
			System.out.println("\n1.회원가입 / 2.id검색 / 3.정보수정 / 4.계정삭제 / 5. 회원정보보기 / 6.종료하기");
			num=sc.nextInt();
			
			switch(num) {
			case 1:
				main.input(sc);
				break;
			case 2:
				main.search(sc);
				break;
			case 3:
				main.modify(sc);
				break;
			case 4:
				main.delete(sc);
				break;
			case 5:
				main.print();
				break;
			case 6:
				return;
			default :
				System.out.println("1 ~ 6 사이를 입력해주세요");
				break;
			}
		}
	}
}
