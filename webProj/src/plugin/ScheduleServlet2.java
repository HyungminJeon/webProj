package plugin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;
import common.ScheduleVO;

/**
 * Servlet implementation class ScheduleServlet2
 */
@WebServlet("/ScheduleServlet2")
public class ScheduleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScheduleServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한 건 입력.. title, start, end
		String title = request.getParameter("title");
		
		ScheduleVO vo = new ScheduleVO();
		vo.setTitle(title);
		
		EmpDAO dao = new EmpDAO();
		dao.deleteSchedule(vo);
	}

}
