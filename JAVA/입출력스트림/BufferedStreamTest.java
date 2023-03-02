package 입출력스트림;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamTest {

	public static void main(String[] args) {
		try {
			// 기본 스트림
			FileInputStream fi = new FileInputStream("src/입출력스트림/files/a.txt");
			// 보조 스트림
			BufferedInputStream bi = new BufferedInputStream(fi);// 보조 스트림 생성자에 연결할 기본 스트림 객체 전달

			int ch;
			while ((ch = bi.read()) != -1) {
				System.out.print((char) ch);
			}
			bi.close(); // 보조 스트림 닫음
			fi.close(); // 기본 스트림 닫음

			// 기본 스트림 생성
			FileOutputStream fo = new FileOutputStream("src/입출력스트림/files/b.txt");
			// 보조 스트림 생성
			BufferedOutputStream bo = new BufferedOutputStream(fo);

			for (int i = 'a'; i <= 'u'; i++) {
				bo.write(i);
			}
			bo.close();
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
