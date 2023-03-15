package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class MenuDao {
	private DBConnect dbconn;
	
	public MenuDao () {
		dbconn = DBConnect.getInstance();
	}

	// 전체 select
	public ArrayList<MenuVo> selectAll () {
		ArrayList<MenuVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from Menu order by num desc";
		MenuVo vo = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MenuVo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
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
	
	// 음료 select
	public ArrayList<MenuVo> selectBev() {
		ArrayList<MenuVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from Menu where category is 음료 order by num desc";
		MenuVo vo = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MenuVo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
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
	
	// 푸드 select
	public ArrayList<MenuVo> selectFood() {
		ArrayList<MenuVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from Menu where category is 푸드 order by num desc";
		MenuVo vo = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MenuVo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
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
	
	// select 메뉴 번호로 
	public MenuVo selectByNum (int n) {
		Connection conn = dbconn.conn();
		MenuVo vo = null;
		String sql = "select * from Menu where num = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, n);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					vo = new MenuVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
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
	
	// select price ^^...... 할인율 조인해서.. 곱해서.. ㅅㄱ
	
	
	// insert
	public void insert(MenuVo vo) {
		if(vo.getCategory().equals("푸드")) {
			vo.setHc(null);
		}
		Connection conn = dbconn.conn();
		String sql = "insert into board values (seq_Menu.nextval, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getMenuName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getExpl());
			pstmt.setString(5, vo.getHc());

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
	
	// update - 메뉴번호 받아서 가격, 설명 수정 
	public void update(MenuVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update menu set price = ?, expl = ? where num = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getExpl());
			pstmt.setInt(3, vo.getNum());
			
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
	
	// delete 
	public void delete (int n) {
		Connection conn = dbconn.conn();
		String sql = "delete menu where num = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n);
			
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
}
