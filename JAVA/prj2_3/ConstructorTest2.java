package prj2_3;

class Member3 {
	String name;
	String tel;
	String addr;

	Member3() {
	}

	Member3(String n) {
		name = n;
	}

	Member3(String name, String tel, String addr) { // 메서드 오버로딩
		System.out.println("생성자");
		// name = name; → 자기한테 값을 넣고 있는 상황
		// tel = tel;
		// addr = addr;

		// this.name : 멤버변수
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	void print() {
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("addr : " + addr);
	}
}

public class ConstructorTest2 {

	public static void main(String[] args) {

		Member3 m = new Member3("hyun", "010-1111-1111", "대한민국");
		m.name = "min";
		m.tel = "010-3333-4444";
		m.addr = "한국";
		m.print();

		Member3 m2 = new Member3();
		m2.print();
	}

}
