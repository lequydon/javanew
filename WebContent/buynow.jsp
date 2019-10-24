<%@page import="bean.giohangbean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bo.giohanhbo"%>
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
	String ms= request.getParameter("ms");
	String ts= request.getParameter("ts");
	String tam= request.getParameter("gia");
	Long gia=(long)0;
	giohanhbo gh=null;
	if(tam!=null){
		gia=Long.parseLong(tam);
		if(session.getAttribute("gh")==null){ //Neu mua lan dau
			gh= new giohanhbo(); //tao ra mot gio hang
			session.setAttribute("gh", gh);//tao session de luu gh
		}
		gh=(giohanhbo)session.getAttribute("gh");
		gh.Add(ms, ts, "hh", gia, (long)1);
		
		session.setAttribute("gh", gh);
	}
	
	response.sendRedirect("htgio.jsp");
	
%>
</body>
</html>