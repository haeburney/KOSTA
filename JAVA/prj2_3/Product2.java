package prj2_3;

// 번호 입력받는 product
public class Product2 {
	// 멤버 변수는 모두 private
	// 앞으로 멤버 변수는 private으로 해야 한다.

	private int num;
	private String name;
	private int price;
	private int amount;

	
	public Product2() {
	}

	public Product2(int num, String name, int price, int amount) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Product2 [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}


	public static void main(String[] args) {
		Product2 p = new Product2();
		
		p.setNum(1);
		p.setName("mango");
		p.setPrice(1000);
		p.setAmount(10);
		System.out.println(p.getNum());
		System.out.println(p.getName());
		System.out.println(p.getPrice());
		System.out.println(p.getAmount());
		
		Product2 p2=new Product2(2,"minhyun",70000,30);
		System.out.println(p2);
		System.out.println(p);
	}

}
