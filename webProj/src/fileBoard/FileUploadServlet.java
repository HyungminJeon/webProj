package fileBoard;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	//톱캣 컨테이너는 jsp, java를 해석하여 html로 출력한다.
			//서블릿을 요청하면  첫번째 요청이면 init() , service()를 실행해서
			//요청정보는 get방식이면  header에 값, url 입력한 값들은 바디영역에 key value 형식으로 나타낸다
			// 응답하는 정보를 response객체에 담아서 값을넘겨준다
	
	//아작스는 json 타입 데이터만 받는다
			
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		System.out.println("doPost call()");

		String path = "c:/tmp";
		ServletContext sc = this.getServletContext();
		path = sc.getRealPath("upload");

		
		// D:\Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webProj
		// 톰캣이 웹 페이지를 구동하고 정보를 저장하는 장소

		// D:\Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webProj\WEB-INF\classes\plugin
		// 에 톰캣이 서블릿을 실행한 파일을 저장함

		
		
      	//  ↓ request 객체,   ↓ 저장될 서버 경로,    ↓ 파일 최대 크기,  ↓ 인코딩 방식,     ↓ 같은 이름의 파일명 방지 처리
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// 아래와 같이 MultipartRequest를 생성만 해주면 파일이 업로드 된다.(파일 자체의 업로드 완료)
		MultipartRequest multi = new MultipartRequest(   
				request, // 요청정보
				path, // 저장위치
				8 * 1024 * 1024, // 파일크기
				"UTF-8", // 인코딩 방식
				new DefaultFileRenamePolicy());
		
		
		// MultipartRequest로 전송받은 데이터를 불러온다.
		// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.
		String author = multi.getParameter("author");
		String title = multi.getParameter("title");
		// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
		String fileN = multi.getFilesystemName("filename");
		fileN = null;
		
		Enumeration en = multi.getFileNames();
		
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String fileName = multi.getFilesystemName(name);
			fileN = fileName;
			System.out.println("name: " + name + ", filename: " + fileName);
		}
		
		//입력 후 저장된 값 가져오기
		FileDAO dao = new FileDAO();
		
		
		// 데이터들을 담을 그릇인 VO 객체를 생성 후, 데이터들을 set해준다.
		FileVO vo = new FileVO();
		vo.setAuthor(author);
		vo.setFileName(fileN);
		vo.setTitle(title);
		
		//데이터베이스에 입력
		FileVO rvo = dao.getInsertKeyVal(vo);
		
		
		
		//가져온 값을 json 형식으로 생성. {"num":?, "author":?, "title":?}
		JSONObject obj = new JSONObject();
		obj.put("num",rvo.getNum());
		obj.put("author", rvo.getAuthor());
		obj.put("title", rvo.getTitle());
		obj.put("day", rvo.getDay());
		obj.put("fileName", rvo.getFileName());
		
		response.getWriter().print(obj);
	}

}
