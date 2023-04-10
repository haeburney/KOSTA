package diary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class DiaryDao {
	DBConnect dbconn;

	public DiaryDao() {
		dbconn = DBConnect.getInstance();
	}

	public void insert(DiaryVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into diary values (seq_diary.nextval, ?, sysdate, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPic1());
			pstmt.setString(4, vo.getPic2());
			pstmt.setString(5, vo.getPic3());

			int num = pstmt.executeUpdate();
			System.out.println("dao isnert : " + num + "줄 추가");
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

	public DiaryVo select(int num) {
		Connection conn = dbconn.conn();
		String sql = "select * from diary where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new DiaryVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
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
		return null;
	}

	public ArrayList<DiaryVo> selectAll(String writer) {
		ArrayList<DiaryVo> list = new ArrayList<DiaryVo>();
		Connection conn = dbconn.conn();
		String sql = "select * from diary where writer=? order by num desc";
		try {
			System.out.println("selectAll DiaryDao");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new DiaryVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
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

	public void update(DiaryVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update diary set content=? where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getNum());

			int num = pstmt.executeUpdate();
			System.out.println("dao update : " + num + "줄 수정");
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

	public void delDiary(int num) {
		Connection conn = dbconn.conn();
		String sql = "delete from diary where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			int check = pstmt.executeUpdate();
			System.out.println("dao delete : " + check + "줄 삭제");
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
