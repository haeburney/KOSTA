package Memo;

import java.util.Scanner;

public class Menu {
	private Memo memo;
	private String dirPath;

	public Menu(String dirPath) {
		memo = new Memo();
		this.dirPath = dirPath;
	}

	public void run(Scanner sc) {
		boolean flag = true;
		int input;
		memo.init();

		while (flag) {
			System.out.println("1.읽기 2.쓰기 3.삭제 4.종료");
			input = sc.nextInt();

			switch (input) {
			case 1:
				memo.read(dirPath,sc);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				flag = false;
				break;
			default:
				break;
			}
		}
	}
}
