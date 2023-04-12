package handler.filedown;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filedown.FileDownService;
import filedown.FileDownVo;
import handler.Handler;

//url : /filedown/list.do
public class ListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ListHandler");
		String id = request.getParameter("id");
		FileDownService service = new FileDownService();
		ArrayList<FileDownVo> list = service.c();
		request.setAttribute("list", list);
		request.setAttribute("view", "/filedown/list.jsp");
		
		return "/index.jsp";
	}

}
