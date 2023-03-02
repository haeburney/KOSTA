package 입출력스트림;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		try {
			// 1바이트씩 파일에 출력하는 스트림
			// 출력 스트림의 대상인 파일을
			// 읽기용은 파일이 있어야만 읽을 수 있고 쓰기용 파일은 있으면 그 파일을 쓰고(덮어쓰기) 없으면 만들어서 씀
			FileOutputStream fo = new FileOutputStream("src/입출력스트림/files/c.txt");
			byte[] buf = "hello my universe.".getBytes();
			byte[] buf2 = { 'h', 'e', 'l' };
			// buf와 buf2는 동일한 기능 한글자씩 잘라쓰기 귀찮으니 getBytes 사용.
			// getBytes(): 문자열을 바이트배열로 변환
//			for (int i = 0; i < buf.length; i++) {
//				fo.write(buf[i]);
//			}
			fo.write(buf);
			fo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
