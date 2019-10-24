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
int n= Integer.parseInt(request.getParameter("txtn"));
//Xem thu sesion ss da tao ra hay chua
if(session.getAttribute("ss")==null)
	session.setAttribute("ss", 0);
//bi: gan session ra bien
int s=(int)session.getAttribute("ss");
//b2: thao tac tren bien
	s=s+n;
//b3: gan bien vao session
session.setAttribute("ss",s);
out.print("Tong: " + session.getAttribute("ss"));

%>
</body>
</html>