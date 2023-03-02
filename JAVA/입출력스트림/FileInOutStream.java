package 입출력스트림;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInOutStream {
	public static void main(String[] args) {
		try {
			// FileInOutStream 객체 생성.
			// 생성자에 읽을 파일의 경로
			// 생성자에 지정한 경로의 파일에서 한 바이트씩 읽을 수 있는 스트림 생성
			FileInputStream fi = new FileInputStream("src/입출력스트림/files/a.txt");
			int ch;
			byte[] b = new byte[10];

			while ((ch = fi.read(b)) != -1) { // -1은 파일의 끝을 나타낸다.
				// End Of File = EOL 파일의 끝을 나타내는 상수인데 이 값이 -1이다.
				for (int i = 0; i < b.length; i++) {
					System.out.print((char) b[i]);
				}
				// System.out.print((char) ch);
			}
			fi.close(); // 스트림 닫음
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
