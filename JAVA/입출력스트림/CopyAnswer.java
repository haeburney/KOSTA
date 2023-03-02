package 입출력스트림;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class FileCopy {

	// 파일 읽기 메서드. 파람으로 읽을 파일의 경로를 받음
	public String fileRead(String path) {
		// 문자열 조작을 빠르게 처리하는 클래스다.
		// 파일에서 읽은 내용을 저장
		StringBuilder sb = new StringBuilder();
		try {
			// 파일 읽기 스트림 생성
			FileReader fr = new FileReader(path);
			// 문자 100개씩 읽어서 담을 배열
			char[] buf = new char[100];

			while (fr.read(buf) > 0) {
				sb.append(buf); // append(): StringBuilder에 문자열 끝에 추가
				Arrays.fill(buf, ' '); // buf에 남은 쓰레기 값 삭제
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString(); // 파일 전체 내용 반환. toString() : StringBuilder 값을 String으로 변환
	}

	// 파일 복사 메서드. 파람1: 원본 파일 경로, 파람2: 복사 파일 경로
	public void copy(String src, String des) {
		// 원본 파일 내용을 읽어서 변수 txt 저장
		String txt = fileRead(src);
		try {
			// 파일 출력 스트림 생성
			FileWriter fw = new FileWriter(des);
			// txt 전체를 한 번에 출력 스트림으로 출력
			fw.write(txt);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class CopyAnswer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String dir = "src/입출력스트림/files/";
		String end = ".txt";

		System.out.print("원본 파일명 : ");
		String origin = sc.next();
		
		// File : 파일에 대한 정보. 파일이 존재하나, 읽기, 쓰기, 실행 가능 등의 파일에 대한 정보를 갖는다.
		File f = new File(dir + origin + end);
		if (!f.exists()) { // exists() : 해당 파일이 존재하면 true, 아니면 false 반환
			System.out.println("원본 파일이 존재하지 않습니다.");
			return;
		}
		// 복사될 파일명 입력
		System.out.print("복사 파일명 : ");
		String copy = sc.next();
		
		FileCopy fc = new FileCopy();
		
		// 복사 메서드 실행
		fc.copy(dir + origin + end, dir + copy + end);
		
		// 복사 파일의 내용 읽음
		String res = fc.fileRead(dir + copy + end);
		
		// 파일 내용 출력
		System.out.println(res);
	}
}
