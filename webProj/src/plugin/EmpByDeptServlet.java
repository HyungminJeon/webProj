package plugin;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;

@WebServlet("/empByDeptServlet")
public class EmpByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpByDeptServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		Map<String, Integer> map = dao.getEmployeeByDept();
		// [ ["Sales", 14] , ["Shipping", 5] , [....] ]
		String json = "[";
		
		Set<String> keySet = map.keySet(); // map의 key만 keySet에 담겠다
		Iterator<String> iter = keySet.iterator(); // Iterator : 반복자
		System.out.println(keySet);
		System.out.println(iter);
		
		while(iter.hasNext()) { // 다음에 가져올 게 있으면
			String key = iter.next(); // 부서 이름
			Integer val = map.get(key); // 사원수
			json += "[\""+key+"\","+ val +"]";
			
			if(iter.hasNext()) // 다음 것이 있을 때만 콤마
				json += ",";
		}
		json += "]";
		
		response.getWriter().print(json);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
