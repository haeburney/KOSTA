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

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("AddHandler");
		String view = "/index.jsp";
		// get 일때
		if (request.getMethod().equals("GET")) {
			// 폼을 보여줘야죠
			request.setAttribute("view", "/imgboard/add.jsp");
		} else {
			String path = "C:\\Users\\KOSTA\\Desktop\\webworkspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";
			int size = 1024 * 1024 * 10;
			try {
				MultipartRequest multipart = new MultipartRequest(request, path, size, "utf-8",
						new DefaultFileRenamePolicy());
				String writer = multipart.getParameter("writer");
				String title = multipart.getParameter("title");
				String content = multipart.getParameter("content");

				File f = multipart.getFile("file");
				String fname = "/img/"+f.getName();

				ImgBoardService service = new ImgBoardService();
				service.addImg(new ImgBoardVo(0, writer, null, title, content, fname));
				System.out.println("add post");
				view = "redirect:/imgboard/list.do";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return view;
	}
}
