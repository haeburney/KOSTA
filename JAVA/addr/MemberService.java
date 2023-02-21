package addr;

import java.util.Scanner;

// service : 사용자 기능 제공 
public class MemberService {
	// dao 객체를 멤버로 선언
	// 대부분 기능이 저장소에 저장하거나 읽는 작업이 포함됨
	MemberDao d1;

	MemberService() {
		d1 = new MemberDao();
	}

	// <기능 구현>

	// 추가
	void add(Scanner sc) {
		// 키보드 system.in 표준 입력
		// 이 입력을 받는 스캐너를 여기저기에 만들면
		// 걔가 끝나면 스캐너가 닫히면 다른 곳에서 입력이 안된다.
		// 따라서 어디서 열리고 닫히는지 확인하기 위해서 한 곳에서만 (main) 쓰고
		// 필요할때마다 가져다가 쓰는 형태로 사용하는 것이 좋다.

		String name, num, address;
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("번호 입력 : ");
		num = sc.next();
		System.out.print("주소 입력 : ");
		address = sc.next();

		d1.insert(new Member(name, num, address));
	}

	// 이름으로 검색
	void search(Scanner sc) {
		System.out.print("찾고 싶은 이름을 입력하세요 : ");
		String sName = sc.next();
		for (int i = 0; i < d1.cnt; i++) {
			if (d1.members[i].name.equals(sName)) {
				System.out.println(d1.members[i]);
			}
		}
	}

	// 수정
	void modify(Scanner sc) {
		System.out.print("수정하고 싶은 이름을 입력하세요 : ");
		String mName = sc.next();
		for (int i = 0; i < d1.cnt; i++) {
			if (d1.members[i].name.equals(mName)) {

			}
		}
	}

	// 삭제
	void delete(Scanner sc) {
		System.out.print("삭제하고 싶은 이름을 입력하세요 : ");
		String deleteName = sc.next();
		for (int i = 0; i < d1.cnt; i++) {
			System.out.println(d1.members[i].name + " " + deleteName);

			if (d1.members[i].name.equals(deleteName)) {
				if(i==d1.cnt-1) {
					d1.cnt--;
					return;
				}
				for (int j = i; j < d1.cnt - 1; j++) {
					d1.members[i].name = d1.members[j + 1].name;
					d1.members[i].tel = d1.members[j + 1].tel;
					d1.members[i].address = d1.members[j + 1].address;
					
					System.out.println(i+" "+(j+1));
				}
				d1.cnt--;
				System.out.println(d1.cnt);
				break;
			}
		}
	}

	// 전체 출력
	void getAll() {
		for (int i = 0; i < d1.cnt; i++) {
			System.out.println(d1.members[i]);
		}
	}

}
