package prj2_3;

class Card1{
	String name;
	String num;
	String pwd;
	String accName;
	String accNum;
	String accPwd;
	int accMoney;
}

class Card2{
	String name;
	String num;
	String pwd;
	Account acc=new Account();
}

class Account{
	String name;
	String num;
	String pwd;
	int money;
}

public class 클래스정의및객체생성 {

	public static void main(String[] args) {
		Card2 c = new Card2();
		c.name = "신한";
		c.num = "1593-2938-4837";
		c.pwd = "111111";
		c.acc.name = "카카오";
		c.acc.num = "3958-3948-3481";
		c.acc.pwd = "000000";
		c.acc.money = 100000000;

		System.out.println("c.name : " + c.name);
		System.out.println("c.num : " + c.num);
		System.out.println("c.pwd : " + c.pwd);
		System.out.println("c.acc.name : " + c.acc.name);
		System.out.println("c.acc.num : " + c.acc.num);
		System.out.println("c.acc.pwd : " + c.acc.pwd);
		System.out.println("c.acc.money : " + c.acc.money);

	}

}
