<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MayTinh </title>
</head>
<body>
<%	    long kq=0,a=0,b=0;
		String nut=request.getParameter("but1");
		String aa=request.getParameter("txta");
		String bb=request.getParameter("txtb");
	if(aa!=null&&bb!=null&&nut!=null){
		a= Long.parseLong(aa);
		 b= Long.parseLong(bb);
		if(nut.equals("+")) kq=a+b;
		if(nut.equals("-")) kq=a-b;
		if(nut.equals("*")) kq=a*b;
		if(nut.equals("/")) 
				if(b==0)
					out.print("<script>alert('Bay roi');</script>");
				else
					kq=a/b;
		
	}
		
	%>
<form method ="post" action="maytinh.jsp">
	a=<input type='number' name='txta' value='<%=(aa==null?"":aa)%>'><br>
	b=<input type='number' name='txtb' value='<%=(bb==null?"":bb)%>'><br>
	kq=<input type='number' name='txtkq' value='<%=kq%>'><br>
	<input type='submit' name='but1' value='+'><br>
	<input type='submit' name='but1' value='-'><br>
	<input type='submit' name='but1' value='*'><br>
	<input type='submit' name='but1' value='/'>
</form>
</body>
</html>