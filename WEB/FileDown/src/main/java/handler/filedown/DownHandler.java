package handler.filedown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import filedown.FileDownService;
import filedown.FileDownVo;
import handler.Handler;

//url : /filedown/detail.do
public class DownHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		
		FileDownService service = new FileDownService();
		int num = Integer.parseInt(request.getParameter("num"));
		FileDownVo vo = service.b(num);
		
		if(request.getMethod().equals("GET")) {
			request.setAttribute("vo", vo);
			request.setAttribute("view", "/filedown/detail.jsp");
		} else {
			String fname = vo.getFname();
			String path = FileDownService.downDir + fname;

			File file = new File(path);

			try {
				FileInputStream  in = new FileInputStream(path);
				fname = new String(fname.getBytes("utf-8"), "8859_1");

				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment; filename=" + fname);

				OutputStream os = response.getOutputStream();

				int length;
				byte[] b = new byte[(int) file.length()];
				System.out.println("file.length() : " + file.length());
			

				while ((length = in.read(b)) > 0) {
					os.write(b, 0, length);
				}

				os.flush();
				os.close();
				in.close();
				
				service.editCnt(num);
				view = null;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return view;
	}

}
