package addr;

// 이런 클래스가 VO이다.
public class Member {
	String name;
	String tel;
	String address;

	public Member() {
	}

	public Member(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		// 상단바 Source > Generate Constructor using fields > Generate
	}

	@Override
	public String toString() {
		return name + " / " + tel + " / " + address;
		// 상단바 > Source > Generate toString()...
		// printData() 대용으로 활용
	}

//	@Override
//	public String toString() {
//		// return super.toString();
//		// 상단바 > Source > Override/Implement Methods...
//		return "abcdefu";
//	}

}
