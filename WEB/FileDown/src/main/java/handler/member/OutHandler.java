package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;

public class OutHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		MemberService service = new MemberService();
		service.delMember(id);
		String view = "/member/logout.do";
		System.out.println("id 삭제.." + id);
		
		return view;
	}
}
