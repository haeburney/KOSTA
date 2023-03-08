package member;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MemberVo v=new MemberVo();
		MemberDao dao=new MemberDao();
		
		/*
		dao.insert(new MemberVo("aaa1111","1234567","min","min@naver.com"));
		dao.insert(new MemberVo("bbb2222","234567","hyun","hyun@naver.com"));
		dao.insert(new MemberVo("ccc3333","345678","jae","jae@naver.com"));
		*/
		
		//dao.update(new MemberVo("ccc3333","999999","seong"," "));
		
		dao.delete(new MemberVo("ccc3333","","",""));
	}

}
