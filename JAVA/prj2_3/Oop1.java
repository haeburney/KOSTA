package prj2_3;

class Card {
	String name;
	String num;
	String pwd;
}

public class Oop1 {

	public static void main(String[] args) {
		Card c1 = new Card();

		c1.name = "sinhan";
		c1.num = "2132-4352-3423";
		c1.pwd = "123456";

		System.out.println("c1.name : " + c1.name + "  c1.num :  " + c1.num + "  c1.pwd :  " + c1.pwd);

		Card c2 = new Card();

		c2.name = "nonghyub";
		c2.num = "2941-4944-3291";
		c2.pwd = "000000";

		System.out.println("c2name :" + c2.name + "  c2.num : " + c2.num + "  c1.pwd : " + c2.pwd);
	}

}
