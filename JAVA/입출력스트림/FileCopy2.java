package 입출력스트림;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src="src/입출력스트림/files/a.txt";
		String des="src/입출력스트림/files/z.txt";
		
		try {
			FileReader fr=new FileReader(src);
			FileWriter fw=new FileWriter(des);
			int ch;
			while((ch=fr.read())!=-1) {
				fw.write(ch);
			}
			fw.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
