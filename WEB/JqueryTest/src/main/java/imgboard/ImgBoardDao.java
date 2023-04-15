package imgboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

// 추가
public class ImgBoardDao {
	private DBConnect dbconn;
	public ImgBoardDao() {
		dbconn = DBConnect.getInstance();
	}
	
	// 추가
	public void insert(ImgBoardVo vo) {
		Connection conn = dbconn.conn();

		String sql = "insert into imgboard values (seq_imgboard.nextval, ?, sysdate, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWrite());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPath());
			
			int num=pstmt.executeUpdate();
			System.out.println(num + "줄 추가");
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
	
	// 전체 출력 
	public ArrayList<ImgBoardVo> selectAll(){
		ArrayList<ImgBoardVo> list = new ArrayList<ImgBoardVo>();
		Connection conn = dbconn.conn();
		String sql = "select * from imgboard order by num desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ImgBoardVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6)));
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
	
	// num으로 검색
	public ImgBoardVo select(int num) {
		//ImgBoardVo vo = null;
		
		Connection conn = dbconn.conn();
		String sql = "select * from imgboard where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new ImgBoardVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
	
	// num으로 삭제 
	public void delete(int num) {
		Connection conn = dbconn.conn();
		String sql = "delete from imgboard where num=?";
		try {
			System.out.println("delete dao");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("delete dao1");
			pstmt.setInt(1, num);
			System.out.println("delete dao2");
			int check = pstmt.executeUpdate();
			System.out.println(check + " 줄 삭제 됨");
		
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
	
	// 수정
	public void update(ImgBoardVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update imgboard set title=?, content=? where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			
			int check = pstmt.executeUpdate();
			System.out.println(check + " 줄 수정됨");
		
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