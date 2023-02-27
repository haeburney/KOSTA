package Task_0227;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
	private ArrayList<Product> listProds;
	private ArrayList<Product> searchList;

	public ProductService() {

	}

	public ProductService(int size) {
		listProds = new ArrayList<Product>();
		searchList = new ArrayList<Product>();
	}

	public void allInput(Scanner sc) { // 1.추가
		Product p = new Product();

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
		listProds.add(p);
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
		for (int i = 0; i < listProds.size(); i++) {
			if (s == listProds.get(i).getNum()) {
				return -1;
			}
		}
		return s;
	}

	public int searchNumber(Scanner sc) { // 2-1. 번호 중복 있으면 그거 리턴
		int s = sc.nextInt();
		for (int i = 0; i < listProds.size(); i++) {
			if (s == listProds.get(i).getNum()) {
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
			System.out.println(listProds.get(idx));
		}
	}

	public void searchName(Scanner sc) { // 3. 제품명으로 검색
		System.out.println("검색하고 싶은 제품명을 입력하세요");
		searchList.clear();
		Product p = new Product();
		int cnt = 0;
		String s = sc.next();
		for (int i = 0; i < listProds.size(); i++) {
			if (listProds.get(i).getName().equals(s)) {
				p.setAmount(listProds.get(i).getAmount());
				p.setNum(listProds.get(i).getNum());
				p.setName(listProds.get(i).getName());
				p.setId(listProds.get(i).getId());
				p.setPrice(listProds.get(i).getPrice());
				p.setUrl(listProds.get(i).getUrl());
				searchList.add(p);
				cnt++;
			}
		}

		if (cnt == 0) {
			System.out.println("검색한 제품이 존재하지 않습니다.");
		} else {
			for (int i = 0; i < searchList.size(); i++) {
				System.out.println(searchList.get(i));
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
			System.out.println(listProds.get(idx));

			System.out.print("제품명 입력 : ");
			listProds.get(idx).setName(sc.next());

			System.out.print("가격 입력 : ");
			listProds.get(idx).setPrice(sc.nextInt());
		
			System.out.print("수량 : ");
			listProds.get(idx).setAmount(sc.nextInt());

			System.out.println("수정후 데이터");
			System.out.println(listProds.get(idx));
		}
	}

	public void delete(Scanner sc) { // 5.삭제
		System.out.println("삭제하고 싶은 번호를 입력하세요");
		int idx = searchNumber(sc);

		System.out.println("삭제 전 정보");
		for (int i = 0; i < listProds.size(); i++) {
			System.out.println(listProds.get(i));
		}

		if (idx < 0) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		} else {
			for (int i = idx; i < listProds.size() - 1; i++) {
				listProds.get(i).setAmount(listProds.get(i + 1).getAmount());
				listProds.get(i).setId(listProds.get(i + 1).getId());
				listProds.get(i).setName(listProds.get(i + 1).getName());
				listProds.get(i).setNum(listProds.get(i + 1).getNum());
				listProds.get(i).setPrice(listProds.get(i + 1).getPrice());
				listProds.get(i).setUrl(listProds.get(i + 1).getUrl());
			}
			listProds.remove(listProds.size() - 1);
		}

		System.out.println("삭제 후 정보");
		for (int i = 0; i < listProds.size(); i++) {
			System.out.println(listProds.get(i));
		}
	}

	public void allPrint() { // 6.전체출력
		for (int i = 0; i < listProds.size(); i++) {
			System.out.println(listProds.get(i));
		}
	}
}