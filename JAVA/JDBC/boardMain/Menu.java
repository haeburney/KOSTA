package boardMain;

import java.util.Scanner;

import board.BoardService;
import member.MemberService;

public class Menu {
	private MemberService mService;
	private BoardService bService;

	public Menu() {
		mService = new MemberService();
		bService = new BoardService();
	}

	public void run(Scanner sc) {
		int num = 0;
		boolean flag = true;

		while (flag) {
			System.out.println("1.회원관리  2.게시판  3.종료  ");
			num = sc.nextInt();

			switch (num) {
			case 1:
				mrun(sc); // 회원관리 하위 메뉴 돌림
				break;
			case 2:
				brun(sc);
				break;
			case 3:
				System.out.println("프로그램 종료");
				flag = false;
				return;
			default:
				System.out.println("1 ~ 3 사이의 번호를 입력해주세요");
			}
		
		}
	}

	public void mrun(Scanner sc) {
		int num = 0;
		boolean flag = true;

		while (flag) {
			System.out.println("1.회원가입  2.로그인  3.로그아웃  4.내정보확인  5.내정보수정  6.탈퇴  7. 상위 메뉴");
			num = sc.nextInt();

			switch (num) {
			case 1: // 회원가입
				mService.join(sc);
				break;
			case 2: // 로그인
				mService.login(sc);
				break;
			case 3: // 로그아웃
				mService.logout();
				break;
			case 4: // 내 정보 확인
				mService.printMyInfo();
				break;
			case 5: // 내 정보 수정
				mService.myInfoUpdate(sc);
				break;
			case 6: // 탈퇴
				mService.delete();
				break;
			case 7: // 종료
				flag = false;
				break;
			default:
				System.out.println("1 ~ 7 사이의 번호를 입력해주세요");
				break;
			}
		}
	}

	public void brun(Scanner sc) {
		if(MemberService.LoginId==null) {
			System.out.println("게시판 메뉴는 로그인 후 사용 가능");
			return;
		} 
		
		int num = 0;
		boolean flag = true;

		while (flag) {
			System.out.println("1.글작성  2. 글전체목록  3.번호로 검색  4.작성자로검색  5.제목으로검색  6. 이전 메뉴");
			num = sc.nextInt();

			switch (num) {
			case 1:
				bService.addBoard(sc);
				break;
			case 2:
				bService.all();
				break;
			case 3:
				bService.detail(sc);
				break;
			case 4:
				//bService.update(sc);
				bService.searchWriter(sc);
				break;
			case 5:
				//bService.delete(sc);
				bService.searchTitle(sc);
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("1 ~ 8 사이의 번호를 입력해주세요");
				break;
			}
		}
	}

}
