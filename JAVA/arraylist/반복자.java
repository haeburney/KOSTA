package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class 반복자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		// 반복자를 외부에서 사용
		// 옛날엔 이렇게 많이 썼는데 요즘에는
		// 반복자를 내부 사용

		for (String s : list) {	// for(요소타입 변수명 : 리스트명) {변수로 원하는 작업}
			System.out.println(s);
		}
	}

}
