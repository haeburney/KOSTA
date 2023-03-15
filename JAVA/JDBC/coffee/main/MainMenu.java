package main;

import java.util.Scanner;

import member.MemberService;
import membership.MembershipService;
import menu.MenuService;
import payment.PaymentService;

public class MainMenu {
	MenuService menuService;
	MemberService memberService;
	PaymentService paymentService;
	MembershipService membershipService;

	public MainMenu() {
		menuService = new MenuService();
		memberService = new MemberService();
		paymentService = new PaymentService();
		membershipService = new MembershipService();
	}

	public void run(Scanner sc) {
		while (true) {
			System.out.println("1. 로그인 하기, 2. 회원가입 하기 (다른 값을 넣으면 서비스가 종료됩니다.)");
			int temp = sc.nextInt();
			while (temp == 2) {
				memberService.join(sc);
				System.out.println("1. 로그인 하기, 2. 회원가입 하기 (다른 값을 넣으면 서비스가 종료됩니다.)");
				temp = sc.nextInt();

			}
			if (temp != 1) {
				System.out.println("서비스를 종료합니다.");
				return;
			}
			memberService.login(sc);
			boolean tf = true;
			while (tf) {
				System.out.println("1. 구매하기, 2. 내 정보 보기, 3. 곡소리, 4. 로그아웃, 5. 회원탈퇴");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					menuRun(sc);
					break;
				case 2:
					// 내 정보 수정 및 삭제, 내 등급에 따른 멤버십 정보 보기,
					myPageRun(sc);
					break;
				case 3:
					// 고객의 소리.
					clientVoice(sc);
					break;
				case 4:
					tf = false;
					memberService.logout();
					break;
				case 5:
					memberService.withdraw(sc);
					break;
				}
			}
			System.out.println("서비스를 종료하기 위해선 0을 입력하세요. (계속 하려면 아무키나 누르세요.)");
			if (sc.next().equals("0")) {
				System.out.println("서비스를 종료합니다.");
				return;
			}
		}

	}

	private void clientVoice(Scanner sc) {
		
	}

	private void myPageRun(Scanner sc) {
		System.out.println(MemberService.LOGINID + "님의 MyPage입니다.");
		boolean tf = true;
		while (tf) {
			System.out.println(
					"1. 내 정보 확인하기, 2. 내 정보 수정하기, 3. 결제 내역 보기, 4. 내 멤버십 혜택 보기 (다른 번호 입력시 뒤로 갑니다.)");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				memberService.checkMyInfo();
				break;
			case 2:
				memberService.updateMyInfo(sc);
				break;
			case 3:
				paymentService.paymentId(MemberService.LOGINID);
				break;
			case 4:
				System.out.println(membershipService.select(MemberService.LOGINID));
				break;
			}
		}
	}

	private void menuRun(Scanner sc) {
		System.out.println("반갑습니다. " + MemberService.LOGINID);
		boolean tf = true;
		if (MemberService.LOGINID.equals("사장님")) {
			while (tf) {
				System.out.println("1. 제품 추가하기, 2. 제품 검색 후 작업하기, 3. 전체 메뉴 출력하기 (다른 번호 입력시 뒤로 갑니다.)");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					menuService.add(sc);
					menuService.getAll();
					break;
				case 2:
					menuService.getByNum(sc);
					break;
				case 3:
					menuService.getAll();
					break;
				default:
					tf = false;
				}

			}

			return;
		}
		while (tf) {
			System.out.println("1. 제품 장바구니에 담기, 2. 장바구니 보기 3. 결제하기 (다른 번호를 누르면 뒤로 갑니다.)");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				menuService.getProduct(sc);
				break;
			case 2:
				menuService.getCartSum();
				break;
			case 3:
				memberService.point(menuService.getCartSum());
				paymentService.insert(menuService.getCart());
				menuService.setCart(null);
				break;
			default:
				tf = false;
				break;
			}
		}
		return;
	}
}
