package ajaxtest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonTest1
 */
@WebServlet("/json/test1")
public class JsonTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String txt = "[{\"num\":1, \"name\" : \"aaa\", \"tel\": \"111\"}, {\"num\":2, \"name\" : \"bbb\", \"tel\": \"222\"}, {\"num\":3, \"name\" : \"bbb\", \"tel\": \"333\"}]";
		JSONObject obj1 = new JSONObject();
		obj1.put("num", 1);
		obj1.put("name", "aaa");
		obj1.put("tel", "111");
		
		JSONObject obj2 = new JSONObject();
		obj2.put("num", 2);
		obj2.put("name", "bbb");
		obj2.put("tel", "222");
		
		JSONObject obj3 = new JSONObject();
		obj3.put("num", 3);					// {"num" : 3}
		obj3.put("name", "ccc");			// {"num" : 3, "name" : "ccc"} 
		obj3.put("tel", "333");				// {"num" : 3, "name" : "ccc", "tel" : "333"}
		
		JSONArray arr = new JSONArray();
		arr.add(obj1);
		arr.add(obj2);
		arr.add(obj3);
		
		String txt = arr.toJSONString();
		response.getWriter().append(txt);
		// 데이터를 분석하는 것이 파싱이다. 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
