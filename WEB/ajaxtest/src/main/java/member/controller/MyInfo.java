package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;
import member.MemberVo;

/**
 * Servlet implementation class MyInfo
 */
@WebServlet("/member/myinfo")
public class MyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		System.out.println("id :" + id);
		MemberService service = new MemberService();
		MemberVo m = service.getMember(id);
		System.out.print(m);
		request.setAttribute("m", m);
		request.setAttribute("view", "/member/myinfo.jsp");

		RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 여기 다시 확인
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberVo vo = new MemberVo(id, pwd, name, email);
		MemberService service = new MemberService();
		service.editMyInfo(vo);
		request.setAttribute("m", vo);
		request.setAttribute("view", "/member/myinfo.jsp");
		
		//RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
		//dis.forward(request, response);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
