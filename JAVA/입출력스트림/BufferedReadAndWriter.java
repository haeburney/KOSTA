package 입출력스트림;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReadAndWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("src/입출력스트림/files/a.txt");
			BufferedReader br = new BufferedReader(fr);

			int ch;
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}
			br.close();
			fr.close();

			FileWriter fw = new FileWriter("src/입출력스트림/files/b.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 'A'; i <= 'Z'; i++) {
				bw.write(i);
			}
			bw.close();
			fw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
