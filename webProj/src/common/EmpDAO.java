package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	
	public int deleteEmpById(Employee emp) {
		conn = DBCon.getConnect();
		int r = 0;
		
		String sql = "delete from emp_temp where employee_id = ?";
		try {	
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			r = psmt.executeUpdate();
			System.out.println(r+"건 입력됨");
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public Employee insertEmpBySeq(Employee emp) {
		conn = DBCon.getConnect();
		Employee empl = new Employee();
		
		
		String sql1 = "select employees_seq.nextval from dual";
		String sql2 = "insert into emp_temp(employee_id, last_name, email, hire_date, job_id, department_id, salary, first_name) values (?, ?, ?, ?, ?, 50, ?, ?)";
		try {
			int empId = 0;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if(rs.next()) {
				empId = rs.getInt(1);
			}
			
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, empId);
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			psmt.setInt(6, emp.getSalary());
			psmt.setString(7, emp.getFirstName());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력됨");
			
			empl.setEmployeeId(empId);
			empl.setEmail(emp.getEmail());
			empl.setLastName(emp.getLastName());
			empl.setHireDate(emp.getHireDate());
			empl.setJobId(emp.getJobId());
			empl.setFirstName(emp.getFirstName());
			empl.setSalary(emp.getSalary());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empl;
	}
	
	public void insertEmp(Employee emp) {
		String sql = "insert into emp_temp(employee_id, last_name, email, hire_date, job_id)"
				+ "values ((select max(employee_id)+1 from emp_temp), ?, ?, ?, ?)";
		conn = DBCon.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHireDate());
			psmt.setString(4, emp.getJobId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(psmt != null) {
				try {
					psmt.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}			
		}
	}
	
	public List<Employee> getEmpByDept(String dept) {
		
		String sql = "select * from emp_temp where department_id ="+dept
				+" order by employee_id";
		conn = DBCon.getConnect();
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				employees.add(emp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			
		}
		return employees;
	}
	
	public List<Employee> getEmpList() {
		
		String sql = "select * from emp_temp order by employee_id";
		conn = DBCon.getConnect();
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				employees.add(emp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			
		}
		return employees;
	}
public List<Employee> getEmployeeList() {
		
		String sql = "select * from empl_demo order by employee_id";
		conn = DBCon.getConnect();
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				
				employees.add(emp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			
		}
		return employees;
	} 
	public Map<String, Integer> getEmployeeByDept() { // 키 : 밸류
		// 부서명, 사원수
		Map<String, Integer> map = new HashMap<>();
		
		String sql = "select department_name, count(1)\r\n"
				+ "from empl_demo e, departments d\r\n"
				+ "where e.department_id = d.department_id\r\n"
				+ "group by department_name";
		conn = DBCon.getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) { // map 안에 돌면서 첫, 둘째 칼럼을 키 : 밸류 로 넣음
				map.put(rs.getString(1), rs.getInt(2));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(rs!=null)
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(rs!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return map;
	}
}
