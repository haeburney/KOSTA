package addr;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberService s1=new MemberService();

		s1.add(sc);
		s1.add(sc);
		s1.add(sc);
		s1.add(sc);
		//s1.getAll();
		//s1.search(sc);
		s1.delete(sc);
		s1.getAll();

	}
}
