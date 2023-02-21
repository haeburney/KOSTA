package prj2_3;

class Card3 {
	String name;
	String num;
	String pwd;

	void setData(String na, String number, String password) {
		name = na;
		num = number;
		pwd = password;
	}

	void print() {
		System.out.println("name : " + name);
		System.out.println("num : " + num);
		System.out.println("pwd : " + pwd);
	}
}

public class 클래스에메서드추가 {

	public static void main(String[] args) {
		Card3 c1 = new Card3();

		c1.setData("minhyun", "1039-2938-3827", "123456");
		c1.print();

	}

}
