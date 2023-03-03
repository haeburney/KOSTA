package Memo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Memo {
	private String path = "myMemo/";

	public void init() {
		File f = new File(path);
		System.out.println("디렉토리 생성함요");
		if (!f.exists()) {
			f.mkdir();
		}
	}

	public void readFile(String path) {
		try {
			FileReader fr = new FileReader(path);
			int ch;
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}
			System.out.println();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void read(String path, Scanner sc) {
		File f = new File(path);
		String[] nFile = f.list();
		for (int i = 0; i < nFile.length; i++) {
			System.out.println(i + "번 : " + nFile[i]);
		}
		System.out.println("읽고 싶은 파일의 번호를 적어주세요!!");
		int num = sc.nextInt();
		readFile(path + nFile[num]);
	}

	public void writeFile(String path) {
		try {
			FileWriter fw = new FileWriter(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void wirte(String path, Scanner sc) {
		// 그럼 여기서.. 다 입력 하는거야?
		System.out.println("입력하고자 하는 파일명을 입력해주세요: ");
	}
}
