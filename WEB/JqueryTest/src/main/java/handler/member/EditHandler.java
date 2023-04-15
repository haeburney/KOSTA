package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class EditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService service = new MemberService();

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		if (request.getMethod().equals("GET")) {
			System.out.println("EditHandler GET");
			String id = request.getParameter("id");
			MemberVo vo = service.getMember(id);
			request.setAttribute("m", vo);
			request.setAttribute("view", "/member/myinfo.jsp");
			
			return "/index.jsp";
		} else { // POST
			System.out.println("EditHandler POST");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			service.editMyInfo(new MemberVo(id, pwd, name, ""));
			
			return "redirect:/member/edit.do?id=" + id;
		}
	}
}
