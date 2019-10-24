<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.print("Tong: " + session.getAttribute("ss")); %>
	<form menthod ="post" action="tong.jsp">
	n=<input type ='text' name='txtn' value=''><br>
	<input type ='submit' name='but1' value='tong'>
	
	</form>
</body>
</html>