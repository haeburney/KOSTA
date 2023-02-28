package product2;

class Name2 {
	String name2;

	public Name2(String name2) {
		this.name2 = name2;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.name2 == ((Name2) obj).name2;
	}

}

public class Equals2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Name2 n1 = new Name2("min hyun");
		Name2 n2 = new Name2("min hyun");

		System.out.println(n1 == n2);
		System.out.println(n1.equals(n2));
	}

}
