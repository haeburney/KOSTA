package 입출력스트림;

import java.io.File;

public class DirTest {
	public static void main(String[] args) {
		File dir = new File("src/입출력스트림/files");
		System.out.println("디렉토리 존재 : " + dir.exists()); // 디렉토리 존재 : true
		System.out.println("디렉토리 맞나요 : " + dir.isDirectory()); // 디렉토리 맞나요 : true
		System.out.println("현재 작업 디렉토리 : " + dir.getAbsolutePath()); // 현재 작업 디렉토리 :
																		// C:\Users\KOSTA\eclipse-workspace\prj2_2\src\입출력스트림\files
		System.out.println("파일 목록"); // 파일 목록
		String[] files = dir.list();
		for (String f : files) {
			System.out.print(f + "\t");
		}

//		a.txt	b.txt	c.txt	d.txt	data.dat	e.txt	z.txt

		File dir2 = new File("src/입출력스트림/files/memo");
		if (!dir2.exists()) {
			dir2.mkdir();
			System.out.println("memo 디렉토리 생성됨");
		}

		dir2.delete(); // 디렉토리 삭제
	}
}
