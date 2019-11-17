<%@page import="bean.Userbean"%>
<%@page import="bo.Userbo"%>
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
<%
	String linkredirect="SachController";
	System.out.print(session.getAttribute("linkdatmua"));
	if(session.getAttribute("linkdatmua")!=null)
	{
		linkredirect=session.getAttribute("linkdatmua").toString();
		System.out.print(linkredirect);
	}
	if(session.getAttribute("loginID")!=null)
	{
		response.sendRedirect("SachController");
	}
	/*if(request.getParameter("loginID")!=null){
		Userbo accountbo= new Userbo();
		Userbean account=accountbo.getuserbo();
		if(request.getParameter("loginID").equals(account.getEmail())&&request.getParameter("password").equals(account.getPassword()))
		{
			session.removeAttribute("linkdatmua");
			session.setAttribute("loginID",request.getParameter("loginID"));
			session.setAttribute("password", request.getParameter("password"));
			response.sendRedirect(linkredirect);
		}
		
	}*/
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
						<li><a href="DangNhap.jsp" class="nav-link">login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main>
	<form action="DangnhapController" class="hitec-form-signin" method="post">
		<div class="form-group">
			<label for="loginID">Email:</label> <input type="text" id="loginID"
				name="loginID" class="form-control input-lg" placeholder="Email"
				required="" autofocus="" value="">
		</div>
		<div class="form-group">
			<label for="password">Mật khẩu:</label> <input type="password"
				id="password" name="password" class="form-control input-lg"
				placeholder="Mật khẩu" required="" value="">
		</div>
		<div class="form-group">
			<span class="text-danger"></span>
		</div>
		<button class="btn btn-lg btn-primary btn-block btn-custom"
			type="submit">Đăng nhập</button>
		<!--<a href="#" class="forgot-password">Quên mật khẩu ?</a>-->
		<%
			if(request.getParameter("loginID")!=null){
			%><div style="color:red">lỗi đang nhập</div><%
		}
		%>
	</form>
	</main>
</body>
<style>
form {
	margin: 0 auto;
	width: 500px;
	margin-top: 100px;
}
</style>
</html>

