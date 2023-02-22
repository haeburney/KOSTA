package homework;

import java.util.Scanner;

public class WritingService {
	private int count;
	private Member[] member;

	WritingService() {
		member = new Member[30];
	}

	public void input(Scanner sc) {
		String id;
		String pwd;
		String name;
		String email;

		System.out.println("* * * * * " + (count + 1) + "번째 사람 입력 * * * * *");
		System.out.print("id 입력 : ");
		id = sc.next();
		System.out.print("pwd 입력 : ");
		pwd = sc.next();
		System.out.print("name 입력 : ");
		name = sc.next();
		System.out.print("email 입력 : ");
		email = sc.next();

		// member[count] = new Member(id, pwd, name, email);
		// count++;
		insert(new Member(id, pwd, name, email));
	}

	public void search(Scanner sc) {
		System.out.println("* * * * * 검색하고자 하는 id를 입력해주세요 * * * * *");
		String s = sc.next();

		for (int i = 0; i < count; i++) {
			if (member[i].getId().equals(s)) {
				System.out.println(member[i]);
				System.out.println(i + "번째 방에 있습니다.");
				return;
			}
		}
		System.out.println("-1");
	}

	public void delete(Scanner sc) {
		System.out.println("* * * * * 삭제하고자 하는 id를 입력해주세요 * * * * *");
		String d = sc.next();

		for (int i = 0; i < count; i++) {
			if (member[i].getId().equals(d) && i < count - 1) {
				for (int j = i; j < count - 1; j++) {
					member[j].setId(member[j + 1].getId());
					member[j].setPwd(member[j + 1].getPwd());
					member[j].setName(member[j + 1].getName());
					member[j].setEmail(member[j + 1].getEmail());
					System.out.println("");
				}
				count--;
				return;
			} else if (member[i].getId().equals(d)) {
				member[i].setId(null);
				member[i].setPwd(null);
				member[i].setName(null);
				member[i].setEmail(null);
				count--;
				return;
			}
		}
		System.out.println("-1. 삭제하고자 하는 id를 찾을 수 없습니다.");

	}

	public void modify(Scanner sc) {
		System.out.println("* * * * * 수정하고자 하는 id를 입력해주세요 * * * * *");
		String m = sc.next();
		
		for(int i=0;i<count;i++) {
			if(member[i].getId().equals(m)) {
				System.out.print("id 재입력 : ");
				m=sc.next();
				member[i].setId(m);
				System.out.print("pwd 재입력 : ");
				m=sc.next();
				member[i].setPwd(m);
				System.out.print("name 재입력 : ");
				m=sc.next();
				member[i].setName(m);
				System.out.print("email 재입력 : ");
				m=sc.next();
				member[i].setEmail(m);
			}
		}
		System.out.println("* * * * * 수정이 완료되었습니다. * * * * *");
	}

	public void insert(Member m) {
		if (count >= member.length) {
			System.out.println("더 이상 넣을 수 없습니다.");
			return;
		}
		member[count] = m;
		count++;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(member[i]);
		}
		System.out.println("count의 값 : " + count);
	}
}
