package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class EditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService service = new MemberService();
		String id = request.getParameter("id");
		String view = "";

		if (request.getMethod().equals("GET")) {
			MemberVo vo= service.getMember(id);
			request.setAttribute("m", vo);
			view = "/member/myinfo.jsp";
			
		} else { // POST
			response.setCharacterEncoding("euc-kr");
			response.setContentType("text/html; charset=EUC-KR");
			
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");	
			service.editMyInfo(new MemberVo(id, pwd, name, ""));
			view = "/index.jsp";
		}

		return view;
	}
}
