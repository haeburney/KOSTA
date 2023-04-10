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
 * Servlet implementation class IdCheck
 */
@WebServlet("/member/idcheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("아아");
		String id = request.getParameter("id");
		System.out.println(id);
		MemberService service = new MemberService();
		MemberVo vo = service.getMember(id);
		boolean flag = (vo == null);
		System.out.println(flag);
		request.setAttribute("flag", flag);
		// flag : id 중복여부
		if(flag) { // id가 중복되지 않았다면
			request.setAttribute("id", id);
			// idcheck.jsp에 출력하기 위해서 request에 담음 
		}
		RequestDispatcher dis = request.getRequestDispatcher("/member/idcheck.jsp");
		dis.forward(request, response);
		// forward는 서버내에서 이동! 
		// post이기 때문에 다시 idcheck.jsp로 넘어가도 ${pageContext.request.methd}가 POST로 존재하는 것이다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
