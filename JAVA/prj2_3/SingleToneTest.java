package prj2_3;

import java.util.Date;
import java.util.Calendar;



class SingleTone {
	private static SingleTone s = new SingleTone();
	private int a;

	private SingleTone() {
	}

	public static SingleTone getInstance() {
		return s;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}

public class SingleToneTest {
	public static void main(String[] args) {
		SingleTone s = SingleTone.getInstance();
		s.setA(50);
		System.out.println(s.getA());

		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		System.out.print((d.getYear() + 1900) + "년 ");
		System.out.print((d.getMonth() + 1) + "월 ");
		System.out.println(d.getDay() + "일");

	}
}
