package 예외처리;

public class 예외처리기본 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		String s = null;
		try {
			System.out.println("실행1");
			for (int i = 0; i < arr.length + 1; i++) {
				System.out.println(arr[i]);
			}
			System.out.println("실행2");
			s.charAt(0);
			System.out.println("실행3");
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("무조건 실행되는 finally 블록");
		}
	}
}
