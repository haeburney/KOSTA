package Memo2;

import java.util.Scanner;

public class Menu {
	private String dirPath;
	private Memo memo;

	public Menu() {

	}

	public Menu(String dirPath) {
		this.dirPath = dirPath;
		memo = new Memo();
	}

	public void run(Scanner sc) {
		memo.init(dirPath);

		boolean flag = true;
		System.out.println("☆★☆ Hyun 메모장에 오신 것을 환영합니다 :) ☆★☆");
		int num;
		String path = "hyunMemo/";

		while (flag) {
			System.out.println("1.읽기 2.쓰기 3.삭제 4.종료");
			num = sc.nextInt();

			switch (num) {
			case 1:
				memo.read(path, sc);
				// 읽기 메소드
				break;
			case 2:
				memo.write(path, sc);
				// 쓰기 메소드
				break;
			case 3:
				memo.deleteRead(path, sc);
				// 삭제 메소드
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("1 ~ 4 사이의 번호를 입력해주세요 :)");
			}
		}
	}
}
