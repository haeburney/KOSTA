package langtest;

class Member {
	String id;
	String pwd;

	public Member() {
	}

	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// 왜 object를 쓸까? 어떤 한 타입을 지정할 수는 없다.
		// 다 담을 수 있게 타입을 업캐스팅을 해서 받아올 수 있게.
		// object파라미터로 받아온 멤버가 맞느냐 그럼 다운 캐스팅
		// 현재 객체와 pwd id 가 같으면 true 같지 않으면 false를 반환하도록
		// TODO Auto-generated method stub
		if (obj instanceof Member) {
			Member m = (Member) obj;
			if (this.id.equals(m.id) && this.pwd.equals(m.pwd)) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}

}

public class Equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member("abc", "abc111");
		Member m2 = new Member("abc", "abc111");
		Member m3 = new Member("abc", "abc123");
		Member m4 = m1;

		System.out.println("m1==m2: " + (m1 == m2));
		System.out.println("m1.equals(m2)" + m1.equals(m2));
		System.out.println("m1==m3: " + (m1 == m3));
		System.out.println("m1.equals(m3)" +m1.equals(m3));
		System.out.println("m1==m4: " + (m1 == m4));
		System.out.println("m1.equals(m4)" +m1.equals(m4));
	}

}
