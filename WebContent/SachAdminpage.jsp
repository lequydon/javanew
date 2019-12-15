<%@page import="bean.sachfullinfobean"%>
<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
<body>
<a href="redirectadmin.jsp">admin</a>
<div class="row">
<div class="col-3">
<%if(request.getAttribute("dssach")!=null){
	sachfullinfobean sachchon=new sachfullinfobean();
	if(request.getAttribute("sachchon")!=null){
		sachchon=(sachfullinfobean)request.getAttribute("sachchon");
	}
	%>
<form action="sachadmincontroller" type="post">
<label>Mã Sách</label><br>
<input type="text" name="masach" value="<%=sachchon.getMasach()%>"><br>
<label>Tên Sách</label><br>
<input type="text" name="tensach" value="<%=sachchon.getTensach()%>"><br>
<label>Tác Giả</label><br>
<input type="text" name="tacgia" value="<%=sachchon.getTacgia()%>"><br>
<label>Giá</label><br>	
<input type="number" name="gia" value="<%=sachchon.getGia()%>"><br>
<label>Số Lượng</label><br>
<input type="number" name="soluong" value="<%=sachchon.getSoluong()%>"><br>
<label>Ngày Nhập</label><br>
<input type="date" name="ngaynhap" value="<%=sachchon.getNgaynhap()%>"><br>
<label>Ảnh</label><br>
<input type="file" name="file" value="<%=sachchon.getAnh()%>"><br>
<label>Số tập</label><br>
<input type="number" name="sotap" value="<%=sachchon.getSotap()%>"><br>
<label>Loại sách</label><br>
<select name="loai" value="<%=sachchon.getMaloai()%>">
<% for(loaibean loai:(ArrayList<loaibean>)request.getAttribute("dsloai")){ %>
    <option value="<%=loai.getMaloai()%>"><%=loai.getTenloai() %></option>
    <%} %>
  </select>
<input type="submit" name="them" value="them">
<input type="submit" name="sua" value="sua">
</form>
</div>
<div class="col-9">
<div style="height:600px;overflow: scroll;">
<table class="table">
<thead>
    <tr>
      <th scope="col">mã sách</th>
      <th scope="col">tên sách</th>
      <th scope="col">tác giả</th>
      <th scope="col">số lượng</th>
      <th scope="col">số tập</th>
      <th scope="col">ảnh</th>
      <th scope="col">giá</th>
      <th scope="col">thao tác</th>
    </tr>
  </thead>
<tbody>
<% for(sachfullinfobean sach:(ArrayList<sachfullinfobean>)request.getAttribute("dssach")){ %>
<tr>
	<td><%=sach.getMasach() %></td>
	<td><%=sach.getTensach() %></td>
	<td><%=sach.getTacgia() %></td>
	<td><%=sach.getSoluong() %></td>
	<td><%=sach.getSotap() %></td>
	<td><%=sach.getAnh() %></td>
	<td><%=sach.getGia() %></td>
	<td><a href="sachadmincontroller?masachchon=<%=sach.getMasach()%>" style="margin-right:5px">chọn</a><a href="sachadmincontroller?masachxoa=<%=sach.getMasach()%>">xóa</a></td>
</tr>
	<%} %>
<%}else{
response.sendRedirect("sachadmincontroller");
} %>
</tbody>
</table>
</div>
</div>
</div>
</body>
</html>