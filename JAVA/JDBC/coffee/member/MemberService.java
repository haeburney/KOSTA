package member;

import java.util.Scanner;

import menu.MenuService;
import membership.MembershipDao;

public class MemberService {
	MemberVo vo;
	MemberDao dao;
	MenuService ms;
	public static String LOGINID;
	
	MembershipDao msDao;

	public MemberService() {
		vo = new MemberVo();
		dao = new MemberDao();
		ms = new MenuService();
		msDao = new MembershipDao();
	}

	// 회원가입
	public void join(Scanner sc) {
		System.out.println("[회원가입]");
		MemberVo vo = new MemberVo();
		String id = "";
		while (true) {
			System.out.print("생성할 ID: ");
			id = sc.next();
			MemberVo m = dao.select(id);
			if (m == null) {
				break;
			} else {
				System.out.println("이미 존재하는 ID입니다. 다시 입력해주세요.");
			}
		}
		vo.setId(id);
		System.out.print("비밀번호: ");
		vo.setPwd(sc.next());
		System.out.print("이름: ");
		vo.setName(sc.next());
		System.out.print("핸드폰 번호: ");
		vo.setPn(sc.next());

		dao.insert(vo);
	}

	// 로그인
	public void login(Scanner sc) {
		System.out.println("[로그인]");
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("비밀번호: ");
		String pwd = sc.next();
		MemberVo vo = dao.select(id);
		if (vo == null) {
			System.out.println("존재하지 않는 ID입니다.");
		} else {
			if (pwd.equals(vo.getPwd())) {
				LOGINID = id;
				System.out.println(LOGINID + "님 로그인 되었습니다.");
			} else {
				System.out.println("정확한 비밀번호를 입력하세요.");
			}
		}
	}

	// 로그아웃
	public void logout() {
		if (LOGINID == null) {
			System.out.println("이미 로그아웃 상태입니다.");
		} else {
			System.out.println(LOGINID + "님 로그아웃 되었습니다.");
			LOGINID = null;
		}
	}

	// 내 정보 확인
	public boolean checkMyInfo() {
		if (LOGINID == null) {
			System.out.println("로그인 후 이용가능합니다.");
			return false;
		} else {
			System.out.println(dao.select(LOGINID));
			return true;
		}
	}

	// 내 정보 수정(비밀번호, 이름, 핸드폰번호)
	public void updateMyInfo(Scanner sc) {
		System.out.println("[정보수정]");
		boolean flag = checkMyInfo();
		if (flag == false) {
			return;
		}
		
		System.out.print("정보를 수정하려면 비밀번호를 입력하세요.");
		String password = sc.next();
		if(vo.getPwd().equals(password)) {
			System.out.print("수정할 비밀번호: ");
			String pwd = sc.next();
			System.out.print("수정할 이름: ");
			String name = sc.next();
			System.out.print("수정할 핸드폰번호: ");
			String phnum = sc.next();
			
			dao.update(new MemberVo(LOGINID, pwd, name, phnum, 0, ""));
		} else {
			System.out.println("잘못된 비밀번호입니다.");
		}
	}

	// 포인트 적립
	public void point(int sum) {
		MemberVo vo = dao.select(LOGINID);
		int point = (int) (sum * 0.1);
		int pointsum = vo.getPoint() + point;
		dao.pointUpdate(new MemberVo(LOGINID, null, null, null, pointsum, null));
		System.out.println("포인트 " + point + "점이 적립되었습니다.");
		grade();
	}

	// 포인트 등급 비교
	public void grade() {
		MemberVo vo = dao.select(LOGINID);
		String gradeName = msDao.grade(vo.getPoint());
		vo.setGrade(gradeName);
		System.out.println(gradeName + "등급이 되셨습니다. 축하드립니다.");
	}

	// 탈퇴
	public void withdraw(Scanner sc) {
		System.out.println("[회원 탈퇴]");
		if (LOGINID == null) {
			System.out.println("로그인 후 이용가능합니다.");
		} else {
			System.out.println("회원 탈퇴 하시겠습니까? Y/N");
			String a = sc.next();
			if (a.equals("Y")) {
				dao.delete(LOGINID);
			}
			LOGINID = null;
		}
	}
}
