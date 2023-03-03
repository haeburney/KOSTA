package 입출력스트림;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Member3 implements Serializable {
	String name;
	String tel;

	public Member3() {

	}

	public Member3(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member3 [name=" + name + ", tel=" + tel + "]";
	}
}

public class Task_0303 {
	public static void main(String[] args) {
		ArrayList<Member3> list = new ArrayList<Member3>();

		list.add(new Member3("aaa", "111"));
		list.add(new Member3("bbb", "222"));
		list.add(new Member3("ccc", "333"));

		String path = "src/입출력스트림/files/data.dat";
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(list);
			oo.close();
			fo.close();

			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream oi = new ObjectInputStream(fi);
			list = (ArrayList<Member3>) oi.readObject();
			System.out.println(list);
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
