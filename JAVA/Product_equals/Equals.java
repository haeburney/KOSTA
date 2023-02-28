package product2;

class Name {
	String name;

	public Name(String name) {
		this.name = name;
	}
}

public class Equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Name n1 = new Name("abcdefu");
		Name n2 = new Name("abcdefu");

		System.out.println(n1 == n2);		//	 false
		System.out.println(n1.equals(n2));	//	false
	}

}

/*
n1 == n2는 새로운 객체를 생성한 것이므로 주소값이 다르니 false가 나오고
equals()로 비교하면, Object 클래스의 equals()의 내부 코드를 보면 객체 자체를 비교 연산자 == 로 비교한다.
따라서 ==로 비교하는 것과 같은 결과값이 나온다.

*/