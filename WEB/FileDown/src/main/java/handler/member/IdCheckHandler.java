package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class IdCheckHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view="";
		String id = request.getParameter("id");
		MemberService service = new MemberService();
		
		MemberVo vo = service.getMember(id);
		boolean flag = (vo==null);
		
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		String txt=obj.toJSONString();
		System.out.println(txt);
		
		return null;
	}

}
