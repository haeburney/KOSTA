package board;

import java.util.ArrayList;
import java.util.Scanner;

import member.MemberService;

public class BoardService {
	private BoardDao dao;

	public BoardService() {
		dao = new BoardDao();
	}

	// 1. 글 작성
	public void addBoard(Scanner sc) {
		BoardVo vo = new BoardVo();
		System.out.println("***** 글 작성 *****");
		System.out.print("title : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("content : ");
		// sc.nextLine(); // 버퍼에 남은 엔터 제거
		String content = sc.nextLine();

		dao.insert(new BoardVo(0, MemberService.LoginId, null, title, content));
	}

	// 2. 글 전체 목록
	public void all() {
		ArrayList<BoardVo> list = dao.selectAll();

		for (BoardVo vo : list) {
			System.out.println("|" + vo.getNum() + "|" + vo.getTitle() + "\t|" + vo.getWriter() + "\t|");
		}
	}

	// 3. 글 번호로 상세
	public void detail(Scanner sc) {
		System.out.println("***** 글 상세 *****");
		System.out.print("글번호를 입력해주세요 : ");
		int num = sc.nextInt();
		BoardVo vo = dao.select(num);
		if (vo == null) {
			System.out.println("없는 글 번호 입니다.");
		} else {
			System.out.println("|" + vo.getNum() + "|" + vo.getTitle() + "\t|" + vo.getWriter() + "\t|");
			if (MemberService.LoginId.equals(vo.getWriter())) {
				System.out.println("1.수정  2.삭제  3.이전메뉴");
				int m = sc.nextInt();
				switch (m) {
				case 1:
					editBoard(sc, vo.getNum());
					break;
				case 2:
					delBoard(vo.getNum());
					break;
				}
			}

		}
	}

	// 3-1. 글수정
	public void editBoard(Scanner sc, int num) {
		System.out.println("<글수정>");
		System.out.print("new Title : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("new content : ");
		String content = sc.nextLine();
		dao.update(new BoardVo(num, null, null, title, content));
	}
	
	public void delBoard(int num) {
		dao.delete(num);
	}

	// 4. 내 글 수정
	public void update(Scanner sc) {
		BoardVo vo = new BoardVo();
		System.out.println("***** 내 글 수정 *****");
		ArrayList<BoardVo> list = dao.selectId(MemberService.LoginId);

		if (list.size() == 0) {
			System.out.println("작성하신 글이 없습니다.");
		} else {
			for (BoardVo li : list) {
				System.out.println(li);
			}
			System.out.print("수정하고 싶은 번호를 입력하세요 : ");
			// sc.nextLine();
			int num = sc.nextInt();
			System.out.print("title 수정 : ");
			sc.nextLine();
			String title = sc.next();
			System.out.print("content 수정 : ");
			String content = sc.next();

			dao.update(new BoardVo(num, MemberService.LoginId, null, title, content));
		}
	}

	// 5. 내 글 삭제
	public void delete(Scanner sc) {
		BoardVo vo = new BoardVo();
		System.out.println("***** 내 글 삭제 *****");
		ArrayList<BoardVo> list = dao.selectId(MemberService.LoginId);

		if (list.size() == 0) {
			System.out.println("작성하신 글이 없습니다.");
		} else {
			for (BoardVo li : list) {
				System.out.println(li);
			}
			System.out.print("삭제하고 싶은 번호를 입력하세요 : ");
			int num = sc.nextInt();

			dao.delete(num);
		}
	}

	// 6. 작성자로 검색
	public void searchWriter(Scanner sc) {
		System.out.print("작성자 검색 : ");
		String writer = sc.next();
		ArrayList<BoardVo> list = dao.selectId(writer);

		for (BoardVo vo : list) {
			System.out.println(vo.getTitle() + "\t" + vo.getContent());
		}
	}

	// 7. 제목으로 검색
	public void searchTitle(Scanner sc) {
		System.out.print("제목 검색 : ");
		String writer = sc.next();
		ArrayList<BoardVo> list = dao.selectTitle(writer);
		for (BoardVo vo : list) {
			System.out.println(vo);
		}
	}
}
