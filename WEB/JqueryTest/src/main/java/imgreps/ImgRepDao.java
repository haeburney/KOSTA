package imgreps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import imgboard.ImgBoardVo;

public class ImgRepDao {
	private DBConnect dbconn;
	
	public ImgRepDao() {
		dbconn = DBConnect.getInstance();
	}

	// 추가
	public void insert(ImgRepVo vo) {
		Connection conn = dbconn.conn();

		String sql = "insert into img_reps values(seq_img_reps.nextval, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());

			int num = pstmt.executeUpdate();
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
	
	public ArrayList<ImgRepVo> selectByPnum(int pnum){
		ArrayList<ImgRepVo> list = new ArrayList<ImgRepVo>();
		Connection conn = dbconn.conn();
		String sql = "select * from img_reps where pnum=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ImgRepVo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
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
