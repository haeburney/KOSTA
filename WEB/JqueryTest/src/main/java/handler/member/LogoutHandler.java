package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;

// url : /member/logout
// 기존 서블릿에서 하던 작업을 여기서 다 해도 된다. 
public class LogoutHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return "/index.jsp";
	}
}