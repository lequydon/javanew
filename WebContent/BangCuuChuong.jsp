<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-8 col-sm-offset-2">
		<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">BẢNG CỬU CHƯƠNG TỪ 1 ĐẾN N</h3>
		  </div>
		  <div class="panel-body">
		    <form method="POST" class="form-horizontal" action="BangCuuChuong.jsp">
		    	<div class="col-sm-12">
		    		<div class="form-group">
	    			<label class="" for="txtNumber">Số N</label>
		    		<input class="form-control" name="txtNumber" type="text" placeholder="Nhập số n nhỏ hơn 10">
		    		</div>
		    		<div class="form-group">
	    			<button class="btn btn-primary" type="submit" name="btn-submit" value="Submit">In kết quả</button>
		    		</div>
		    	</div>
		    </form>
		  </div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="table-responsive clearfix">
		<% String value = request.getParameter("txtNumber"); 
	     if(value == null){
	    	 out.print("Load lan dau");
	    	 } 
		   else { 
			   Integer n = Integer.parseInt(value); 
		   %>
			<table class="table table-bordered">
				<% for(int i = 1; i <= 10; i++) {%>
				<tr>
					<%  for(int j = 1; j <= n; j++ ){ %>
					<td><%= j %> x <%= i %> = <%= i*j %></td>
					<% } %>
				</tr>
				<%} %>
			</table>
	<%} %>
	</div>
</body>
</html>