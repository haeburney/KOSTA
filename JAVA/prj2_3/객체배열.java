package prj2_3;

class Point {
	int x;
	int y;

	void setData(int arg1, int arg2) {
		x = arg1;
		y = arg2;
	}

	void print() {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
}

public class 객체배열 {
	public static void main(String[] agrs) {
		Point[] arr = new Point[3];

		arr[0] = new Point();
		// 위에 코드가 없으면 arr[0]이 비어있어서 오류가 난다.
		// 배열을 생성 => 방 만들어짐. 방만 만들었기 때문에 방 안에는 Point객체가 없고 모두 null로 초기화됨
		// 값을 저장하기 전에 객체를 생성해서 방에 넣어줘야 함

		arr[0].x = 1;
		arr[0].y = 2;
		arr[0].setData(3, 4);
		arr[0].print();

		arr[1] = new Point();
		arr[1].setData(1, 2);
		arr[1].print();

		arr[2] = new Point();
		arr[2].setData(0, 1);
		arr[2].print();

	}
}
