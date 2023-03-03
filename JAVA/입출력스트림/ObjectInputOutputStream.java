package 입출력스트림;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Member implements Serializable { // 직렬화 처리 끝
	String name;
	String tel;

	public Member() {

	}

	public Member(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member2 [name=" + name + ", tel=" + tel + "]";
	}
}

public class ObjectInputOutputStream {
	public static void main(String[] args) {
		Member m1 = new Member("aaa", "111");
		Member m2 = null; // 파일에서 읽은 객체 저장할 변수 
		String path = "src/입출력스트림/files/data.dat";

		try {
			// 파일에 바이트 단위로 쓰는 스트림 생성
			FileOutputStream fo = new FileOutputStream(path);
			// 위 기본 스트림에 객체 단위로 쓰는 보조 스트림을 생성해서 연결
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			// writeObject() 객체 한 개 출력
			oo.writeObject(m1);
			// 스트림 닫음
			oo.close();
			fo.close();

			// 파일에서 바이트 단위로 읽는 기본 스트림을 생성
			FileInputStream fi = new FileInputStream(path);
			// 객체 단위로 읽는 보조 스트림을 생성해서 위 기본스트림(fi)와 연결
			ObjectInputStream oi = new ObjectInputStream(fi);
			// readObject() : 객체 한 개를 읽어서 Object 타입으로 변환. 다운캐스팅 필요
			// 어떤 객체를 담을 지 모르기 때문에 모든 것을 다 포함할 수 있는 상위에 있는 Object롤 받는 것이다.
			m2 = (Member) oi.readObject();
			System.out.println(m2);
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
