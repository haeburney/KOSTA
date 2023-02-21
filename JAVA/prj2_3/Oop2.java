package prj2_3;

class Student1 {
	String name;
	int num, kor, eng, math, total;
	float avg;
}

class Student2 {
	String name;
	int[] score = new int[5];
	float avg;
}

public class Oop2 {
	public static void main(String[] args) {
		Student1 st1 = new Student1();
		st1.name = "minhyun";
		st1.num = 1;
		st1.kor = 21;
		st1.eng = 54;
		st1.math = 43;
		st1.total = st1.kor + st1.eng + st1.math;
		st1.avg = (float) st1.total / 3;

		System.out.println("st1.name : " + st1.name);
		System.out.println("st1.num : " + st1.num);
		System.out.println("st1.kor : " + st1.kor);
		System.out.println("st1.eng : " + st1.eng);
		System.out.println("st1.math : " + st1.math);
		System.out.println("st1.total : " + st1.total);
		System.out.println("st1.ave : " + st1.avg + "\n");

		Student2 st2 = new Student2();

		st2.name = "whangdo";
		st2.score[0] = 1;
		st2.score[1] = 64;
		st2.score[2] = 25;
		st2.score[3] = 64;

		for (int i = 1; i < 4; i++) {
			st2.score[4] += st2.score[i];
		}
		st2.avg = (float) st2.score[4] / 3;

		System.out.println("st2.name : " + st2.name);

		for (int i = 0; i < st2.score.length; i++) {
			System.out.println("st2.score[" + i + "] : " + st2.score[i]);
		}

		System.out.println("st2.avg : " + st2.avg);
	}
}
