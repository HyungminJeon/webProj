package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/empList.do") // servlet을 실행할 때 여는 페이지의 이름을 /emplist로 하겠다라는 의미 (페이지의 주소)
//실핼 시 = http://localhost/webProj/empList 서버 /포트/ 프로젝트/ 페이지명

public class EmpServlet extends HttpServlet { // httpservlet를 상속받으면 /empList.do를 페이지로 실행

	// post 방식으로 호출
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//	}

	@Override
	// get 방식으로 호출
	// HttpServletRequest:사용자의 요청에 반응하는 정보를 담고, HttpServletResponse: 정보를 전송
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		PrintWriter out = resp.getWriter(); // getWriter() : 사용자의 요청에 반응하는 정보를 담아 전송하는 class

		// req : 사용자 요청정보를 처리해주는 메서드.
		// 클라이언트 실행 시 그중 dept라는 값이 있으면 String dept에 넣음.  Ex) xhtp.open('get', 'empList.do?dept=50')
		String dept = req.getParameter("dept");
		
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = null;
		
		if (dept == null) {
			list = dao.getEmpList();
		} else {
			list = dao.getEmByDept(dept);
		}

		
		
		
		
		//Text를 Json 형식으로 바꿔주는 부분
		
		String jsonData = "[";

		// [{"empId":"?", "fName":"?", "IName":"?"}....]
//		out.println("{\"name\":\"Hong\",\"name:\"\"Hong\"}");   // {} : html에 텍스트 타입을 입력할 때 쓴다      

		int cnt = 0;
		
		for (Employee emp: list) {
			jsonData += "{\"empId\":\"" + emp.getEmployeeId() 
			+ "\", \"fName\":\"" +emp.getFirstName() 
			+ "\", \"IName\":\"" +emp.getLastName() 
			+ "\", \"email\":\"" +emp.getEmail() 
			+ "\", \"salary\":\"" +emp.getSalary() 
			+  "\"}";
			
			if(++cnt == list.size()) {
				continue;                  //반복문안에 continue 가 있으면 다음 구문 실행안한다.
			}
			jsonData += ",";
		}
		
		jsonData +=  "]";
		
		out.println(jsonData);
	}
	
	
	
	
	//input text 넣는 부분
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String lastName = req.getParameter("last_name");
			String email = req.getParameter("email");
			String hireDate = req.getParameter("hire_date");
			String jobId = req.getParameter("job_id");
			
			Employee emp = new Employee();
			emp.setLastName(lastName);
			emp.setEmail(email);
			emp.setHireDate(hireDate);
			emp.setJobId(jobId);
			
			EmpDAO dao = new EmpDAO();
			dao.insertEmp(emp);   //serveret
			
			resp.getWriter().print("<h1>Success</h1>");
			
		}
	
}
