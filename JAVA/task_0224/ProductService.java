package kosta_2;

import java.util.Scanner;

public class ProductService {
	private Product[] prods;
	private Product[] searchProds;
	int count;

	public ProductService() {

	}

	public ProductService(int size) {
		prods = new Product[size];
		searchProds = new Product[size];
	}

	public void allInput(Scanner sc) { // 1.추가
		Product p = new Product();

		if (count >= prods.length) {
			System.out.println("배열이 꽉 찼습니다.");
			return;
		}
		
		p.setNum(overlap(sc));
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

	public int overlap(Scanner sc) { // 번호 중복 체크
		System.out.println("제품 번호 입력 : ");
		int idx = overlapNumber(sc);
		if (idx == -1) {
			System.out.print("번호 중복! 다시 ");
			return overlap(sc);
		}
		return idx;
	}

	public int overlapNumber(Scanner sc) { // 2-1. 번호 중복 없으면 입력 계속 가능하게
		int s = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if (s == prods[i].getNum()) {
				return -1;
			}
		}
		return s;
	}

	public int searchNumber(Scanner sc) { // 2-1. 번호 중복 있으면 그거 리턴
		int s = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if (s == prods[i].getNum()) {
				return i;
			}
		}
		return -1;
	}

	public void printProduct(Scanner sc) { // 2. 번호로 검색
		System.out.println("검색하고 싶은 넘버를 입력하세요");
		int idx = searchNumber(sc);

		if (idx < 0) {
			System.out.println("존재하지 않음");
		} else {
			System.out.println(prods[idx]);
		}
	}

	public void searchName(Scanner sc) { // 3. 제품명으로 검색
		int cnt = 0;
		System.out.println("검색하고 싶은 제품명을 입력하세요");
		String s = sc.next();
		for (int i = 0; i < count; i++) {
			if (prods[i].getName().equals(s)) {
				searchProds[cnt]=new Product();
				searchProds[cnt].setAmount(prods[i].getAmount());
				searchProds[cnt].setId(prods[i].getId());
				searchProds[cnt].setName(prods[i].getName());
				searchProds[cnt].setNum(prods[i].getNum());
				searchProds[cnt].setPrice(prods[i].getPrice());
				searchProds[cnt].setUrl(prods[i].getUrl());
				cnt++;
			}
		}

		if (cnt == 0) {
			System.out.println("검색한 제품이 존재하지 않습니다.");
		} else {
			for (int i = 0; i < cnt; i++) {
				System.out.println(searchProds[i]);
			}
		}
	}

	public void modify(Scanner sc) { // 4. 수정
		System.out.println("수정하고 싶은 숫자를 입력하세요");
		int idx = searchNumber(sc);

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

			System.out.println("수정후 데이터");
			System.out.println(prods[idx]);
		}
	}

	public void delete(Scanner sc) { // 5.삭제
		System.out.println("삭제하고 싶은 번호를 입력하세요");
		int idx = searchNumber(sc);

		System.out.println("삭제 전 정보");
		for (int i = 0; i < count; i++) {
			System.out.println(prods[i]);
		}

		if (idx < 0) {
			System.out.println(idx + "번의 데이터가 존재하지 않습니다.");
		} else {
			if (idx == count - 1) {
				/*
				 * prods[idx].setAmount(0); prods[idx].setId(null); prods[idx].setName(null);
				 * prods[idx].setNum(0); prods[idx].setPrice(0); prods[idx].setUrl(null);
				 */
				count--;
			} else {
				for (int i = idx; i < count - 1; i++) {
					prods[i].setAmount(prods[i + 1].getAmount());
					prods[i].setId(prods[i + 1].getId());
					prods[i].setName(prods[i + 1].getName());
					prods[i].setNum(prods[i + 1].getNum());
					prods[i].setPrice(prods[i + 1].getPrice());
					prods[i].setUrl(prods[i + 1].getUrl());
				}
				count--;
			}
		}

		System.out.println("삭제 후 정보");
		for (int i = 0; i < count; i++) {
			System.out.println(prods[i]);
		}
	}

	public void allPrint() { // 6.전체출력
		for (int i = 0; i < count; i++) {
			System.out.println(prods[i]);
		}
	}
}