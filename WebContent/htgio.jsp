<%@page import="java.text.DecimalFormat"%>
<%@page import="bo.giohanhbo"%>
<%@page import="bean.giohangbean"%>
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
<body>
<%
giohanhbo Counttype=(giohanhbo)session.getAttribute("gh");
int Count=0;
try{
	Count=Counttype.Count();
}catch(Exception e){
	
}
	String dangn="none";
	String dangxua="none";
%>
<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
			role="navigation">
			<div class="container">
				<a class="navbar-brand" href="htsach.jsp">Brand</a>
				<button class="navbar-toggler border-0" type="button"
					data-toggle="collapse" data-target="#exCollapsingNavbar">
					&#9776;</button>
				<div class="collapse navbar-collapse" id="exCollapsingNavbar">
					<ul class="nav navbar-nav">
						<!-- <li class="nav-item"><a href="#" class="nav-link">About</a></li> -->
						<li class="nav-item"><a href="Info.jsp" class="nav-link">Link1</a></li>
						<li class="nav-item"><a href="buynow.jsp" class="nav-link">Link2</a></li>
						<!-- <li class="nav-item"><a href="#" class="nav-link">More</a></li> -->
					</ul>
					<ul class="nav navbar-nav flex-row justify-content-between ml-auto"
						style="color: white">
						<%
						if(session.getAttribute("loginID")==null)
						{
							dangn="inline";
							dangxua="none";
						}
						else{
							dangn="none";
							dangxua="inline";
						}
						%>
						<li><a href="DangNhap.jsp" style="display:<%=dangn %>" class="nav-link">login</a></li>
						<li><a href="logout.jsp?logoutfrom=htgio.jsp" style="display:<%=dangxua %>"class="nav-link">Logout</a></li>
						<li><a href="htgio.jsp" class="nav-link" style="display:inline">Giỏi hàng(<%=Count%>)</a></li>
					</ul>
				</div>
			</div>
		</nav>
</header>
<main style="margin-top:100px;">
	<%
	if(request.getParameter("soluong")!=null){
		giohanhbo gh=(giohanhbo)session.getAttribute("gh");
		for(giohangbean ghbean: gh.ds){
			if(ghbean.getMasach().equals(request.getParameter("msach")))
				ghbean.setSoluong(Long.parseLong(request.getParameter("soluong")));
				ghbean.setThanhtien(ghbean.getGia()*ghbean.getSoluong());
				//gh
				
		}
		request.getParameter("msach");
	}
	if(request.getParameter("masach")!=null){
		giohangbean tempdelete= new giohangbean();
		giohanhbo gh=(giohanhbo)session.getAttribute("gh");
		for(giohangbean ghbean: gh.ds){
			if(ghbean.getMasach().equals(request.getParameter("masach")))
				tempdelete=ghbean;
				
		}
		gh.ds.remove(tempdelete);
		//session.setAttribute("gh", gh);
	}
	if(session.getAttribute("gh")!=null){
	//lay session gan vao bien
	giohanhbo gh=(giohanhbo)session.getAttribute("gh");
	%>
	<table  class="table table-hover">
	<tr>
		<th>Mã sách</th>
		<th>Tên sách</th>
		<th>Giá sách</th>
		<th>Số lượng</th>
		<th>Thành tiền</th>
		<th>Mua</th>
	</tr>
	<% for (giohangbean g:gh.ds){ %>
	<tr>
		<td><%=g.getMasach()%></td>
		<td><%=g.getTensach()%></td>
		<td><%=g.getGia()%></td>
		<td><form method="POST" action="htgio.jsp"><input type="text" name="msach" value="<%=g.getMasach()%>" style="display:none"><input type="number" name="soluong" value="<%=g.getSoluong() %>" style="width:100px"><input type="submit" value="lưu"></form></td>
		<td><%=g.getThanhtien()%></td> 
		<td><a  href="datmua.jsp?masach=<%=g.getMasach()%>">mua</td>
		<td><a  href="htgio.jsp?masach=<%=g.getMasach()%>">xóa</a></td>
	</tr>
	<%} %>
	</table>
	<%DecimalFormat f=new DecimalFormat("###,###"); %>
	<h3 >Tổng: <%=f.format(gh.Sum())%></h3>
	<%} %>
</main>	
</body>
<style>
body{
	margin: 0 auto;
}
td,th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</html>