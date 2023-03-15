package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import member.MemberVo;

public class MembershipDao {
	DBConnect dbconn;

	public MembershipDao() {
		this.dbconn = DBConnect.getInstance();
	}

	// 멤버십 전체 내용 보기
	public ArrayList<MembershipVo> selectAll() {
		Connection conn = dbconn.conn();
		String sql = "select rate from membership";
		ArrayList<MembershipVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MembershipVo(rs.getString(1), rs.getDouble(2), rs.getInt(3)));
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

	// 특정 회원의 멤버십 추출
	public MembershipVo select(String id) {
		Connection conn = dbconn.conn();
		MembershipVo temp = null;
		String sql = "select * from membership where grade = (select grade from members where id = ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			temp = new MembershipVo(rs.getString(1), rs.getDouble(2), rs.getInt(3));
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
		return temp;
	}

	// 정보 수정
	public void upgrade(MembershipVo vo) {
		Connection conn = dbconn.conn();
		String sql = "upgrade membership set grade = ? , rate = ? , max_point = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGrade());
			pstmt.setDouble(2, vo.getRate());
			pstmt.setInt(3, vo.getMaxPoint());
			pstmt.executeUpdate();
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

	// 정보 입력
	public void insert(MembershipVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into membership values (grade = ?, rate = ?, max_point = ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGrade());
			pstmt.setDouble(2, vo.getRate());
			pstmt.setInt(3, vo.getMaxPoint());
			pstmt.executeUpdate();

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

	// 정보 삭제
	public void delete(String grade) {
		Connection conn = dbconn.conn();
		String sql = "delete membership where grade = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade);
			pstmt.executeUpdate();

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

	public String grade(int point) {
		Connection conn = dbconn.conn();
		String sql = "select grade from membership where max_Point >= ? order by max_Point";
		String grade="" ;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				grade = rs.getString(1);
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
		return grade;
	}
}
