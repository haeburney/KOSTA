package handler.imgboard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;

public class DelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\KOSTA\\Desktop\\webworkspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps";
		ImgBoardService service = new ImgBoardService();
		int num = Integer.parseInt(request.getParameter("num"));
		ImgBoardVo vo = service.getImg(num);
		String delf = path + vo.getPath();
		File f= new File(delf);
		f.delete();
		service.delImg(num);
		System.out.println("핸들러 삭제완");
		
		return null;
	}
}
