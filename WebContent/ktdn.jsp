<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Iutf-8">
<title>Insert title here</title>
</head>
<body>
<%
String u = request.getParameter("txtName");
String p = request.getParameter("txtPass");
if(u != null && p != null)
	if(u.equals("abc") && p.equals("123"))
		response.sendRedirect("maytinh.jsp");
	else
		response.sendRedirect("DangNhap.jsp?loginSuccess=false");
else
	response.sendRedirect("DangNhap.jsp");
%>
</body>
</html>