package langtest;

class MyClone implements Cloneable {
	int a;
	int b;

	public MyClone() {
	}

	public MyClone(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
		// 이 안은 바꿀 필요없고 그냥 사용하면 된다.
	}

	@Override
	public String toString() {
		return "MyClone [a=" + a + ", b=" + b + "]";
	}
}

public class CloneTest {
	public static void main(String[] args) {
		MyClone m1 = new MyClone(1, 2);
		MyClone m2 = new MyClone();
		m2.a = m1.a;
		m2.b = m1.b;

		System.out.println(m1 + " / 참조값 : " + m1.hashCode());
		System.out.println(m2 + " / 참조값 : " + m2.hashCode() + "\n");

		// clone()으로 객체 복사
		try {
			MyClone m3 = (MyClone) m1.clone();
			System.out.println(m1 + " / 참조값 : " + m1.hashCode());
			System.out.println(m3 + " / 참조값 : " + m3.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
