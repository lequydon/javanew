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
	if(session.getAttribute("loginID")==null)
	{
		session.setAttribute("linkdatmua","datmua.jsp");
		response.sendRedirect("DangNhap.jsp");
	}
	
	//session.removeAttribute("linkdatmua");
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
						<li><a href="logout.jsp?logoutfrom=datmua.jsp" class="nav-link">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
<main style="margin-top:200px;text-align:center">
	<h2>Chúng tôi sẽ hoàn thiện trang này sau !<br>do kinh phí có hạn</h2>
</main>
</body>
</html>