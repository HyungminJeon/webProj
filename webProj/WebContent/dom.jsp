<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");  //사용자가 보낸 정보(id값으로 넘긴 값)을 받아서 넣어준다
	String name = request.getParameter("name");
	String score = request.getParameter("score");
	String gender = request.getParameter("gender");
	
	
	
	//html 형식으로 보여주기
	out.print("<ul>");
	out.print("<li>" + id + "</li>");
	out.print("<li>" + name + "</li>");
	out.print("<li>" + score + "</li>");
	out.print("<li>" + gender + "</li>");
	out.print("</ul>");
%>