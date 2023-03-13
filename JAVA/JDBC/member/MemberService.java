package member;

import java.util.Scanner;

public class MemberService {
	private MemberDao dao;
	public static String LoginId;
	// 로그인 한 사람의 아이디 저장. 이 값이 null이면 로그인 안 한 상태

	public MemberService() {
		dao = new MemberDao();
	}

	// 1. 회원 가입
	public void join(Scanner sc) {
		String id = "", pwd = "", name = "", email = "";
		MemberVo vo = new MemberVo();

		System.out.println("***** 회원가입 *****");

		while (true) {
			System.out.print("ID 입력 : ");
			id = sc.next();
			MemberVo m = dao.select(id);
			if (m == null) {
				System.out.println("입력하신 ID로 회원가입할 수 있습니다.");
				break;
			} else {
				System.out.println("중복되는 ID가 있습니다. 다시 입력해주세요");
			}
		}

		System.out.print("password 입력 : ");
		pwd = sc.next();
		System.out.print("name 입력 : ");
		name = sc.next();
		System.out.print("email 입력 : ");
		email = sc.next();

		dao.insert(new MemberVo(id, pwd, name, email));
		System.out.println("로그인 완");

		/*
		 * 선생님 코드 vo.setId(id); vo.setPwd(sc.next()); vo.setName(sc.next());
		 * vo.setEmail(sc.next());
		 */
	}

	public void login(Scanner sc) {
		if (LoginId == null) {
			System.out.println("***** 로그인 *****");
			System.out.print("id 입력 : ");
			String id = sc.next();
			System.out.print("pwd 입력 : ");
			String pwd = sc.next();

			MemberVo idCheck = dao.select(id);

			if (idCheck == null) {
				System.out.println("없는 아이디입니다.");
			} else {
				if (idCheck.getPwd().equals(pwd)) {
					System.out.println("로그인에 성공하였습니다.");
					LoginId = id;
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
		} else {
			System.out.println("이미 로그인이 되어 있습니다. :)");
		}
	}

	public void logout() {
		if (LoginId == null) {
			System.out.println("로그인이 되어 있지 않습니다.");
		} else {
			LoginId = null;
		}
	}

	public void printMyInfo() {
		if (check(LoginId) == false) {
			return;
		}
		System.out.println("***** 나의 정보 보기 *****");
		MemberVo vo = dao.select(LoginId);
		System.out.println("id : " + vo.getId() + ",  name : " + vo.getName() + ",  email" + vo.getEmail());
	}

	public void myInfoUpdate(Scanner sc) {
		if (check(LoginId) == false) {
			return;
		}

		System.out.println("***** 나의 정보 업데이트 *****");
		String pwd = "";

		while (true) {
			System.out.print("pwd 입력 : ");
			pwd = sc.next();
			System.out.print("pwd 확인 입력 : ");
			String check = sc.next();

			if (pwd.equals(check)) {
				System.out.println("pwd 입력 완~");
				break;
			} else {
				System.out.println("재입력 해주세요.");
			}
		}
		System.out.print("name 입력 : ");
		String name = sc.next();

		dao.update(new MemberVo(LoginId, pwd, name, ""));
	}

	public void delete() {
		System.out.println("***** 회원 탈퇴 *****");
		if (check(LoginId) == false) {
			return;
		}
		dao.delete(LoginId);
		LoginId = null;
	}

	public boolean check(String id) {
		if (id == null) {
			System.out.println("로그인이 되어 있지 않습니다.");
			return false;
		} else {
			return true;
		}
	}
}
