package langtest;

public class ObjArrTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] arr= {1,3.45f,"abcdefu", new ObjArrTest()};
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
