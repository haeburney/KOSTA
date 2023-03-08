package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.DBConnect;

//dao: databases access object. db작업 구현
public class EmpDao {
	// 연결할 거 만들기
	private DBConnect dbconn;

	public EmpDao() {
		dbconn = DBConnect.getInstance();
	}

	// emp 테이블에 한 줄 추가
	// insert()의 파라미터에 vo에 있는 컬럼들의 정보를 넣기
	public void insert(EmpVo vo) {
		Connection conn = dbconn.conn();
		// 모든 db 작업은 Connection 객체로 실행
		// conn을 하면 hrhr로 로그인을 한것 그다음엔이제 sql문을 작성하면돼
		// conn();

		// String sql = "insert into emp values(1, 'minhyun', 7777, sysdate, 30)";
		// 위처럼 쓰지 않고 밑처럼 쓴다.
		// ?는 변수값이 들어갈 위치이다.
		String sql = "insert into emp values(?, ?, ?, sysdate, ?)";

		try {
			// sql문을 실행할 PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 매칭 메서드 : set 타입(물음표순서, 매칭할 값)
			pstmt.setInt(1, vo.getEmpId());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getSalary());
			pstmt.setInt(4, vo.getDeptId()); // 물음표만 카운트
			// db에서 추가된 줄수. insert는 보통 1
			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 추가되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(EmpVo vo) {
		// SQL 사번으로 검색해서 salary와 dept_id를 새 값으로 변경하는 메서드
		Connection conn = dbconn.conn();
		String sql = "update emp set salary=?, dept_id=? where emp_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getSalary());
			pstmt.setInt(2, vo.getDeptId());
			pstmt.setInt(3, vo.getEmpId());

			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 사번 기준으로 삭제하삼
	public void delete(EmpVo vo) {
		Connection conn = dbconn.conn();
		String sql = "delete from emp where emp_id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getEmpId());
			int num = pstmt.executeUpdate();
			System.out.println(num +"줄이 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
