package 입출력스트림;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Copy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("복사하고자 하는 파일명을 입력해주세요 : ");
		String co = sc.next();
		System.out.print("새로운 파일명을 입력해주세요 :");
		String py = sc.next();
		String str = "";

		try {
			FileReader fr = new FileReader("src/입출력스트림/files/" + co + ".txt");
			char[] bur = new char[10];
			int size = 0;
			while ((size = fr.read(bur)) > 0) {
				for (int i = 0; i < bur.length; i++) {
					str += bur[i];
				}
				Arrays.fill(bur, ' ');
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileWriter fw = new FileWriter("src/입출력스트림/files/" + py + ".txt");
			char[] bur = new char[10];
			int size = 0;
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
