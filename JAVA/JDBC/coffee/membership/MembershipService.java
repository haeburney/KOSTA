package membership;

import java.util.ArrayList;

import member.MemberDao;
import member.MemberService;
import member.MemberVo;
import menu.MenuVo;

public class MembershipService {
	MembershipDao membershipDao;
	MemberDao memberDao;

	public MembershipService() {
		this.membershipDao = new MembershipDao();
		this.memberDao = new MemberDao();
	}

	// 멤버십 정보 보여주기
	public void selectAll() {
		System.out.println("멤버십 정보 입니다.");
		ArrayList<MembershipVo> list = membershipDao.selectAll();
		for (MembershipVo temp : list) {
			System.out.println(temp);
		}
	}

	// 회원의 할인율 반환
	public double selectRate() {
		MembershipVo membershipVo = membershipDao.select(MemberService.LOGINID);

		return membershipVo.getRate();
	}
	

	// 회원의 멤버십 보여주기
	public MembershipVo select(String id) {
		MembershipVo vo = membershipDao.select(id);
		return vo;
	}
}
