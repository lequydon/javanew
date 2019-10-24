<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
						<li><a href="Dangnhap.jsp" class="nav-link">login</a></li>
						<li><a href="Dangnhap.jsp" class="nav-link">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
<form method="POST" action='localhost://3001/api/register'>
		<table align='center' width='1000' cellpadding="10">
		 <tr>
			 <td width='20%'>
			 		<lable>Username</lable>
			 </td>
		 	<td width='33%'>
		 		<input name='username' type='text' placeholder='Username'  />
		 	</td>
		 	<td width='33%'>
		 		<input name='name' type='text' placeholder='Ho va ten'  />
		 	</td>
		 </tr>
		 <tr>
		 	<td width='20%'>
			 		<lable>Password</lable>
			</td>
		 	<td width='33%'>
		 		<input name='password' type='password' placeholder='mat khau'  />
		 	</td>
		 	<td width='33%'>
				<select name='sex'>
					<option hidden selected='selected'>gioi tinh</option>
					<option value='nam'>Nam</option>
					<option value='nu'>Nu</option>
				</select>		 	
		 	</td>
		 </tr>
		  <tr>
		  	<td width='33%'>
			 		<lable>confirm password</lable>
			 </td>
		 	<td width='33%'>
		 		<input name='confirmpassword' type='password' placeholder='nhap lai mat khau'  />
		 	</td>
		 	<td width='33%'>
				<select name='date'>
					<option hidden selected='selected'>ngay</option>
					<option value='1'>1</option>
					<option value='2'>2</option>
				</select>	
				<select name='month'>
					<option hidden selected='selected'>thang</option>
					<option value='1'>1</option>
					<option value='2'>2</option>
				</select>	
				<select name='year'>
					<option hidden selected='selected'>nam</option>
					<option value='2001'>2001</option>
					<option value='2002'>2002</option>
				</select>				 	
		 	</td>
		 </tr>
		 <tr>
		 	<td>
		 		<input type='checkbox' name='isremember' />
		 		<label>remember me</label>
		 	</td>
		 </tr>
		 <tr>
		 	<td>
		 		<button type='submit'>Register</button>
		 	</td>
		 </tr>
		 </table>
		 </form>
</body>
</html>