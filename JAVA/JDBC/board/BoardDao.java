package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class BoardDao {
	private DBConnect dbconn;

	public BoardDao() {
		dbconn = DBConnect.getInstance();
	}

	public void insert(BoardVo bv) {
		Connection conn = dbconn.conn();

		String sql = "insert into board values(seq_board.nextval,?,sysdate,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getWriter());
			pstmt.setString(2, bv.getTitle());
			pstmt.setString(3, bv.getContent());
			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 추가되었다. insert");
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

	// update : 글번호로 찾아서 title, content를 새 값으로 수정
	// delete : 글번호로 찾아서 삭제

	public void update(BoardVo bv) {
		Connection conn = dbconn.conn();

		String sql = "update board set title=?, content=? where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getContent());
			pstmt.setInt(3, bv.getNum());
			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 수정되었다. update");
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

	public void delete(int number) {
		Connection conn = dbconn.conn();

		String sql = "delete board where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 삭제되었다. delete");
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

	// 글번호로 검색
	public BoardVo select(int num) {
		BoardVo vo = null;
		Connection conn = dbconn.conn();

		String sql = "select * from board where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			ResultSet rs = pstmt.executeQuery();
			// rs.next();
			if (rs.next()) {
				int num1 = rs.getInt(1);
				String writer = rs.getString(2);
				Date date = rs.getDate(3);
				String title = rs.getString(4);
				String content = rs.getString(5);
				vo = new BoardVo(num1, writer, date, title, content);
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

	// 작성자로 검색
	public ArrayList<BoardVo> selectId(String writer) {
		ArrayList<BoardVo> list = new ArrayList<>();

		Connection conn = dbconn.conn();

		String sql = "select * from board where writer like ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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

	// 전체 검색
	public ArrayList<BoardVo> selectAll() {
		ArrayList<BoardVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();

		String sql = "select * from board order by num desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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

	// 제목으로 검색
	public ArrayList<BoardVo> selectTitle(String title) {
		ArrayList<BoardVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();

		String sql = "select * from board where title like ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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
