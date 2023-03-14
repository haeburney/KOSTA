package payment;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentService {
	PaymentDao dao;
	public static String id;
	// 로그인 되면 값이 들어가있고 아니면 null

	public PaymentService() {
		dao = new PaymentDao();
	}

	public void insert() { // ★☆
		// day : 오늘 날짜 / id : 로그인 된 id로 / count : 결제내역에서 불러오기? / name price : 메뉴 테이블에서
		// 가격 가져오기
	}

	public void selectAll() {
		ArrayList<PaymentVo> list = dao.allPrint();

		for (PaymentVo vo : list) {
			System.out.println(vo);
		}
	}

	public void selectMenuName(Scanner sc) {
		String name = sc.next();
		System.out.println("메뉴별 총 금액 보기");
		System.out.print("메뉴 이름을 입력해주세요 : ");
		PaymentVo vo = dao.menuPrint(name);

		System.out.println("메뉴 : " + vo.getMenuName() + "  / 총 수량 : " + vo.getCount() + "  / 총 금액 : " + vo.getPrice());
	}

	public void month() {
		ArrayList<PaymentVo> list = dao.monthPrint();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("월별 : " + list.get(i).getMenuName() + "  / 총 수량 : " + list.get(i).getCount()
					+ " /  총 금액 : " + list.get(i).getPrice());
		}
	}

	public void year() {
		ArrayList<PaymentVo> list = dao.yearPrint();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("월별 : " + list.get(i).getMenuName() + "  / 총 수량 : " + list.get(i).getCount()
					+ " /  총 금액 : " + list.get(i).getPrice());
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
		System.out.println("총 수량 : " + vo.getCount() + "  / 총 금액 : " + vo.getPrice());
	}

	// 사용자 ver : id로 검색해서 결제 내역 보여주기
	public void paymentId() {
		if (id != null) {
			PaymentVo vo = dao.selectId(id);

			System.out.println(vo);
		}
	}
}
