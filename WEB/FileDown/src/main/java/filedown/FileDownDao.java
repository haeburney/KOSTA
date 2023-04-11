package filedown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class FileDownDao {
	DBConnect dbconn;
	
	public FileDownDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(FileDownVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into filedown values(seq_filedown.nextval, ?, sysdate, ?, ?, ?, 0)";
		// cnt 카운트하는거라 초기값은 0이야~
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getFname());
			int num = pstmt.executeUpdate();
			System.out.println(num+"줄 insert");
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
	
	public FileDownVo select(int num) {
		Connection conn = dbconn.conn();
		String sql = "select * from filedown where num=?";
		// cnt 카운트하는거라 초기값은 0이야~
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return new FileDownVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
	
	public ArrayList<FileDownVo> selectAll() {
		ArrayList<FileDownVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from filedown order by num desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new FileDownVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
				
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
