package Memo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Memo {
	private String path = "hyunMemo/";

	public void init(String dname) {
		File f = new File(dname);
		if (!f.exists()) {
			System.out.println("없어서 만듦! ㅎ");
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

	public void read(String dname, Scanner sc) {
		File dir = new File(dname);
		String[] files = dir.list();

		System.out.println("목록");
		try {
			for (int i = 0; i < files.length; i++) {
				System.out.println(i + "번 : " + files[i]);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		System.out.println("읽고 싶은 파일 번호를 입력해주세요 (숫자만 입력)");
		int num = sc.nextInt();
		readFile(path + files[num]);
	}

	// 쓰기!! 이어쓰기 할건지 안할건지
	public void writeFile(String path, Scanner sc, boolean flag) {
		try {
			FileWriter fw = new FileWriter(path, flag);
			System.out.println("파일 내용을 입력하시오 : \"/stop\"이라고 입력시 쓰기 종료.");
			String txt = "";
			while (true) {
				txt = sc.nextLine();
				if (txt.startsWith("/stop")) {
					System.out.println("쓰기 종료");
					break;
				}
				fw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void write(String dname, Scanner sc) {
		File dir = new File(dname);
		String[] fnames = dir.list();
		int input = 0;
		boolean againInput = false, flag = true;
		String f = "";

		while (flag) {
			System.out.println("쓰고자 하는 파일명을 입력해주세요 : ");
			f = sc.next();
			for (int i = 0; i < fnames.length; i++) {

				if (fnames[i].equals(f)) {
					System.out.println("파일이 이미 존재해요. 이어쓰기(1번) 새로쓰기(2)번 파일명 다시입력(3)번");
					input = sc.nextInt();

					switch (input) {
					case 2:
						againInput = true;
						flag = false;
						break;
					case 3:
						break;
					default:
						flag = false;
						break;
					}

				}
			}
		}

		System.out.println(dname + f);
		writeFile(dname + f, sc, flag);
	}

	public void deleteRead(String dname, Scanner sc) {
		File dir = new File(dname);
		String[] files = dir.list();

		System.out.println("목록");
		try {
			for (int i = 0; i < files.length; i++) {
				System.out.println(i + "번 : " + files[i]);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		System.out.println("지우고 싶은 파일 번호를 입력해주세요 (숫자만 입력)");
		int num = sc.nextInt();
		delete(path + files[num]);
	}

	public void delete(String dname) {
		File f=new File(dname);
		if(f.delete()) {
			System.out.println("삭제 완");
		} else {
			System.out.println("엄훠 삭제 실패 T.T");
		}
	}

}
