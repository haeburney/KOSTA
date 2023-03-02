package 입출력스트림;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamTest2 {
	public static void main(String[] args) {
		try {
			// 사용할 inputstream 생성
			FileInputStream fi = new FileInputStream("src/입출력스트림/files/a.txt");
			// 읽은 값 담을 배열
			byte buf[] = new byte[10];
			int size = 0; // read(byte[]) 반환값 담을 변수, 방금 읽은 바이트 수 반환
			while ((size = fi.read(buf)) > 0) {
				// fi를 buf에 저장해서 사이즈에 크기를 전달?
				// System.out.println("fi : "+fi.read(buf));
				System.out.print(new String(buf));
				Arrays.fill(buf, (byte)' ');
			}
			fi.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}