package product2;

import java.util.Scanner;

public class Menu {
	private ProductService service;

	public Menu() {
		service = new ProductService();
	}

	public void run(Scanner sc) {
		
		boolean flag = true;
		int input;
		while (flag) {
			System.out.println("1.추가  2.번호로검색  3. 제품명으로검색  4.수정  5.삭제  6.전체출력  7.종료");
			input = sc.nextInt();

			switch (input) {
			case 1:
				service.allInput(sc);
				break;
			case 2:
				service.printProduct(sc);
				break;
			case 3:
				//service.searchName(sc);
				service.printByName(sc);
				break;
			case 4:
				service.modify(sc);
				break;
			case 5:
				service.delete(sc);
				break;
			case 6:
				service.allPrint();
				break;
			case 7:
				System.out.println("서비스 종료.");
				flag = false;
				break;
			default:
				System.out.println("😑 1 ~ 7 사이를 눌러주세요 😑");
			}
		}
	}
}
