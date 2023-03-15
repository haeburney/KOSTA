package membership;

import java.util.ArrayList;

import member.MemberDao;
import member.MemberService;
import member.MemberVo;

public class MembershipService {
	MembershipDao membershipDao;
	MemberDao memberDao;

	public MembershipService() {
		this.membershipDao = new MembershipDao();
		this.memberDao = new MemberDao();
	}

	public void selectAll() {
		System.out.println("멤버십 정보 입니다.");
		ArrayList<MembershipVo> list = membershipDao.selectAll();
		for (MembershipVo temp : list) {
			System.out.println(temp);
		}
	}

	public double selectRate() {
		MemberVo memberVo = memberDao.select(MemberService.LOGINID);
		MembershipVo membershipVo = membershipDao.select(memberVo.getGrade());

		return membershipVo.getRate();
	}

	public MembershipVo select(String id) {
		MembershipVo vo = membershipDao.select(id);
		return vo;
	}
}
