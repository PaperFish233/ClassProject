<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<% 
	    request.setCharacterEncoding("gb18030"); 
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������</title>


  </head>
  
  <body>
<!--�����û����Ͳ�ͬ��ѡ��ͬ������-->
<%
    if((Integer)session.getAttribute("Uauthority")==1){%>
    
     <%@include file="admins_menu.jsp" %>
       <h1 style="margin-top:12%;" align="center">��ӭ<font color=Red>����Ա��${sessionScope.Uname}</font>��¼�������ϵͳ��</h1><br>
     <%
    }else{%>
       <%@include file="users_menu.jsp" %>
       <h1 style="margin-top:12%;" align="center">��ӭ<font color=Blue>�û���${sessionScope.Uname}</font>��¼�������ϵͳ��</h1><br>
    <% 
    }
    %>
    
 <div class="layui-form-item" style="margin-top:15%;">
 </div>
    
       <%@ include file="copyright.jsp"%>
  </body>
</html>
