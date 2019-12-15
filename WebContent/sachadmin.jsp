<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body style="text-align:center">
<form action="" type="POST">
<label>Mã Sách</label><br>
<input type="text" name="masach"><br>
<label>Tên Sách</label><br>
<input type="text" name="tensach"><br>
<label>Tác Giả</label><br>
<input type="text" name="tacgia"><br>
<label>Giá</label><br>	
<input type="number" name="gia"><br>
<label>Số Lượng</label><br>
<input type="number" name="masach"><br>
<label>Ngày Nhập</label><br>
<input type="date" name="masach"><br>
<label>Ảnh</label><br>
<input type="file" name="masach"><br>
<label>Số tập</label><br>
<input type="number" name="masach"><br>
<label>Mã Loại</label><br>
<select name="cars">
<% for(loaibean loai:(ArrayList<loaibean>)request.getAttribute("dsloai")){ %>
    <option value=""><%=loai %></option>
    <%} %>
  </select>
<input type="submit" name="them" value="them">
<input type="submit" name="sua" value="sua">
</form>
<table>
<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td><a>chọn</a><a>xóa</a></td>
</tr>
</table>
</body>
</html>