package payment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import conn.DBConnect;

public class PaymentDao {
	private DBConnect dbconn;

	public PaymentDao() {
		dbconn = DBConnect.getInstance();
	}

	// 구매함수가 돌아가면 insert가 되게
	public void insert(PaymentVo p) {
		Connection conn = dbconn.conn();

		String sql = "insert into payment values(Sysdate,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getMenuName());
			ps.setInt(2, p.getCount());
			ps.setInt(3, p.getPrice());
			ps.setString(4, p.getId());
			int num = ps.executeUpdate();
			System.out.println(num + "줄 결제내역 insert");
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

	// 전체출력해서 정보 보이게 service의 selectAll()
	public ArrayList<PaymentVo> allPrint() {
		ArrayList<PaymentVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();

		String sql = "select * from payment";
		try {
			PreparedStatement ps = conn.prepareStatement("sql");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new PaymentVo(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
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

	// 메뉴별로 정보 보이게 합계 금액 service의 selectMenuName
	public PaymentVo menuPrint(String name) {
		PaymentVo vo = null;
		Connection conn = dbconn.conn();
		String sql = "select * from (select menuName, sum(count), sum(price) from payment group by menuName) where menuName=?";

		/*
		 * day menuName count price id
		 */
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ps.setString(1, name);
			int num = ps.executeUpdate();
			System.out.println(num + "줄 menuPrint");

			if (rs.next()) {
				vo = new PaymentVo(null, rs.getString(1), rs.getInt(2), rs.getInt(3), null);
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

	// 년도별 한 달씩 금액 보이게
	public ArrayList<PaymentVo> monthPrint() {
		ArrayList<PaymentVo> list = new ArrayList();
		Connection conn = dbconn.conn();
		String sql = "select substr(day, 1, 5) as 월별, sum(count), sum(price) from payment group by substr(day, 1, 5) order by 월별";
		// String sql = "select to_char(day, 'yyyy-mm') as 월별, sum(count) as 총수,
		// sum(price) as 총금액 from payment group by to_char(day, 'yyyy-mm') order by
		// to_char(day, 'yyyy-mm')";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new PaymentVo(null, rs.getString(1), rs.getInt(2), rs.getInt(3), null));
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

	// 년도별 금액 보이게
	public ArrayList<PaymentVo> yearPrint() {
		ArrayList<PaymentVo> list = new ArrayList();
		Connection conn = dbconn.conn();
		String sql = "select substr(day, 1, 2) as 년도별, sum(count), sum(price) from payment group by substr(day, 1, 2) order by 년도별";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new PaymentVo(null, rs.getString(1), rs.getInt(2), rs.getInt(3), null));
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

	// day1 : 검색할 처음 날짜 day2 : 검색할 후반 날짜
	public PaymentVo selectPrice(String day1, String day2) {
		PaymentVo vo = null;
		Connection conn = dbconn.conn();
		String sql = "select sum(count), sum(salary) from payment where to_char(day, 'yyyy-mm') between ? and ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, day1);
			ps.setString(2, day2);
			int num = ps.executeUpdate();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vo = new PaymentVo(null, null, rs.getInt(1), rs.getInt(2), null);
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

	public PaymentVo selectId(String id) {
		PaymentVo vo = null;
		Connection conn = dbconn.conn();
		String sql = "select * from payment where id like ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int num = ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vo = new PaymentVo(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
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
