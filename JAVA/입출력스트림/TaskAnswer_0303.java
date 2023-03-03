package 입출력스트림;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TaskAnswer_0303 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member("신촌을못가", "111"));
		list.add(new Member("한번을못가", "222"));
		list.add(new Member("혹시 너와", "333"));

		String path = "src/입출력스트림/files/data.dat";
		try {
			// 객체 단위로 출력하는 스트림 생성
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(path));

			// 리스트에서 요소 (Member 객체)를 하나씩 꺼내서
			for (Member m : list) {
				oo.writeObject(m); // 객체단위로 파일 출력
			}
			oo.writeObject(null);
			oo.close();

			// 객체 단위로 읽는 스트림 생성
			ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path));
			Member m = null;
			// readObject() : 객체 하나를 읽는 것
			// 파일에서 객체를 하나씩 읽어서 변수 m에 저장
			while ((m = (Member) oi.readObject()) != null) {
				System.out.println(m);
			}
			oi.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("파일 끝에 도달");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
