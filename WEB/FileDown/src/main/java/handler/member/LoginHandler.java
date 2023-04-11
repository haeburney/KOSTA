package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class LoginHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String view = "";

		if(request.getMethod().equals("GET")) { // jsp 보여줘야 해
			view = "/member/login.jsp";

		} else {
			String id = request.getParameter("id");
			String pwd= request.getParameter("pwd");
			
			MemberService service = new MemberService();
			MemberVo vo = service.getMember(id);
			System.out.println(id + ", "+ pwd);
			
			if(vo!=null && vo.getPwd().equals(pwd)) {
				System.out.println("로그인 성공");
				HttpSession session = request.getSession();
				session.setAttribute("loginId", id);
			}
			
			view = "/index.jsp";
		}
		return view;
	}

}
