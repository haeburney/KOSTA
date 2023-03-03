package 입출력스트림;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		// 파람으로 지정한 경로의 파일이 없어도 File 객체는 정상적으로 생성됨
		File f = new File("src/입출력스트림/files/a.txt");
		System.out.println("파일 존재 : " + f.exists()); // 파일 존재 : true
		System.out.println("파일 경로 : " + f.getAbsolutePath()); // 파일 경로 :
																// C:\Users\KOSTA\eclipse-workspace\prj2_2\src\입출력스트림\files\a.txt
		System.out.println("파일 이름 : " + f.getName()); // 파일 이름 : a.txt
		System.out.println("파일 길이 : " + f.length()); // 파일 길이 : 61
		System.out.println("파일 읽기 가능 : " + f.canRead()); // 파일 읽기 가능 : true
		System.out.println("파일 쓰기 가능 : " + f.canWrite()); // 파일 쓰기 가능 : true
		System.out.println("파일 실행 가능 : " + f.canExecute()); // 파일 실행 가능 : true
		System.out.println("파일이니? : " + f.isFile()); // 파일이니? : true
		System.out.println("숨김 파일이니? : " + f.isHidden()); // 숨김 파일이니? : false

		File f2 = new File("src/입출력스트림/files/xxx1.txt");
		if(!f2.exists()) {
			try {
				f2.createNewFile();
				System.out.println("파일 생성됨");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		f2.delete(); // 파일 삭제 
	}
}
