package langtest;

import java.util.ArrayList;

public class ArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// arraylist 생성. 타입, 크기 제약이 없다.
		// 크기를 지정해줘도 되지만 더 넣을 수 있음
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add(1);
		list.add(3.45f);
		list.add(23.45);
		
		System.out.println("데이터 개수 : "+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
