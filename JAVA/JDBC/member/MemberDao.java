package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import conn.DBConnect;

public class MemberDao {
	private DBConnect dbconn;
	// MemberVo mv;

	public MemberDao() {
		dbconn = DBConnect.getInstance();
	}

	public void insert(MemberVo m) {
		// ArrayList<MemberVo> list=new ArrayList<>();
		Connection conn = dbconn.conn();

		String sql = "insert into member values(?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());

			// ResultSet rs=pstmt.executeQuery();
			// list.add(new
			// MemberVo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			int num = pstmt.executeUpdate();
			System.out.println(num + " 생성됨");
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
		// return list;
	}

	public void update(MemberVo vo) {
		Connection conn = dbconn.conn();

		String sql = "update member set pwd=?, name=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());

			int num = pstmt.executeUpdate();
			System.out.println(num + " 수정됨");
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

	public void delete(String id) {
		Connection conn = dbconn.conn();

		String sql = "delete from member where id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int num = pstmt.executeUpdate();
			System.out.println(num + " 삭제됨");
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

	// 하나만 출력
	public MemberVo select(String id) {
		Connection conn = dbconn.conn();
		MemberVo vo = null;
		String sql = "select * from member where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			} else {
				System.out.println("입력하신 ID가 존재하지 않습니다.");
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

	public ArrayList<MemberVo> selectAll() {
		ArrayList<MemberVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from member";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				list.add(new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
