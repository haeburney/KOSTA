package product2;

import java.util.ArrayList;
import java.util.Scanner;

import Task_0227.Product;

public class ProductService {
	private ArrayList<Product> listProds;
	private ArrayList<Product> searchList;

	public ProductService() {
		listProds = new ArrayList<Product>();
		searchList = new ArrayList<Product>();
		// listProds = new ArrayList<>();
	}

	public void allInput(Scanner sc) { // 1.추가
		Product p = new Product();

		int idx = 0;
		while (idx >= 0) {
			System.out.print("제품 번호 입력ㅎㅎ : ");
			p.setNum(sc.nextInt());
			idx = listProds.indexOf(p);
			if (idx == 0) {
				System.out.print("번호가 중복! 다시 ");
			}
		}

		// p.setNum(overlap(sc));
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
		System.out.println(p);
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
		System.out.print("검색하고 싶은 넘버를 입력하세요 : ");
		int num = sc.nextInt();
		Product p = new Product();
		p.setNum(num);
		int idx = listProds.indexOf(p);

		if (idx < 0) {
			System.out.println("존재하지 않음");
		} else {
			System.out.println(listProds.get(idx));
		}
	}

	public void searchName(Scanner sc) { // 3. 제품명으로 검색
		System.out.print("검색하고 싶은 제품명을 입력하세요 : ");
		String s = sc.next();
		searchList.clear();

		for(Product p:listProds) {
			if(p.getName().equals(s)) {
				searchList.add(p);
			}
		}

		if (searchList.size() == 0) {
			System.out.println("검색한 제품이 존재하지 않습니다.");
		} else {
			for(Product p:searchList) {
				System.out.println(p);
			}
		}
	}

	// 3. 제품명으로 검색 (쌤.ver) 중복된 것 모두 찾아줌
	public ArrayList<Product> getByName(Scanner sc) {
		System.out.print("검색할 제품명 : ");
		String name = sc.next();
		ArrayList<Product> datas = new ArrayList<>();
		for(Product p:listProds) {
			if(p.getName().equals(name)) {
				datas.add(p);
			}
		}

		return datas;
	}

	public void printByName(Scanner sc) {
		ArrayList<Product> datas = getByName(sc);

		if (datas.isEmpty()) {
			System.out.println("검색된 제품이 없습니다.");
			return;
		}

		for (Product p : datas) {
			System.out.println(p);
		}
	}

	public void modify(Scanner sc) { // 4. 수정
		System.out.print("수정하고 싶은 숫자를 입력하세요 : ");
		Product p = new Product();
		int num = sc.nextInt();
		p.setNum(num);
		int idx = listProds.indexOf(p);

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
		Product p = new Product();

		System.out.print("삭제하고 싶은 번호를 입력하세요 : ");
		int num = sc.nextInt();
		p.setNum(num);
		
		if(listProds.remove(p)) {
			System.out.println(p.getNum()+"번의 데이터가 삭제됐습니다.");
		} else {
			System.out.println("데이터가 존재하지 않습니다.");
		}
	}

	public void allPrint() { // 6.전체출력
		for (Product p : listProds) {
			System.out.println(p);
		}
	}
}