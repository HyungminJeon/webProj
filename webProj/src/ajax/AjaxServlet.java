package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  //웹페이지를 통해 servlet을 실행시키는 클래스
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//서블렛 이름을 ajax.html라고 하고 다른 html에서 ajax.html 페이지를 요청하겠다
@WebServlet("/ajax.html")        

public class AjaxServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpServletRequest 클래스가 클라이언트 요청을 받는다. 
		//HttpServletResponse 서버로부터 결괏값을 클라이언트쪽에 전달한다
		
		//get은 web페이지에서 호출
		String p1 = req.getParameter("p1");    //클라이언트가 요청한 값
		String p2 = req.getParameter("p2");
		resp.getWriter().print("<h1>Ajax Get Page</h1>");
		resp.getWriter().print("<h3>" +p1+ p2+"</h3>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.getWriter().print("<h1>Ajax Post Page</h1>");
	}

}
