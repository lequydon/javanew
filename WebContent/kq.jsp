<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	
		String nut=request.getParameter("but1");
		String aa=request.getParameter("txta");
		String bb=request.getParameter("txtb");
	if(aa!=null&&bb!=null){
		long a= Long.parseLong(aa);
		long b= Long.parseLong(bb);
		long kq=0;
		if(nut.equals("+")) kq=a+b;
		if(nut.equals("-")) kq=a-b;
		if(nut.equals("*")) kq=a*b;
		if(nut.equals("/")) 
				if(b==0)
					out.print("<script>alert('Bo tay');</script>");
				else
					kq=a/b;
		out.print(kq);
		
		
	}
		
	%>
</body>
</html>