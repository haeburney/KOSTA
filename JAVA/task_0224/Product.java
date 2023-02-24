package Task_0224;

public class Product {
	private int num;
	private String name;
	private String url;
	private String id;
	private int price;
	private int amount;

	public Product() {

	}

	public Product(int num, String name, String url, String id, int price, int amount) {
		this.num = num;
		this.name = name;
		this.url = url;
		this.id = id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return num + " / " + name + " / " + url + " / " + id + " / " + price + " / " + amount;
	}
/*
	public static void main(String[] args) {
		Product p1 = new Product();
		p1.setNum(1);
		p1.setName("mango");
		p1.setUrl("www.mango.com");
		p1.setId("aaa");
		p1.setPrice(1000);
		p1.setAmount(10);

		System.out.println("***** p1 *****");
		System.out.println("제품번호 : " + p1.getNum());
		System.out.println("제품명 : " + p1.getName());
		System.out.println("사진경로 : " + p1.getUrl());
		System.out.println("판매자 ID : " + p1.getId());
		System.out.println("가격: " + p1.getPrice());
		System.out.println("제품번호 : " + p1.getAmount() + "\n");
		System.out.println(p1 + "\n\n");

		Product p2 = new Product();
		p2.setNum(2);
		p2.setName("apple");
		p2.setUrl("www.apple.com");
		p2.setId("bbb");
		p2.setPrice(2000);
		p2.setAmount(20);

		System.out.println("***** p2 *****");
		System.out.println("제품번호 : " + p2.getNum());
		System.out.println("제품명 : " + p2.getName());
		System.out.println("사진경로 : " + p2.getUrl());
		System.out.println("판매자 ID : " + p2.getId());
		System.out.println("가격: " + p2.getPrice());
		System.out.println("제품번호 : " + p2.getAmount() + "\n");
		System.out.println(p2 + "\n\n");
	}
	*/
}
