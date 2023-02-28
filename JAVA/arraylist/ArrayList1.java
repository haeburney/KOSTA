package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");

		// size(): 데이터 개수
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		ArrayList<String> list2 = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("문자열 입력. 멈추려면 /stop입력");
			String txt = sc.next();
			if (txt.startsWith("/stop")) {
				break;// while문 끝냄
			}
			list2.add(txt);
		}

		// list2 전체 데이터
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}

		// 검색. equals()로 비교
		// 검색할 단어 입력받음
		// if(단어.equals(list2.get(i)))
		System.out.println("검색할 단어:");
		String txt = sc.next();
		int i;
		for (i = 0; i < list2.size(); i++) {
			if (txt.equals(list2.get(i))) {
				System.out.println(i + "번째 방에 있음");
				break;
			}
		}

		if (i == list2.size()) {
			System.out.println("못찾았음");
		}

		// 객체의 equals()가 재정의되었다면 indexof()으로 검색가능
		int idx = list2.indexOf(txt);// indexof(). 객체의 equals()메서드로 동일한 객체를 찾아서 위치 반환
		if (idx < 0) {
			System.out.println("못찾았음");
		} else {
			System.out.println(idx + "번째 방에 있음");
		}
	}

}
