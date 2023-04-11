package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class JoinHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 여기있는 String이 뭐야? 요청 처리에 사용할 req, res를 파람으로 받고, 결과 페이지 경로를 리턴값으로 반환하는 메소드이다.
		// TODO Auto-generated method stub
		
		String view = "";
		
		// get이냐 post냐 구별을 해야해!
		if(request.getMethod().equals("GET")) {
			//view = "/member/join2.jsp";
			view = "/member/join.jsp";
			System.out.println("JoinHandler : join.jsp 보여줄게");
			
		} else {
			response.setCharacterEncoding("euc-kr");
			response.setContentType("text/html; charset=EUC-KR");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberService service = new MemberService();
			service.join(new MemberVo(id, pwd, name, email));
			
			view = "redirect:/index.jsp";
			// redirect: 자동으로 redirect가 되는건 아니다.
			// 내가 알아보려고 붙여준 이름이다. 기능이 아님!!
			System.out.println("JoinHandler : 가입시켜줄게");
		}
		return view;
	}
}
