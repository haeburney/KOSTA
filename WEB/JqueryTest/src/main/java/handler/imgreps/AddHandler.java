package handler.imgreps;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;
import imgreps.ImgRepService;
import imgreps.ImgRepVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("gkdldldldl");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		System.out.println("하이이이잉");
		int pnum = Integer.parseInt(request.getParameter("num"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		ImgRepService service = new ImgRepService();
		service.addRep(new ImgRepVo(0, pnum, writer, content));
		
		// 밥오야! 어레이리스트에 담아서 보내줘야지~!!!
		
		ArrayList<ImgRepVo> list = service.getReps(pnum);
		
		JSONArray arr = new JSONArray();
		for(ImgRepVo vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("writer", vo.getWriter());
			obj.put("content", vo.getContent());
			arr.add(obj);
		}
		
		String txt = arr.toJSONString();
		System.out.println(txt);
		
		JSONObject obj = new JSONObject();
		obj.put("writer", writer);
		obj.put("content", content);
		String txt2 = obj.toJSONString();
		
		return "responsebody/" + txt;
	}
}
