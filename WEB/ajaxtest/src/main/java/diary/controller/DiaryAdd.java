package diary.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import diary.DiaryService;
import diary.DiaryVo;

/**
 * Servlet implementation class DiaryAdd
 */
@WebServlet("/diary/add")
public class DiaryAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("view", "/diary/add.jsp");

		RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		
		int size = 100 * 1024 * 1024;
		MultipartRequest multipart = new MultipartRequest(request, DiaryService.path, size, "euc-kr", new DefaultFileRenamePolicy());
		
		String writer = multipart.getParameter("writer");
		String content = multipart.getParameter("content");
		System.out.println("writer : " + writer + "  content : " + content);
		
		File f1 = multipart.getFile("pic1");
		File f2 = multipart.getFile("pic2");
		File f3 = multipart.getFile("pic3");
		
		String fname1 = "nopic.png";
		String fname2 = "nopic.png";
		String fname3 = "nopic.png";
		
		if(f1 != null) {
			fname1 = f1.getName();
		}
		if(f2 != null) {
			fname1 = f2.getName();
		}
		if(f3 != null) {
			fname1 = f3.getName();
		}
		
		DiaryService service = new DiaryService();
		service.addDiary(new DiaryVo(0, writer, null, content, fname1, fname2, fname3));
	
		ArrayList<DiaryVo> list = service.getAll(writer);
		request.setAttribute("list", list);
		System.out.println("DiaryAdd.java list : "+list);
		
		response.sendRedirect(request.getContextPath() + "/diary/list");
	}

}
