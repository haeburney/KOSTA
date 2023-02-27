package langtest;

public class StringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "abcdefua";
		String b = "def,mango,banana,apple";
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("a.charAt(1) : " + a.charAt(1));
		System.out.println("a.concat(b) : " + a.concat(b)); // 결합
		System.out.println("a.indexOf(\"c\") : " + a.indexOf("c"));
		System.out.println("a.lastIndexOf(\"a\") : " + a.lastIndexOf("a"));
		System.out.println("a.length() : " + a.length());
		System.out.println("a.replace(\"abc\", \"efu\") : " + a.replace("abc", "efu"));
		System.out.println("a.toUpperCase() : " + a.toUpperCase());
		System.out.println("a.substring(2, 6) : " + a.substring(2, 6));

		String[] arr = b.split(",");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
