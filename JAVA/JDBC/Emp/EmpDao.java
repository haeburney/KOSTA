package emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

//DAO: Databases Access object. DB 작업 구현
public class EmpDao {
	private DBConnect dbconn; // 연결할 거 만들기

	public EmpDao() {
		dbconn = DBConnect.getInstance();
	}

	// emp 테이블에 한 줄 추가
	// insert()의 파라미터에 vo에 있는 컬럼들의 정보를 넣기
	public void insert(EmpVo vo) {
		Connection conn = dbconn.conn();
		// 모든 db 작업은 Connection 객체로 실행
		// conn을 하면 hr/hr로 로그인을 한 것이다 
		// 그 다음엔 sql문을 작성하면 된다.

		// String sql = "insert into emp values(1, 'minhyun', 7777, sysdate, 30)";
		// 위처럼 쓰지 않고 밑처럼 쓴다. 밑에 있는 ?는 변수값이 들어갈 위치이다.
		String sql = "insert into emp values(?, ?, ?, sysdate, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// sql문을 실행할 PreparedStatement 객체 생성
			
			pstmt.setInt(1, vo.getEmpId());
			// 매칭 메서드 : set 타입(물음표순서, 매칭할 값)
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getSalary());
			pstmt.setInt(4, vo.getDeptId()); 
			// 물음표만 카운트 
			
			int num = pstmt.executeUpdate();
			// num : DB에서 추가된 줄수. insert는 보통 1
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

	// 사번 기준으로 삭제하기
	public void delete(EmpVo vo) {
		Connection conn = dbconn.conn();
		String sql = "delete from emp where emp_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getEmpId());
			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 삭제되었습니다.");
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

	// empId로 검색
	public EmpVo search(int empId) {
		EmpVo vo = null; 
		// 검색 결과 담을 변수
		Connection conn = dbconn.conn();
		String sql = "select * from emp where emp_id=?";

		try {
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			// executeQuery() : select문 실행 메서드, 검색 결과를 ResultSet에 담아서 반환
			if (rs.next()) {
				// rs.next()는 true와 false를 반환한다.
				// 이동한 줄의 각 컬럼 값을 변수에 옮김
				int empId1 = rs.getInt(1);
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				Date hiredate = rs.getDate(4);
				int depId = rs.getInt(5);
				vo = new EmpVo(empId1, name, salary, hiredate, depId);
			}

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
		return vo;
	}

	// 전체 출력
	public ArrayList<EmpVo> selectAll() {
		ArrayList<EmpVo> list = new ArrayList<>();

		Connection conn = dbconn.conn();
		String sql = "select * from emp";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new EmpVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
			}
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
		return list;
	}

	public ArrayList<EmpVo> selectDeptId(int deptId) {
		ArrayList<EmpVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();

		String sql = "select * from emp where dept_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, deptId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new EmpVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
			}

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
		return list;
	}
}
