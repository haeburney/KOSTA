package filedown;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;

public class CntHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		FileDownService service = new FileDownService();
		int num = Integer.parseInt(request.getParameter("num"));
		FileDownVo vo = service.b(num);
		JSONObject obj = new JSONObject();
		obj.put("cnt", vo.getCnt());
		String txt = obj.toJSONString();
		String view = "responseboey:" + txt;
		
		return null;
	}

}
