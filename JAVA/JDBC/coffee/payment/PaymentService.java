package payment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import member.MemberService;
import menu.MenuVo;

public class PaymentService {
	PaymentDao dao;
	DecimalFormat decFormat = new DecimalFormat("###,###");

	public PaymentService() {
		dao = new PaymentDao();
	}

	public void insert(ArrayList<MenuVo> cart, double rate) { // ★☆ 결제내역에 할인된 가격이 들어가야지 응응..?
		for (int i = 0; i < cart.size(); i++) {
			dao.insert(new PaymentVo(null, cart.get(i).getMenuName(), (int) (cart.get(i).getPrice() * (1 - rate)),
					MemberService.LOGINID));
		}
	}

	public void showAll(Scanner sc) {
		while (true) {
			System.out.println(
					"1. 메뉴 이름당 전체 결제내역 보기, 2. 월별 결제 내역 보기, 3. 년별 결제 내역 보기, 4. 기간 정해서 결제 내역 보기 5. 모든 결제 내역 보기(다른 값을 넣으면 뒤로갑니다.)");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				selectMenuName(sc);
				break;
			case 2:
				month();
				break;
			case 3:
				year();
				break;
			case 4:
				selectPrice(sc);
				break;
			case 5:
				selectAll();
				break;
			default:
				return;
			}
		}
	}

	// 모두 보기.
	public void selectAll() {
		ArrayList<PaymentVo> list = dao.allPrint();
		for (PaymentVo temp : list) {
			String price = decFormat.format(temp.getPrice());
			System.out.print("날짜 : " + temp.getDay() + "\t | 메뉴명 : " + temp.getMenuName() + "\t | 가격 : " + price
					+ "원\t | id : ");
			if (temp.getId() == null) {
				System.out.println("탈퇴한 ID");
			} else {
				System.out.println(temp.getId());
			}
		}
	}

	// 메뉴 이름으로 찾기.
	public void selectMenuName(Scanner sc) {
		System.out.println("메뉴별 총 금액 보기");
		System.out.print("메뉴 이름을 입력해주세요 : ");
		String name = sc.next();
		ArrayList<PaymentVo> list = dao.menuPrint(name);
		if (list.isEmpty()) {
			System.out.println("없는 메뉴 입니다.");
			return;
		}
		for (PaymentVo vo : list) {
			String price = decFormat.format(vo.getPrice());
			System.out.print("메뉴 : " + vo.getMenuName());
			if (vo.getMenuName().length() <= 6)
				System.out.print("\t");
			System.out.println("\t| 총 금액 : " + price + "원");
		}
	}

	// 월별 찾기.
	public void month() {
		ArrayList<PaymentVo> list = dao.monthPrint();

		for (int i = 0; i < list.size(); i++) {
			String price = decFormat.format(list.get(i).getPrice());
			String[] d = list.get(i).getMenuName().split("");
			String year = "20" + d[0] + d[1] + "년 " + d[3] + d[4] + "월";
			System.out.println(year + " | 총 금액 : " + price + "원");
		}
	}

	// 년별 찾기.
	public void year() {
		ArrayList<PaymentVo> list = dao.yearPrint();

		for (int i = 0; i < list.size(); i++) {
			String price = decFormat.format(list.get(i).getPrice());
			String year = "20" + list.get(i).getMenuName() + "년";
			System.out.println(year + " |  총 금액 : " + price + "원");
		}
	}

	// 사장 ver : 원하는 날짜 검색해서 총 액 보기
	public void selectPrice(Scanner sc) {

		System.out.println("년도, 월 검색해서 총액 보기");
		System.out.println("처음 년도를 입력해주세요 : (ex.2005)");
		String firstYear = sc.next();
		System.out.println("처음 월을 입력해주세요 : (ex.03)");
		String firstMonth = sc.next();

		System.out.println("끝 년도를 입력해주세요 : (ex.2005)");
		String lastYear = sc.next();
		System.out.println("끝 월을 입력해주세요 : (ex.03)");
		String lastMonth = sc.next();

		PaymentVo vo = dao.selectPrice(firstYear + "-" + firstMonth, lastYear + "-" + lastMonth);
		String price = decFormat.format(vo.getPrice());
		System.out.println(
				firstYear + "년 " + firstMonth + "월부터 " + lastYear + "년 " + lastMonth + "월의 총 금액 : " + price + "원");
	}

	// 사용자 ver : id로 검색해서 결제 내역 보여주기
	public void paymentId(String id) {
		ArrayList<PaymentVo> list = dao.selectId(id);
		if (list.size() == 0) {
			System.out.println("결제 내역이 없습니다.");
		} else {
			for (PaymentVo temp : list) {
				String price = decFormat.format(temp.getPrice());
				System.out.print("날짜 : " + temp.getDay() + "\t| 메뉴명 : " + temp.getMenuName());
				int num=(int)((9-temp.getMenuName().length())/4);
				//System.out.print(num+" "+temp.getMenuName().length());
				for(int i=0;i<num;i++) {
					System.out.print("\t");
				}
				System.out.print("\t| 가격 : " + price + "원\t| id : " + temp.getId());
				System.out.println("   "+num+" "+temp.getMenuName().length());
			}
		}

	}
}
