package oop2;

class Point {
	int x;
	int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

abstract class Shape {
	Point[] points; // 포함관계

	public abstract void draw(); // 하위 클래스에서 각 클래스에 적합하게 구현하라고
}

class Circle extends Shape {
	int r;

	public Circle() {
		points = new Point[1];
		points[0] = new Point(5, 5); // 중심점
		r = 10; // 반지름
	}

	public Circle(Point[] arr, int r) {
		points = arr;
		this.r = r;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("원을 그림");
		System.out.println("중심점 : " + points[0]);
		System.out.println("반지름 : " + r);
	}
}

class Triangle extends Shape {

	public Triangle() {
		points = new Point[3];
		points[0] = new Point(1, 1);
		points[1] = new Point(0, 1);
		points[2] = new Point(1, 0);
	}

	public Triangle(Point[] arr) {
		points = arr;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형을 그림");
		System.out.println("세 점의 좌표 : ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
	}

}

class Quadrangle extends Shape {
	public Quadrangle() {
		points = new Point[2];
		points[0] = new Point(1, 1);
		points[1] = new Point(0, 0);
	}

	public Quadrangle(Point arr[]) {
		points = arr;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그림");
		System.out.println("두 점의 좌표");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
	}
}

public class ShapeMain {

	public static void main(String[] args) {
		// 그림판 프로그램?

		/*
		 * Circle c1 = new Circle(); c1.draw();
		 * 
		 * Point[] arr = new Point[1]; arr[0] = new Point(0, 0); Circle c2 = new
		 * Circle(arr, 5); c2.draw();
		 * 
		 * Shape c3 = new Circle(); c1.draw();
		 * 
		 * Point[] arr1 = new Point[1]; arr1[0] = new Point(3, 3); Shape c4 = new
		 * Circle(arr1, 7); c4.draw();
		 * 
		 * // Point[] arr = new Point[] {new Point(6, 9)}; 방은 1개 Shape c5 = new
		 * Circle(new Point[] { new Point(3, 3) }, 7); c5.draw();
		 * 
		 * Shape c6 = new Triangle(new Point[] { new Point(2, 2), new Point(2, 0), new
		 * Point(0, 2) }); c6.draw();
		 * 
		 * Shape c7 = new Triangle(); c7.draw();
		 * 
		 * Shape c8 = new Quadrangle(); c8.draw();
		 * 
		 * Shape c9 = new Quadrangle(new Point[] { new Point(3, 0), new Point(0, 3) });
		 * c9.draw();
		 */

		Shape[] array = { new Circle(), new Triangle(), new Quadrangle(),
				new Circle(new Point[] { new Point(10, 10) }, 5),
				new Triangle(new Point[] { new Point(10, 10), new Point(20, 20), new Point(30, 30) }),
				new Quadrangle(new Point[] { new Point(20, 20), new Point(30, 30) }) };

		for(int i=0;i<array.length;i++) {
			array[i].draw();
			System.out.println();
		}
	}

}
