<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<a href="redirectadmin.jsp">admin</a>
<%if(request.getAttribute("dsloai")!=null){%>
<%loaibean theloai=new loaibean("","");
%>
<%if((loaibean)request.getAttribute("chonloai")!=null)
	{
	theloai=(loaibean)request.getAttribute("chonloai");
	}%>
<form action="loaiadmincontroller" method="post">
	<lable>maloai</lable>
	<input type="text" name="maloai" value="<%= theloai.getMaloai()  %>">
	<label>tenloai</label>
	<input type="text" name="tenloai" value="<%=theloai.getTenloai()%>">
	<input type="submit" name="them" value="them">
	<input type="submit" name="sua" value="sua">
</form>
<h2>danh sach cac loai</h2>
<table>
	<%for(loaibean loai:(ArrayList<loaibean>)request.getAttribute("dsloai")){
		%>
		<tr>
			<td><%=loai.getMaloai() %></td>
			<td><%=loai.getTenloai() %></td>
			<td><a href="loaiadmincontroller?mlchon=<%=loai.getMaloai()%>">chon</a></td>
			<td><a href="loaiadmincontroller?mlxoa=<%=loai.getMaloai()%>">xoa</a></td>
		</tr>
		<%
	} %>
</table>
<%}else{response.sendRedirect("loaiadmincontroller");} %>
</body>
</html>