package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;

public class MemberDao {
	private DBConnect dbconn;

	public MemberDao() {
		dbconn = DBConnect.getInstance();
	}

	// 회원가입
	public void insert(MemberVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into members(id, pwd, name, ph_number) values(?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPn());
			int num = pstmt.executeUpdate();
			System.out.println(num + "명의 회원이 추가되었습니다.");
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

	// 회원 정보 수정(비밀번호, 이름, 핸드폰번호 수정)
	public void update(MemberVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update members set pwd = ?, name = ?, ph_number = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPn());
			pstmt.setString(4, vo.getId());
			int num = pstmt.executeUpdate();
			System.out.println((vo.getId() + "님의 정보가 수정되었습니다."));
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
	public void update(String grade) {
		Connection conn = dbconn.conn();
		String sql = "update members set grade = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade);
			pstmt.setString(2, MemberService.LOGINID);
			int num = pstmt.executeUpdate();
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
	
	// 포인트 누적 적립 수정
	public void pointUpdate(MemberVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update members set point = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPoint());
			pstmt.setString(2, vo.getId());
			int num = pstmt.executeUpdate();
			System.out.println(vo.getId() + "님의 Point가 적립되었습니다.");
			System.out.println("현재 누적포인트: " + vo.getPoint());
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

	// id로 회원 삭제
	public void delete(String id) {
		Connection conn = dbconn.conn();
		String sql = "delete from members where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int num = pstmt.executeUpdate();
			System.out.println(id + "님의 계정이 성공적으로 삭제되었습니다.");
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

	// 회원id로 검색 후 회원정보 반환
	public MemberVo select(String id) {
		MemberVo vo = null;
		Connection conn = dbconn.conn();
		String sql = "select * from members where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
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

}
