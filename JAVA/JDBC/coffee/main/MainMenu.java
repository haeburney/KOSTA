package main;

import java.util.ArrayList;
import java.util.Scanner;

import board.BoardService;
import member.MemberService;
import membership.MembershipService;
import menu.MenuService;
import menu.MenuVo;
import payment.PaymentService;

public class MainMenu {
	MenuService menuService;
	MemberService memberService;
	PaymentService paymentService;
	MembershipService membershipService;
	BoardService boardService;

	public MainMenu() {
		menuService = new MenuService();
		memberService = new MemberService();
		paymentService = new PaymentService();
		membershipService = new MembershipService();
		boardService = new BoardService();
	}

	public void run(Scanner sc) {
		welcome();
		while (true) {
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
				if (MemberService.LOGINID != null)
					break;

			}
			while (MemberService.LOGINID != null) {
				StringBuilder sb = new StringBuilder();
				if (MemberService.LOGINID.equals("사장님"))
					sb.append("1. 메뉴 관리,");
				else
					sb.append("1. 구매 하기,");
				sb.append(" 2. 마이페이지, 3. 곡소리, 4. 로그아웃");
				System.out.println(sb.toString());
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
					memberService.logout();
					menuService.setCart(new ArrayList<MenuVo>());
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

	private void welcome() {
		System.out.println(" .d8888b.            .d888  .d888                           d8888   d8b          \r\n"
				+ "d88P  Y88b          d88P\"  d88P\"                           d8P888   Y8P          \r\n"
				+ "888    888          888    888                            d8P 888                \r\n"
				+ "888         .d88b.  888888 888888 .d88b.   .d88b.        d8P  888  8888  .d88b.  \r\n"
				+ "888        d88\"\"88b 888    888   d8P  Y8b d8P  Y8b      d88   888  \"888 d88\"\"88b \r\n"
				+ "888    888 888  888 888    888   88888888 88888888      8888888888  888 888  888 \r\n"
				+ "Y88b  d88P Y88..88P 888    888   Y8b.     Y8b.                888   888 Y88..88P \r\n"
				+ " \"Y8888P\"   \"Y88P\"  888    888    \"Y8888   \"Y8888             888   888  \"Y88P\"  \r\n"
				+ "                                                                    888          \r\n"
				+ "                                                                   d88P          \r\n"
				+ "                                                                 888P\"     ");
	}

	private void clientVoice(Scanner sc) {
		boolean flag = true;
		int n = 0;
		while (flag) {
			System.out.println("< 게시판 >");
			System.out.println("1.글 작성 2.검색 3.글 목록 4.관리자 확인 (다른 값을 넣으면 뒤로 갑니다.)");
			n = sc.nextInt();
			switch (n) {
			case 1:
				boardService.addWrite(sc);
				break;
			case 2:
				boardService.serach(sc);
				break;
			case 3:
				boardService.getListAll();
				break;
			case 4:
				if (MemberService.LOGINID.equals("사장님")) {
					boardService.Boss();
				} else {
					System.out.println("관리자가 아닙니다. 접근할 수 없는 서비스입니다.");
				}
				break;
			default:
				flag = false;
			}
		}
	}

	private void myPageRun(Scanner sc) {
		System.out.println(MemberService.LOGINID + "님의 MyPage입니다.");
		boolean tf = true;
		while (tf) {
			System.out.println(
					"1. 내 정보 확인하기, 2. 내 정보 수정하기, 3. 회원 탈퇴 하기, 4. 결제 내역 보기, 5. 내 멤버십 혜택 보기 6. 전체 멤버십 정보 보기(다른 번호 입력시 뒤로 갑니다.)");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				memberService.checkMyInfo();
				break;
			case 2:
				memberService.updateMyInfo(sc);
				break;
			case 3:
				memberService.withdraw(sc);
				menuService.setCart(new ArrayList<MenuVo>());
				return;
			case 4:
				if (MemberService.LOGINID.equals("사장님")) {
					paymentService.showAll(sc);
				} else {
					paymentService.paymentId(MemberService.LOGINID);
				}
				break;
			case 5:
				System.out.println(membershipService.select(MemberService.LOGINID));
				break;
			case 6:
				membershipService.selectAll();
				break;
			default:
				tf = false;
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
			double rate = membershipService.selectRate();
			switch (num) {
			case 1:
				menuService.getProduct(sc);
				break;
			case 2:
				menuService.printCart(rate);
				break;
			case 3:
				int temp = menuService.getCartSum(sc, rate);
				if (temp == 2) {
					memberService.point(menuService.printCart(rate));
					paymentService.insert(menuService.getCart(), rate);
					menuService.setCart(new ArrayList<MenuVo>());
				}
				break;
			default:
				tf = false;
				break;
			}
		}
		return;
	}
}
