package req;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import handler.member.JoinHandler;
import handler.member.LoginHandler;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
// 뷰 페이지 요청을 제외한 모든 요청이 여기로 온다.
// 그니까 do로 끝나는 모든 파일의 요청이 여기로 오는거임

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Handler> map = new HashMap<>();
	// commands.properties 파일의 url과 명령어를 읽어서 저장할 map

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 서블릿 생성시 딱 한 번 실행되는 메서드.
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		// 프롭으로 로드해서 담아?
		// 파람 경로를 웹에서 사용하는 실제 경로로 변환
		// 왜 가져오지?
		String path = this.getServletContext().getRealPath("/WEB-INF/commands.properties");
		//System.out.println("path : "+path);
		try {
			// command.properties 파일의 키, 값을 로드해서 prop에 저장
			// 파일의 내용이 변수 prop에 다 들어간다고?
			prop.load(new FileReader(path));
			Iterator iter = prop.keySet().iterator();
			//System.out.println("iter : "+iter);
			// 키만 뽑아서
			while (iter.hasNext()) {
				String url = (String) iter.next(); // member/join.do
				//System.out.println("init() url : " + url);
				
				

				try {
					String className = prop.getProperty(url); // handler.member.JoinHandler
					//System.out.println("className : " + className);
					// 밑에 3줄은 "JoinHandler h = new JoinHandler();" 이렇게 하는 것과 똑같은 코드이다.

					// Class : 클래스에 대한 정보 갖음. 클래스 이름, 멤버변수 이름/타입, 메서드 이름/프로토타입
					Class<?> handlerClass = Class.forName(className);
					// 클래스에 대한 정보를 갖는 객체를 리턴해준다?
					// 객체의 생성자가 필요하니까 생성자를 호출
					// 지정한 클래스 정보를 갖는 Class 객체 반환
					Constructor<?> cons = handlerClass.getConstructor(null);
					// 지정한 클래스의 객체를 생성할 생성자 반환
					Handler handler = (Handler) cons.newInstance();
					// handler 객체 생성
					map.put(url, handler);
					// 생성한 handler 객체를 url과 같이 map에 저장
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청을 처리한 뒤 뷰페이지 이동
		String url = request.getServletPath(); // 요청 url 반환 join.do
		System.out.println("doGet() url : " + url);
		// 인터페이스로 선언해준 이유는? 업캐스팅을 할려고
		// join 핸들러나 login핸들러를 다 담을수 있도록 하려면
		// 변수의 타입을 걔네들이 공통으로 상속을 받는 handler로 받아야 한다.

		String view = null;
		Handler handler = map.get(url); // 업캐스팅
		// url이 키값이야

		if (handler != null) {
			// 요청 처리 메서드 호출
			// 오우 이 해 안 가
			view = handler.process(request, response);

			if (view.startsWith("redirect")) {
				// 결과를 받은 view가 redirect로 시작하느냐?
				String[] path = view.split(":");
				response.sendRedirect(request.getContextPath() + path[1]);
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(view);
				dis.forward(request, response);
			}
		} else {
			response.getWriter().append("404 not found url");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
