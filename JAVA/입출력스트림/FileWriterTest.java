package 입출력스트림;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) {
		try {
			// 파일에 문자 단위로 출력하는 스트림

			FileWriter fw = new FileWriter("src/입출력스트림/files/d.txt");
			String str = "hello java FileWriter";
			for (int i = 0; i < str.length(); i++) {
				fw.write(str.charAt(i));
			}
			fw.write("\n");
			 str = "hello My Universe";
			fw.write(str); // String 값 하나 출력
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
