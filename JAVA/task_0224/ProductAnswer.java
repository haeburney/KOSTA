package Task_0224;

public class ProductAnswer {
	private int num;
	private String name;
	private String path;
	private String seller;
	private int price;
	private int amount;
	
	public ProductAnswer() {
		
	}
	
	public ProductAnswer(int num, String name, String path, String seller, int price, int amount) {
		super();
		this.num = num;
		this.name = name;
		this.path = path;
		this.seller = seller;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
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
	
	
	
}
