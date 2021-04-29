package ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBCon;
import oracle.net.aso.r;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/jquery/memberServlet.do")          //서블릿 페이지명
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberServlet() {
        super();             //따로 요청된게 없을 때
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//조회작업
		response.setContentType("text/html;charset=UTF-8");   // 깨지는 한글을 인코딩
		
		//조회 sql을 작성하시오
		Connection conn = DBCon.getConnect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select member_id, member_name, member_age from member";
		String json = "[";
		
		try {
			psmt = conn.prepareStatement(sql
					,ResultSet.TYPE_SCROLL_INSENSITIVE
					,ResultSet.CONCUR_UPDATABLE);

			rs = psmt.executeQuery();
			while(rs.next()) {
				String memId = rs.getString(1);
				String memName = rs.getString(2);
				int memAge = rs.getInt(3);
				
				json += "{\"id\":\"" + memId 
						+ "\",\"name\":\"" + memName + 
						"\",\"age\":" + memAge + "}";
				
				if(!rs.isLast())
					json += ",";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (psmt!=null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		json += "]";
		//조회 결과를 json형식으로 작성해보시오
//		[{"id":1,"name":"hong","age":20},
//		{"id":1,"name":"hong","age":20}]
				
		response.getWriter().print(json);
		}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력작업
		
		
		String p1 = request.getParameter("m_id");   //form 태그안에 읿력된 name 속성의 이름
		String p2 = request.getParameter("m_name");  
		String p3 = request.getParameter("m_age");
		
		Connection conn = DBCon.getConnect();
		String sql = "insert into member values(?,?,?)";
		
		
		PreparedStatement psmt = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p1);
			psmt.setString(2, p2);
			psmt.setString(3, p3);
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if(psmt!=null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//{"id":1,"name":"hong","age":20}
		String json = "{\"id\":" + p1+ ",\"name\":\"" +p2+ "\",\"age\":" +p3 + "}";
		
		response.getWriter().print(json);
		
	}

}
