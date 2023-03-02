package 입출력스트림;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderTest {

	public static void main(String[] args) {
		try {
			// FileReader : 파일에서 문자단위로 (2바이트씩) 읽는 스트림
			FileReader fr = new FileReader("src/입출력스트림/files/a.txt");
//			int ch;
//			while ((ch = fr.read()) != -1) {
//				System.out.print((char) ch);
//			}
			char[] bur = new char[10];
			int size = 0;
			while ((size = fr.read(bur)) > 0) {
				System.out.print(bur);
				Arrays.fill(bur, ' ');
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
