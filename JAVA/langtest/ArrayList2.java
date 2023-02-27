package langtest;

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		// <String>을 한정자 제너릭? 이라고 부른다.
		// <타입> : 제너릭. 타입한정자
		list.add("aaa"); // 마지막 데이터로 추가
		list.add(0, "bbb"); // 지정한 인덱스에 데이터 끼워넣기
		list.add("ccc");
		list.add("ddd");
		list.set(2, "abcd"); // 인덱스 위치의 값을 지우고 추가.

		System.out.println("*** 전체 데이터 ***");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();

		System.out.println("\n*** ddd 찾고 삭제 ***");
		if (list.contains("ddd")) { // contains : 있나 없나 true false
			int idx = list.indexOf("ddd"); // indexOf : 값의 위치를 찾아준다. 없으면 -1 반환
			System.out.println("ddd는 " + idx + "번방에 있음");
			list.remove(idx); // remove(방번호) : 방번호 데이터 한 개 삭제
		}
		// contains equals 재정의 안 하면 제대로 동작을 못한다.
		

		System.out.println("\n*** aaa삭제 ***");
		list.remove("aaa"); // remove(삭제할 데이터): 데이터 찾아서 삭제
		// 삭제할 것이 있으면 삭제하고 true 반환, 삭제할 것이 없으면 false 반환
	
		System.out.println("\n*** 전체 데이터 ***");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();

		System.out.println("\n*** 데이터 비었는지 확인 ***");
		if (list.isEmpty()) {
			System.out.println("비었음");
		} else {
			System.out.println("안 비었음");
		}

		System.out.println("\n*** 데이터 비우기 ***");
		list.clear();
		System.out.println("\n*** 데이터 비었는지 확인 ***");
		if (list.isEmpty()) {
			System.out.println("비었음");
		} else {
			System.out.println("안 비었음");
		}
	}

}
