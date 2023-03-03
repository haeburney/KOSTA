package 입출력스트림;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
	public static void main(String[] args) {
		try {
			RandomAccessFile acc = new RandomAccessFile("src/입출력스트림/files/b.txt", "r");
			byte[] buf = new byte[10];
			int size = acc.read(buf); // read(byte[]) : 배열 크기만큼 읽음
			System.out.println(new String(buf)); // abcdefghi
			System.out.println("읽은 크기 : " + size); // 읽은 크기 : 10
			System.out.println("현재 위치 : " + acc.getFilePointer()); // 현재 위치 : 10
			System.out.println("현재 위치의 문자 : " + (char) acc.read()); // 현재 위치의 문자 : k
			System.out.println("현재 위치 : " + acc.getFilePointer());// 현재 위치 : 11
			acc.seek(acc.getFilePointer() + 5);
			System.out.println("현재 위치 : " + acc.getFilePointer());// 현재 위치 : 16
			System.out.println("현재 위치의 문자 : " + (char) acc.read());// 현재 위치의 문자 : q
			acc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
