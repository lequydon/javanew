<%@page import="bean.loaibean"%>
<%@page import="bo.giohanhbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.sachdao"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	giohanhbo Counttype=(giohanhbo)session.getAttribute("gh");
	int Count=0;
	try{
		Count=Counttype.Count();
	}catch(Exception e){
		
	}
	session.removeAttribute("linkdatmua");
	String dangn="none";
	String dangxua="none";
%>
<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
			role="navigation">
			<div class="container">
				<a class="navbar-brand" href="#">Brand</a>
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
						<li><a href="DangNhapController" style="display:<%=dangn %>" class="nav-link">login</a></li>
						<li><a href="logout.jsp?logoutfrom=htsach.jsp" style="display:<%=dangxua %>"class="nav-link">Logout</a></li>
						<li><a  class="nav-link" style="display:inline">Giỏ hàng(<%=Count%>)</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
<main style="margin-top:100px">

<div class="row">
	<div class="col-2">
	<ul class="list-group">
		<%
		if(request.getAttribute("ds")!=null)
		{
			ArrayList<loaibean> loai=new ArrayList<loaibean>();
			loai=(ArrayList<loaibean>)request.getAttribute("loai");
			int loaisize=loai.size();
			for(int i=0;i<loaisize;i++){
				loaibean listloai=loai.get(i);
				%>
				<li class="list-group-item"><a href="SachController?maloai=<%=listloai.getMaloai()%>"><%=listloai.getTenloai() %></a></li>
				<%
				//out.print(listloai.getTenloai());
		}
		//get loai sach
		%>
	</ul>
	</div>
	<div class="col-8">
		<table align="center" width = "1000">
			<%
			//get sach
			ArrayList<sachbean> ds= new ArrayList<sachbean>();
			ds= (ArrayList<sachbean>)request.getAttribute("ds");
			int ss=ds.size();
			for(int i=0;i<ss;i++){
				sachbean s = ds.get(i);
			%>
			<tr>
			<td>
			<img src='<%=s.getAnh() %>' width='200' height='200'><br>
			<%=s.getTensach() %><br>
			<%=s.getGia() %><br>
			<a href="buynow.jsp?ms=<%=s.getMasach() %>&ts=<%=s.getTensach() %>&gia=<%=s.getGia() %>">
			<img src='buynow.jpg'></a><hr>
			</td>
			<% i++;
			if(i<ss){
				s=ds.get(i);
			%>
			<td>
			<img src='<%=s.getAnh() %>' width='200' height='200'> <br>
			<%=s.getTensach() %><br>
			<%=s.getGia() %><br>
						<a href="buynow.jsp?ms=<%=s.getMasach() %>&ts=<%=s.getTensach() %>&gia=<%=s.getGia() %>">
			<img src='buynow.jpg'></a><hr>
			</td> </tr>
			<%} }}
			else
			response.sendRedirect("SachController");%>
		</td> 
		
		</table>
	</div>
	<div class="col-2">
		<form action="SachController">
      		<input type="text" placeholder="Search.." name="search">
      		<button type="submit">tìm kiếm</button>
    	</form>
	</div>
</div>
</main>
</body>
<%
	/*int gt1=(int)request.getAttribute("gt1");
	String gt2=(String)request.getAttribute("gt2");
	String[] gt3=(String[]) request.getAttribute("gt3");
	out.print("gt1="+gt1+"<hr>");
	out.print("gt2="+gt2+"<hr>");
	for(String st:gt3)
		out.print(st+":");*/
%>
<%
	/*ArrayList<sachbean>dstemp =(ArrayList<sachbean>)request.getAttribute("ds");*/
%>
<%
	/*if(session.getAttribute("mail")!=null){
		out.print("xinchao: "+session.getAttribute("mail"));
	}*/
%>
</html>

