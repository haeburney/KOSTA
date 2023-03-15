package menu;

import java.util.ArrayList;
import java.util.Scanner;

import membership.MembershipService;

public class MenuService {
	private MenuDao menuDao;
	public static String LOGINID;
	private ArrayList<MenuVo> cart;
	MembershipService membershipService;

	public MenuService() {
		menuDao = new MenuDao();
		cart = new ArrayList<>();
		membershipService=new MembershipService();
	}

	// 1-1. (사장님) 메뉴 추가
	public void add(Scanner sc) {
		System.out.println("제품 추가");
		System.out.print("menuName:");
		String menuName = sc.next();
		System.out.print("category (음료, 푸드):");
		String category = sc.next();
		while (!(category.equals("음료") || category.equals("푸드"))) {
			System.out.println("카테고리가 잘못되었습니다. 음료나 푸드 중 하나로 선택해주세요.");
			category = sc.next();
		}
		System.out.print("price:");
		int price = sc.nextInt();
		System.out.print("메뉴 설명:");
		sc.nextLine(); // 버퍼에 남은 엔터 제거.(초기화)
		String expl = sc.nextLine();
		System.out.print("Choose / Hot / Iced (없으면 0 입력):");
		String hc = sc.next();
		menuDao.insert(new MenuVo(0, category, menuName, price, expl, hc));

	}

	// 2. (사장님) 전체 메뉴 출력
	public void getAll() {
		System.out.println("<글 전체 목록>");
		ArrayList<MenuVo> list = menuDao.selectAll();
		for (MenuVo vo : list) {
			System.out.println("|" + vo.getNum() + "\t|" + vo.getCategory() + "\t|" + vo.getMenuName() + "\t|"
					+ vo.getPrice() + "\t|" + vo.getExpl() + "\t|" + vo.getHc() + "\t|");
		}
	}

	// 3. (사장님) 메뉴번호 입력해서 메뉴 수정/삭제

	// 3-0 메뉴 검색.
	public int select(Scanner sc) {
		System.out.println("메뉴 번호를 입력하세요.");
		int num = sc.nextInt();
		while (menuDao.selectByNum(num) == null) {
			System.out.println("없는 번호 입니다. 다시 입력하세요. 뒤로가기 : 0");
			num = sc.nextInt();
			if (num == 0)
				break;
		}

		return num;
	}

	// 3-1. 메뉴 수정 -- 가격, 설명 수정
	public void editMenu(Scanner sc, int num) {
		System.out.println("<메뉴 수정>");
		MenuVo vo = menuDao.selectByNum(num);
		System.out.println(vo + "의 제품을 수정합니다.");
		System.out.print("new price:");
		int price = sc.nextInt();
		System.out.print("new 메뉴 설명:");
		sc.nextLine(); // 버퍼에 남은 엔터 제거.(초기화)
		String expl = sc.nextLine();
		vo.setPrice(price);
		vo.setExpl(expl);

		menuDao.update(vo); // db에서 글 수정
	}

	// 3-2. 메뉴 번호 입력해서 수정/삭제 선택
	public void getByNum(Scanner sc) {
		System.out.println("<메뉴 번호로 검색>");
		int num = select(sc);
		if (num == 0)
			return;
		MenuVo vo = menuDao.selectByNum(num); // db에 검색해서 있으면 vo, 없으면 null 반환.
		if (vo == null) {
			System.out.println("없는 메뉴입니다.");
		} else {
			System.out.println(vo);
			System.out.println("1.수정 2.삭제 3.이전메뉴");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				editMenu(sc, num);
				break;
			case 2:
				menuDao.delete(num); // 글 삭제
				break;
			case 3:
				return;
			}
		}
	}

	// 4-0. (손님) 제품 장바구니에 담기
	public void getProduct(Scanner sc) {
		boolean tf = true;
		while (tf) {
			System.out.println("원하는 카테고리릉 입력하세요. 1. 음료, 2. 푸드 (다른 값을 입력하면 뒤로갑니다.)");
			int num = sc.nextInt();
			if (num == 1) {
				getBev(sc);
			} else if (num == 2) {
				getFood(sc);
			} else
				tf = false;
		}
		return;
	}

	// 4-1. (손님) 음료 리스트 출력
	public void getBev(Scanner sc) {
		System.out.println("<음료 메뉴 목록>");
		ArrayList<MenuVo> list = menuDao.selectBev();
		for (MenuVo vo : list) {
			System.out.println("|" + vo.getNum() + "\t|" + vo.getMenuName() + "\t|" + vo.getPrice() + "\t|"
					+ vo.getExpl() + "\t|" + vo.getHc() + "\t|");
		}
		int num = select(sc);
		if (num == 0)
			return;
		MenuVo vo = menuDao.selectByNum(num);
		if (vo.getHc().equals("choose")) {
			System.out.print("1.Hot 2.Iced:");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				vo.setHc("Hot");
				break;
			case 2:
				vo.setHc("Iced");
				break;
			}
		}
		System.out.println("음료를 담을 갯 수를 입력하세요.");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			list.add(vo);
		}
	}

	// 4-2. (손님) 푸드 리스트 출력
	public void getFood(Scanner sc) {
		System.out.println("<푸드 메뉴 목록>");
		ArrayList<MenuVo> list = menuDao.selectFood();
		for (MenuVo vo : list) {
			System.out.println("|" + vo.getNum() + "\t|" + vo.getMenuName() + "\t|" + vo.getPrice() + "\t|"
					+ vo.getExpl() + "\t|");
		}
		int num = select(sc);
		if (num == 0)
			return;
		MenuVo vo = menuDao.selectByNum(num);
		System.out.println("음료를 담을 갯 수를 입력하세요.");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			list.add(vo);
		}
	}

	// 총 장바구니 + 총 가격 + 할인된 가격
	public int getCartSum() {
		int sum = 0;
		System.out.println("<장바구니 목록>");
		for (int i = 0; i < cart.size(); i++) {
			MenuVo vo = cart.get(i);
			System.out.println("|" + i + "\t|" + vo.getMenuName() + "\t|" + vo.getPrice() + "\t|" + vo.getHc() + "\t|");

			sum += cart.get(i).getPrice();
		}
		System.out.println("<총 가격:" + sum + ">");

		 int discount = sum - ((int) (sum * membershipService.selectRate()));
		 System.out.println("<할인된 가격:" + discount + ">");
		return sum;
	}

	// 장바구니 취소
	public void cancel(Scanner sc) {
		System.out.print("취소할 메뉴 번호:");
		int i = sc.nextInt();
		cart.remove(i);
		getCartSum();

	}

	// 결제 후 포인트 반환 -> 회원관리 업데이트
	
//	  public int payment() { System.out.println("결제되었습니다.");
//	  
//	  int point = (int) (getCartSum() * 0.1); // 포인트 적립율 
//	  System.out.println(point +" 표인트 적립되었습니다.");
//	  
//	  return point;
//	  
//	  }
	 
	
	
	
	
	
	
	

	// 결제 후 장바구니 반환 -> 판매내역/구매내역 업데이트
	public ArrayList<MenuVo> getCart() {
		return cart;
	}

	public void setCart(ArrayList<MenuVo> cart) {
		this.cart = cart;
	}

}
