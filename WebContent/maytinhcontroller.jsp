<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MayTinh </title>
</head>
<body>
<%
if(session.getAttribute("kq")!=null){
	out.print("ketqua: "+session.getAttribute("kq"));
}
%>
<form method ="get" action="TestController">
	a=<input type='number' name='txta' ><br>
	b=<input type='number' name='txtb' ><br>
	<input type='submit' name='but1' value='+'><br>
	<input type='submit' name='but1' value='-'><br>
	<input type='submit' name='but1' value='*'><br>
	<input type='submit' name='but1' value='/'>
</form>
</body>
</html>