package ajax;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/jquery/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init call()");
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service call()");
//		Enumeration<String> enumer = req.getHeaderNames();
//		while (enumer.hasMoreElements()) {
//			String key = enumer.nextElement();
//			String val = req.getHeader(key);
//			System.out.println(key + " : " + val);
//		}
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet call()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost call()");
		
		String path = "c:/tmp";
		ServletContext sc = this.getServletContext();       
		path = sc.getRealPath("upload");
		
		
		//D:\Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webProj
		//톰캣이 웹 페이지를 구동하고 정보를 저장하는 장소
		
		//D:\Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webProj\WEB-INF\classes\plugin
		//에 톰캣이 서블릿을 실행한 파일을 저장함
		
		MultipartRequest multi = new MultipartRequest(request, // 요청정보
				path, // 저장위치
				8 * 1024 * 1024, // 파일크기
				"UTF-8", // 인코딩 방식
				new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();
		while(en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String fileName = multi.getFilesystemName(name);
			System.out.println("name: " + name +", filename: " + fileName);
		}

	}

}
