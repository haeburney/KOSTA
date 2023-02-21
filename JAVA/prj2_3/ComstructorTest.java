package prj2_3;

class Member2 {
	String name;
	String tel;
	String addr;

	// 생성자 : 객체 생성할 때. 그 외에는 호출할 수 없다.
	// 멤버 변수를 초기화하려는 목적으로 사용한다.
	Member2() {
		System.out.println("생성자");
		name = "hyun";
		tel = "010-1111-1111";
		addr = "대한민국";
	}

	void print() {
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("addr : " + addr);
	}
}

public class ComstructorTest {

	public static void main(String[] args) {
		Member2 m = new Member2();
		m.print();
		// 생성자
		// name : hyun
		// tel : 010-1111-1111
		// addr : 대한민국
		
		m.name = "min";
		m.tel = "010-2222-2222";
		m.addr = "제주도";
		m.print();
		// name : min
		// tel : 010-2222-2222
		// addr : 제주도
	}

}
