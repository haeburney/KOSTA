package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DBConnect {
	private static DBConnect dbconn = new DBConnect();
	//@db서버주소 : 리스너번호/sid
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	//xw는 oracle 버전마다 바뀔 수 있으므로 확인해야 한다. 
	private DBConnect() {}
	
	public static DBConnect getInstance() {
		return dbconn;
		// 모든 db작업을 이 conn객체로 실행한다
	}
	
	public Connection conn() {
		try {
			//드라이버 로드
			//Class : 클래스에 대한 정보 
			Class.forName("oracle.jdbc.OracleDriver");
			
			//세션수립 
			//db연결 수립 : 로그인
			return DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
