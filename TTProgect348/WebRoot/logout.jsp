<%@ page language="java" import="java.util.*" pageEncoding="GB18030" 
contentType="text/html; charset=GB18030" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>¹Ø±ÕµÇÂ¼</title>
</head>
<body>
<%
session.invalidate();
out.println("<script language='javascript'>");
out.println("window.location.href='login.jsp'");
out.println("</script>");
%>	
</body>
</html>
