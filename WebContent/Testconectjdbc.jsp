<%@page import="dao.DungChung"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
try{
	DungChung dc=new DungChung();
	dc.KetNoi();
	out.print("ket noi thanh công");
}catch(Exception tt){
	out.print("ket noi that bại");
}
%>
</body>
</html>