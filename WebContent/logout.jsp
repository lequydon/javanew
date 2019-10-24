<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session.removeAttribute("loginID");
	session.removeAttribute("password");
	response.sendRedirect(request.getParameter("logoutfrom"));
%>
</body>
</html>