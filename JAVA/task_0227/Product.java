package Task_0227;

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
}
