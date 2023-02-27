package langtest;

import java.util.Scanner;

public class StringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("aaa"); // 문자열 끝에 추가
		sb.append("bbb");
		sb.append("ccc");
		System.out.println(sb.toString()); // aaabbbccc
		System.out.println("sb.indexOf(\"ab\") : " + sb.indexOf("ab")); // sb.indexOf("ab") : 2
		System.out.println("sb.indexOf(\"aa\") : " + sb.indexOf("aa")); // sb.indexOf("aa") : 0
		System.out.println("sb.indexOf(\"bc\") : " + sb.indexOf("bc")); // sb.indexOf("bc") : 5
		sb.insert(2, "kkk");
		System.out.println(sb.toString()); // aakkkabbbccc
		sb.delete(3, 5);
		System.out.println(sb); // aakabbbccc
		
		Scanner sc=new Scanner(System.in);
		String txt="";
		StringBuilder sb2=new StringBuilder();
		while(true) {
			System.out.println("멈추려면 stop입력");
			txt=sc.next();
			if(txt.startsWith("stop")) {
				break;
			}
			sb2.append(txt+"\n");

		}
		System.out.println(sb2.toString());
	}

}
