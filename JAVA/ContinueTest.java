package prj2_2;

public class ContinueTest {
	public static void main(String args[]) {
		int i;
		for(i=1;i<=100;i++) {
			if(i%2==0) {
				continue;
			} else {
				System.out.print(i+"\t");
			}
		}
	}
}
