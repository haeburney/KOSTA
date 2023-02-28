package arraylist;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// 키 타입은 int, 값 타입은 String
		// 키는 검색의 기준이기 때문에 중복 허용 안 함

		map.put(1, "mango");
		map.put(2, "min");
		map.put(3, "hyun");

		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("name", "hyun");
		map2.put("tel", "010-1111-1111");
		map2.put("address", "서울");

		System.out.println("name : " + map2.get("name"));
		System.out.println("tel : " + map2.get("tel"));
		System.out.println("address : " + map2.get("address"));

		for (String key : map2.keySet()) { // keySet() : 키 묶음
			System.out.println(key + " : " + map2.get(key)); // 키로 값 추출
		}

		for (String s : map2.values()) { // 값만 추출
			System.out.println(s);
		}
	}

}
