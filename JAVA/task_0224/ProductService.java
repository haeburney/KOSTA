package Task_0224;

import java.util.Scanner;

public class ProductService {
	private Product[] prods;
	int count;

	public ProductService() {

	}

	public ProductService(int size) {
		prods = new Product[size];
	}

	public void allInput(Scanner sc) {
		Product p = new Product();

		if (count >= prods.length) {
			System.out.println("배열이 꽉 찼습니다.");
			return;
		}

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

		prods[count++] = p;

	}

	public void allPrint() {
		for (int i = 0; i < count; i++) {
			System.out.println(prods[i]);
		}
	}

	public int searchNumber(Scanner sc) {
		int s = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if (s == prods[i].getNum()) {
				return i;
			}
		}
		return -1;
	}

	public void printProduct(Scanner sc) {
		System.out.println("검색하고 싶은 넘버를 입력하세요");
		int idx = searchNumber(sc);

		if (idx < 0) {
			System.out.println("존재하지 않음");
		} else {
			System.out.println(prods[idx]);
		}
	}

	public String searchName(Scanner sc) {
		System.out.println("검색하고 싶은 제품명을 입력하세요");
		String s = sc.next();
		for (int i = 0; i < count; i++) {

		}
		return s;
	}

	public void modify(Scanner sc) {
		System.out.println("수정하고 싶은 숫자를 입력하세요");
		int idx = searchNumber(sc);
		Product p = new Product();
		
		if (idx < 0) {
			System.out.println("존재하지 않음");
		} else {
			System.out.println("수정전 데이터");
			System.out.println(prods[idx]);
			
			System.out.print("제품명 입력 : ");
			prods[idx].setName(sc.next());
			System.out.print("가격 입력 : ");
			prods[idx].setPrice(sc.nextInt());
			System.out.print("수량 : ");
			prods[idx].setAmount(sc.nextInt());

			
		}
	}

}
