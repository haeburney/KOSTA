package prj2_3;

public class Book {
	
	private String name;
	private String author;
	private String pu;
	private int price;
	
	public Book(){
	}
	
	public Book(String name, String author, String pu, int price) {
		super();
		this.name = name;
		this.author = author;
		this.pu = pu;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPu() {
		return pu;
	}

	public void setPu(String pu) {
		this.pu = pu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", pu=" + pu + ", price=" + price + "]";
	}

	public static void main(String[] args) {
		Book b=new Book();
		
		b.setName("꿈 백화점");
		b.setAuthor("김이박");
		b.setPu("회사");
		b.setPrice(15000);
		
		System.out.println(b.getName());
		System.out.println(b.getAuthor());
		System.out.println(b.getPu());
		System.out.println(b.getPrice());

		//Book[] b1=new Book[5];
		Book[] b1= {new Book("a","b","c",1),new Book("d","e","f",2),new Book("g","h","i",3)};
		
		
		for(int i=0;i<b1.length;i++) {
			System.out.println(b1[i]);
		}
	}

}
